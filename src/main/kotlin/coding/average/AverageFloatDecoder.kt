package coding.average

import coding.Decoder

class AverageFloatDecoder : Decoder<Float, List<Float>> {
    override fun decode(code: List<Float>): Float = code.average().toFloat()
}