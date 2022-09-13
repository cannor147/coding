package stream

import coding.Coding
import coding.Encoder
import coding.FixedCoding
import coding.wrapWord
import java.io.FilterOutputStream
import java.io.OutputStream
import java.util.*

class EncodingStream(
    outputStream: OutputStream,
    private val encoder: Encoder<List<Byte>, List<Byte>>,
    private val coding: Coding<in List<Byte>>,
) : FilterOutputStream(outputStream) {
    private val buffer: MutableList<Byte> = LinkedList()

    constructor(outputStream: OutputStream, encoder: Encoder<List<Byte>, List<Byte>>, wordSize: Int) :
            this(outputStream, encoder, FixedCoding(wordSize))

    constructor(outputStream: OutputStream, encoder: Encoder<Byte, List<Byte>>) :
            this(outputStream, wrapWord(encoder), 1)

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
