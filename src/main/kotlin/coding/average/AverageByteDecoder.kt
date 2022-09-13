package coding.average

import coding.Decoder

class AverageByteDecoder : Decoder<Byte, List<Byte>> {
    override fun decode(code: List<Byte>): Byte = code.average().toInt().toByte()
}