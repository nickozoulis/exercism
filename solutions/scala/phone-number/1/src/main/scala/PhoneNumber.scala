object PhoneNumber {
	
	def clean(str: String): Option[String] = {
		val filtered = str.filter(_.isDigit)

		filtered.length match {
			case l if l == 11  => if (filtered.head.equals('1')) processCodes(filtered.tail) else None
			case l if l == 10 => processCodes(filtered)
			case _ => None
		}
	}

	private def processCodes(str: String): Option[String] = {
		if (isAreaCodeValid(str) && isExchangeCodeValid(str)) Some(str) else None
	}

	private def isAreaCodeValid(str: String): Boolean = {
		val head = str.substring(0, 3).head
		!head.equals('0') && !head.equals('1')
	}

	private def isExchangeCodeValid(str: String): Boolean = {
		val head = str.substring(3, 6).head
		!head.equals('0') && !head.equals('1')
	}
}