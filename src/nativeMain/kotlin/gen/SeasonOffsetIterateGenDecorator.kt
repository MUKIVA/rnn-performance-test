package gen

import kotlin.math.sin

class SeasonOffsetIterateGenDecorator(
    private val gen: IIterateGen<Double>,
    private val scale: Double,
    private val period: Double,
) : IIterateGen<Double> {
    override val iteration: UInt
        get() = gen.iteration

    private var mAngle: Double = 0.0

    override fun generateNext(): Double {
        val value = gen.generateNext()
        val sin = (sin(mAngle) * scale).apply {
            mAngle += period
        }
        return value + sin
    }
}