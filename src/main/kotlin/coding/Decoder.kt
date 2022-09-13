package coding

interface Decoder<Word, Code> {
    fun decode(code: Code): Word
}