object SpaceAge {

	val earthOrbital: Double = 365.25
	
	def onEarth(age: Double): Double = {
		calculateAge(age, earthOrbital)
	}
	
	def onMercury(age: Double): Double = {
		calculateAge(age, 0.2408467 * earthOrbital)
	}
	
	def onVenus(age: Double): Double = {
		calculateAge(age, 0.61519726 * earthOrbital)
	}

	def onMars(age: Double): Double = {
		calculateAge(age, 1.8808158 * earthOrbital)
	}

	def onJupiter(age: Double): Double = {
		calculateAge(age, 11.862615 * earthOrbital)
	}

	def onSaturn(age: Double): Double = {
		calculateAge(age, 29.447498 * earthOrbital)
	}

	def onUranus(age: Double): Double = {
	calculateAge(age, 84.016846 * earthOrbital)
	}

	def onNeptune(age: Double): Double = {
		calculateAge(age, 164.79132 * earthOrbital)
	}

	private def calculateAge(age: Double, orbital: Double): Double = {
		roundTwoDecimals(age / (orbital * 24 * 60 * 60))
	}

	private def roundTwoDecimals(num: Double): Double = {
		BigDecimal(num).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
	}

}