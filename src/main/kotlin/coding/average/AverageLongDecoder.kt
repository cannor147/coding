package coding.average

import coding.Decoder

class AverageLongDecoder : Decoder<Long, List<Long>> {
    override fun decode(code: List<Long>): Long = code.average().toLong()
}