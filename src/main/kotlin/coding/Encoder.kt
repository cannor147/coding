package coding

interface Encoder<Word, Code> {
    fun encode(word: Word): Code
}