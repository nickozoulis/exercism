object SecretHandshake {

	val signals = Array("wink", "double blink", "close your eyes", "jump", "reverse")
	
	def commands(num: Int) = {
		val decodedList = num
		                  .toBinaryString
		                  .reverse
		                  .zipWithIndex
		                  .filter(_._1 == '1')
		                  .map(t => signals(t._2))

		if (decodedList.length == 0)
			List()
		else	
			decodedList.last match {
				case "reverse" => decodedList.dropRight(1).reverse
				case _         => decodedList
		}
	}

}