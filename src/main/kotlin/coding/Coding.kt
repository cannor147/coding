package coding

fun <Word, Code> encoder(encoder: (Word) -> Code) = object : Encoder<Word, Code> {
    override fun encode(word: Word) = encoder.invoke(word)
}

fun <Word, Code> decoder(decoder: (Code) -> Word) = object : Decoder<Word, Code> {
    override fun decode(code: Code) = decoder.invoke(code)
}

fun <Word, Code> coder(encoder: (Word) -> Code, decoder: (Code) -> Word) = object : Coder<Word, Code> {
    override fun encode(word: Word) = encoder.invoke(word)
    override fun decode(code: Code) = decoder.invoke(code)
}
