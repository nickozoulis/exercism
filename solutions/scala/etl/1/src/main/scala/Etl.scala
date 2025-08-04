object Etl {
	
	def transform(input: Map[Int, Seq[String]]): Map[String, Int] = {
		input.foldLeft(Map[String, Int]()) { case (acc, (k, v)) =>
			acc ++ v.foldLeft(Map[String, Int]()) { case (acc2, x) => acc2 + (x.toLowerCase -> k)}
		}
	}

}