import scala.util.Random
import collection.mutable

class Robot {
	var name = computeName()

	private def computeName(): String = {
		var str = ""

		do {
			str = randomChar + randomChar + randomInt + randomInt + randomInt
		} while (Robot.alreadySet.contains(str))

		Robot.alreadySet += str

		str
	}

	def reset() = {
		this.name = computeName()
	}

	private def randomChar() = {
		(90 - Random.nextInt(26)).toChar.toString
	}

	private def randomInt() = {
		9 - Random.nextInt(10)
	}
}

object Robot {
	val alreadySet = mutable.HashSet.empty[String]
}