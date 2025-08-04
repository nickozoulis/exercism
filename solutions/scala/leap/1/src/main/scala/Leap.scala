object Leap {
  def leapYear(year: Int): Boolean = {
  	isEvenlyDivisibleBy4(year) && !isEvenlyDivisibleBy100(year) || isEvenlyDivisibleBy400(year)
  }

  private def isEvenlyDivisibleBy4(num: Int): Boolean = {
  	num % 4 == 0
  }

  private def isEvenlyDivisibleBy100(num: Int): Boolean = {
  	num % 100 == 0
  }

  private def isEvenlyDivisibleBy400(num: Int): Boolean = {
  	num % 400 == 0
  }
}