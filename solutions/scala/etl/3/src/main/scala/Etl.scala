object Etl {
	
	def transform(input: Map[Int, Seq[String]]): Map[String, Int] = {
		input.foldLeft(Map[String, Int]()) { case (acc, (k, v)) =>
			acc ++ v.map(_.toLowerCase).zipAll(List(k), "", k).toMap
		}
	}

}