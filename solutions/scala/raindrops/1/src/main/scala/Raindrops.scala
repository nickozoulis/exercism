object Raindrops {
  def convert(n: Int): String = {
  	val res = 
	  	(1 to n)
	  	.filter(n % _ == 0)
	  	.foldLeft("") { case (acc, x) =>
	  		x match {
	  			case 3 => acc ++ "Pling"
	  			case 5 => acc ++ "Plang"
	  			case 7 => acc ++ "Plong"
	  			case _ => acc
	  		}
	  	}

	  res.isEmpty match {
	  	case true  => n.toString
	  	case false => res
	  }
  }
}