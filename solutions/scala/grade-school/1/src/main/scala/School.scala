import scala.collection.immutable.ListMap

class School {

	private var database: DB = Map[Int, Seq[String]]()

  type DB = Map[Int, Seq[String]]

  def add(name: String, g: Int) = {
  	val names = database.getOrElse(g, Seq())
  	database = database + (g -> (names ++ Seq(name)))
  }

  def db: DB = database

  def grade(g: Int): Seq[String] = {
  	database.getOrElse(g, Seq())
  }

  def sorted: DB = {
  	database
  	.toSeq
  	.map(t => t._1 -> t._2.sorted)
  	.sortWith(_._1 < _._1)
  	.toMap
  }
}