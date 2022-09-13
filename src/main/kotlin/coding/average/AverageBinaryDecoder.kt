package coding.average

import coding.Decoder

class AverageBinaryDecoder : Decoder<Boolean, List<Boolean>> {
    override fun decode(code: List<Boolean>): Boolean = code.map { if (it) 1 else 0 }.average() < 0.5
}