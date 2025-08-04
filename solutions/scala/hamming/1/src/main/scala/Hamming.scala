object Hamming {

	def distance(leftStrand: String, rightStrand: String): Option[Int] = {
		val leftList = leftStrand.toList
		val rightList = rightStrand.toList
	
		leftList.length == rightList.length match {
			case true =>
				val res = 
			 		for (i <- 0 until leftList.length if (leftList(i) != rightList(i))) 
			 			yield 1

			 	Some(res.sum)
		 	case false => None
	  }
	}

}