package coding

class RepeatEncoder<Word>(val coding: FixedCoding<Word>) : Encoder<Word, List<Word>> {
    override fun encode(word: Word) = generateSequence { word }.take(coding.size).toList()
}
