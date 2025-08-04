object Hamming {

	def distance(leftStrand: String, rightStrand: String): Option[Int] = {
		val leftList = leftStrand.toList
		val rightList = rightStrand.toList
		
		leftList.length == rightList.length match {
			case true =>
				leftList.zip(rightList)
				.foldLeft(Some(0)) { case (acc: Some[Int], (a: Char, b: Char)) =>
					a == b match {
						case false => Some(acc.get + 1)
						case true  => acc
					}
				}
			case false => None
		}
	}	

}