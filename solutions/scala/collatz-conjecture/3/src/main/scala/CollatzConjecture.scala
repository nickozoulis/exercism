object CollatzConjecture {	
	@scala.annotation.tailrec
	def steps(n: Int, acc: Int = 0): Option[Int] = {
		n match {
			case 0               => None
			case 1               => Some(acc)
			case x if n < 0      => None
			case x if n % 2 == 0 => steps(n / 2, acc + 1)
			case _               => steps(3 * n + 1, acc + 1)
		}
	}
}