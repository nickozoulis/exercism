import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Instant
import java.time.ZoneId

object Gigasecond {
	private val gigaSecondInMillis = 1000000000L * 1000
	private val zoneId = ZoneId.systemDefault()

  def add(startDate: LocalDate): LocalDateTime = {
  	val epoch = startDate.atStartOfDay(zoneId).toEpochSecond() * 1000L
  	LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch + gigaSecondInMillis + 3600 * 1000), zoneId)
  }

  def add(startDateTime: LocalDateTime): LocalDateTime = {
  	val epoch = startDateTime.atZone(zoneId).toEpochSecond() * 1000L
  	LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch + gigaSecondInMillis - 3600 * 1000), zoneId)
  }
}