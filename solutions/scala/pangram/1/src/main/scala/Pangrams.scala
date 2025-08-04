object Pangrams {

	val lower_case = 'a' to 'z' 
	val alphabet = lower_case.foldLeft(Map[Char, Boolean]()) {case (acc, letter) => acc + (letter -> false)}

  def isPangram(input: String): Boolean = {
  	input
  	.foldLeft(alphabet) { case (acc, letter) =>
  		Character.toLowerCase(letter) match {
  	 		case x if lower_case contains x => acc + (x -> true)
  	 		case _ => acc
  		}
  	}
  	.forall { case (_, v) => v == true }
  }
}