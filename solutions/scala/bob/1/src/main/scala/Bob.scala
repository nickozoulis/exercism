object Bob {

  def response(statement: String): String = {
  	val str = statement.trim()
  	val predicate = (isQuestion(str), isYelling(str), isEmpty(str))

  	predicate match {
  		case (true, false, _) => "Sure."	
  		case (_, true, _)     => "Whoa, chill out!"
  		case (_, _, true)     => "Fine. Be that way!"
  		case _                => "Whatever."
  	}
  }

  private def isQuestion(str: String): Boolean = {
  	str.endsWith("?")
  }

  private def isYelling(str: String): Boolean = {
  	hasCapitalWords(str)
  }

  private def isEmpty(str: String): Boolean = {
  	str.trim().length == 0
  }

  private def hasExclamation(str: String) = {
  	str.endsWith("!")
  }

  private def hasCapitalWords(str: String) = {
  	val filtered = 
  		str
  		.split(" ")
  	  .filter(!isNumber(_))
  	  .filter(hasLetters)
  	
  	if (filtered.length == 0)
  		false
  	else
  	 	filtered
  		.map(isCapital(_))
  		.forall(_ == true)
  }

  private def isCapital(str: String): Boolean = {
  	str.toUpperCase.equals(str)
  }

  private def isNumber(str: String): Boolean = {
  	str.exists(Character.isDigit)
  }

  private def hasLetters(str: String): Boolean = {
  	str
  	.map(_.isLetter)
  	.exists(_ == true)
  }

}