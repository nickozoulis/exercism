import Bearing.EnumVal

case class Robot(bearing: EnumVal, coordinates: Tuple2[Int, Int]) {

	def advance = {
		bearing match {
			case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
			case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
			case Bearing.West  => Robot(bearing, (coordinates._1 - 1, coordinates._2))
			case Bearing.East  => Robot(bearing, (coordinates._1 + 1, coordinates._2))
		}
	}

	def turnLeft = {
		bearing match {
			case Bearing.North => Robot(Bearing.West, coordinates)
			case Bearing.West  => Robot(Bearing.South, coordinates)
			case Bearing.South => Robot(Bearing.East, coordinates)
			case Bearing.East  => Robot(Bearing.North, coordinates)
		}
	}

	def turnRight = {
		bearing match {
			case Bearing.North => Robot(Bearing.East, coordinates)
			case Bearing.East  => Robot(Bearing.South, coordinates)
			case Bearing.South => Robot(Bearing.West, coordinates)
			case Bearing.West  => Robot(Bearing.North, coordinates)
		}
	}

	def simulate(str: String) = {
		str.foldLeft(this) { case (robot, char) => robot.translate(char) }
	}

	private def translate(char: Char) = {
		char match {
			case 'R' => this.turnRight
			case 'A' => this.advance
			case 'L' => this.turnLeft
		}
	}

}

object Bearing {
	sealed trait EnumVal
	case object North extends EnumVal
	case object South extends EnumVal
	case object West extends EnumVal
	case object East extends EnumVal
}