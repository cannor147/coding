package channel

import affect.Affection
import affect.EmptyAffection
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.channels.ByteChannel
import java.nio.channels.ClosedChannelException

open class ByteArrayChannel(private val affection: Affection<Byte>) : ByteChannel {
    private val outputStream = ByteArrayOutputStream()
    private var closed = false
    private var offset = 0

    constructor() : this(EmptyAffection<Byte>())

    override fun close() {
        closed = true
    }

    override fun isOpen(): Boolean = !closed

    override fun read(destination: ByteBuffer): Int {
        if (closed) {
            throw ClosedChannelException()
        }

        val initialOffset = offset
        val bytes = outputStream.toByteArray()
        val inputStream = ByteArrayInputStream(bytes, offset, bytes.size)

        while (destination.hasRemaining()) {
            val byte = inputStream.read()
            if (byte == -1) {
                if (offset == initialOffset) {
                    return -1
                }
                break
            }
            val affectedByte = affection.affect(byte.toByte())
            destination.put(affectedByte)
            offset++
        }
        return offset - initialOffset
    }

    override fun write(source: ByteBuffer): Int {
        if (closed) {
            throw ClosedChannelException()
        }
        val bytes = ByteArray(source.remaining())
        source.get(bytes)
        outputStream.write(bytes)
        return bytes.size
    }
}
