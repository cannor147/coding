package coding.average

import coding.Decoder

class AverageIntDecoder : Decoder<Int, List<Int>> {
    override fun decode(code: List<Int>): Int = code.average().toInt()
}