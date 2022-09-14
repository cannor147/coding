package stream

import coding.Coding
import coding.Decoder
import coding.FixedCoding
import coding.wrapCode
import java.io.FilterInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.channels.Channels
import java.nio.channels.ReadableByteChannel
import java.util.*

class DecodingStream(
    byteChannel: ReadableByteChannel,
    private val decoder: Decoder<List<Byte>, List<Byte>>,
    private val coding: Coding<in List<Byte>>,
) : FilterInputStream(Channels.newInputStream(byteChannel)) {
    private val buffer: Queue<Byte> = ArrayDeque()

    constructor(byteChannel: ReadableByteChannel, decoder: Decoder<List<Byte>, List<Byte>>, codeSize: Int) :
            this(byteChannel, decoder, FixedCoding(codeSize))
    constructor(byteChannel: ReadableByteChannel, decoder: Decoder<List<Byte>, Byte>) :
            this(byteChannel, wrapCode(decoder), 1)

    override fun read(): Int {
        while (buffer.isEmpty()) {
            val code = if (coding is FixedCoding<*>) `in`.readNBytes(coding.size).toList() else `in`.readUntil(coding)
            if (code.isEmpty()) {
                return -1
            }

            val word = decoder.decode(code)
            buffer.addAll(word)
        }
        return buffer.poll().toInt()
    }

    override fun read(bytes: ByteArray, offset: Int, length: Int): Int {
        var i = 0
        try {
            while (i < length) {
                val byte = read()
                if (byte == -1) {
                    if (i == 0) {
                        i = -1
                    }
                    break
                }
                bytes[offset + i] = byte.toByte()
                i++
            }
        } catch (e: IOException) {
            if (i == 0) {
                throw e
            }
        }
        return i
    }

    override fun close() = `in`.close()
}
