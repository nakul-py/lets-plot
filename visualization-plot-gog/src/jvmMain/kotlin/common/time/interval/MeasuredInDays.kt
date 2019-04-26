package jetbrains.datalore.visualization.plot.gog.common.time.interval

import jetbrains.datalore.base.datetime.Date
import jetbrains.datalore.base.datetime.DateTime
import jetbrains.datalore.visualization.plot.gog.common.time.TimeUtil

abstract class MeasuredInDays protected constructor(count: Int) : TimeInterval(count) {

    protected abstract fun getFirstDayContaining(instant: DateTime): Date

    override fun range(start: Double, end: Double): List<Double> {
        if (start > end) {
            throw RuntimeException("Duration must be positive")
        }

        val dateTimeStart = TimeUtil.asDateTimeUTC(start)

        val dateStart = getFirstDayContaining(dateTimeStart)
        var dateTimeTick = DateTime(dateStart)
        if (dateTimeTick.compareTo(dateTimeStart) < 0) {
            dateTimeTick = addInterval(dateTimeTick)
        }

        val result = ArrayList<Double>()
        var tick = TimeUtil.asInstantUTC(dateTimeTick).toDouble()
        while (tick <= end) {
            result.add(tick)
            dateTimeTick = addInterval(dateTimeTick)
            tick = TimeUtil.asInstantUTC(dateTimeTick).toDouble()
        }

        return result
    }

    protected abstract fun addInterval(toInstant: DateTime): DateTime

}
