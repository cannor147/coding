package channel

import affect.Affection

open class BinaryChannel(private val affection: Affection<Boolean>) : ByteArrayChannel(object : Affection<Byte> {
    override fun affect(data: Byte): Byte = if (data.compareTo(0) == 0) {
        toByte(affection.affect(false))
    } else if (data.compareTo(1) == 0) {
        toByte(affection.affect(true))
    } else {
        throw IllegalStateException("Can't affect non-binary value.")
    }

    private fun toByte(boolean: Boolean): Byte = if (boolean) 1 else 0
})
