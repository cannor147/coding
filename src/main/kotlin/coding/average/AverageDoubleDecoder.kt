package coding.average

import coding.Decoder

class AverageDoubleDecoder : Decoder<Double, List<Double>> {
    override fun decode(code: List<Double>): Double = code.average()
}