package stream

import coding.Coding
import coding.Encoder
import coding.FixedCoding
import coding.wrapWord
import java.io.FilterOutputStream
import java.nio.channels.Channels
import java.nio.channels.WritableByteChannel
import java.util.*

class EncodingStream(
    byteChannel: WritableByteChannel,
    private val encoder: Encoder<List<Byte>, List<Byte>>,
    private val coding: Coding<in List<Byte>>,
) : FilterOutputStream(Channels.newOutputStream(byteChannel)) {
    private val buffer: MutableList<Byte> = LinkedList()

    constructor(byteChannel: WritableByteChannel, encoder: Encoder<List<Byte>, List<Byte>>, wordSize: Int) :
            this(byteChannel, encoder, FixedCoding(wordSize))

    constructor(byteChannel: WritableByteChannel, encoder: Encoder<Byte, List<Byte>>) :
            this(byteChannel, wrapWord(encoder), 1)

    override fun write(b: Int) {
        buffer.add(b.toByte())
        if (coding.test(buffer)) {
            val code = encoder.encode(buffer.toList())
            out.write(code.toByteArray())
            buffer.clear()
            return
        }
    }
}
