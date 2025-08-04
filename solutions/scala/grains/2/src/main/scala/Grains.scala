object Grains {
	def square(n: Int): Option[BigInt] = {
		n match {
			case _ if n < 1 || n > 64 => None
			case _ => Some(BigInt(2).pow(n - 1))
		} 
	}

	def total: BigInt = {
		(1 to 64).flatMap(square).sum
	}
}