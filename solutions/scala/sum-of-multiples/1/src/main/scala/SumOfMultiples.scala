object SumOfMultiples {

	val multiples = (x: Int, y: Int) => (1 to y).map(_ * x)

  	def sum(factors: Set[Int], lim: Int): Int = {
  		val (res: Int, _) =
  			factors
  			.flatMap(multiples(_, lim))
  			.fold((0, lim)) { case ((acc: Int, lim: Int), i: Int) =>
  				(i < lim) match {
  					case true  => (acc + i, lim)
  					case false => (acc, lim)
  				}
  			}
  		res
  	}
  		
  	
}