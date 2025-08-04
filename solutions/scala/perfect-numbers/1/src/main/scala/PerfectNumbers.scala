object PerfectNumbers {

	object NumberType {
		sealed trait EnumVal
		case object Perfect extends EnumVal
		case object Abundant extends EnumVal
		case object Deficient extends EnumVal
	}	

	def classify(num: Int): Either[String, NumberType.EnumVal] = {
		factors(num).sum match {
			case _ if num <= 0 => Left("Classification is only possible for natural numbers.")
			case x if x == num => Right(NumberType.Perfect)
			case x if x > num  => Right(NumberType.Abundant)
			case x if x < num  => Right(NumberType.Deficient)
		}
	}

	private def factors(num: Int) = {
		(1 until num).filter(num % _ == 0)
	}

}