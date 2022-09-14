package affect

import java.util.concurrent.ThreadLocalRandom

class SymmetricAffection(val probability: Double) : Affection<Boolean> {
    private val random = ThreadLocalRandom.current()

    override fun affect(data: Boolean) = if (random.nextDouble(0.0, 1.0) > probability) data else !data
}
