case class Matrix(str: String) {

	lazy val splits = str.split("\n")

	def rows(num: Int) = {
		splits(num).split(" ").map(_.toInt)
	}

	def cols(num: Int) = {
		splits.map(_.split(" ")(num)).map(_.toInt)
	}

}