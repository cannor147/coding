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

fun <Word, Code> wrap(encoder: Encoder<Word, Code>) = object : Encoder<List<Word>, List<Code>> {
    override fun encode(word: List<Word>) = listOf(encoder.encode(word[0]))
}

fun <Word, Code> wrap(decoder: Decoder<Word, Code>) = object : Decoder<List<Word>, List<Code>> {
    override fun decode(code: List<Code>) = listOf(decoder.decode(code[0]))
}

fun <Word, Code> wrap(coder: Coder<Word, Code>) = object : Coder<List<Word>, List<Code>> {
    override fun encode(word: List<Word>) = listOf(coder.encode(word[0]))
    override fun decode(code: List<Code>) = listOf(coder.decode(code[0]))
}

fun <Word, Code> wrapCode(encoder: Encoder<Word, Code>) = object : Encoder<Word, List<Code>> {
    override fun encode(word: Word) = listOf(encoder.encode(word))
}

fun <Word, Code> wrapCode(decoder: Decoder<Word, Code>) = object : Decoder<Word, List<Code>> {
    override fun decode(code: List<Code>) = decoder.decode(code[0])
}

fun <Word, Code> wrapCode(coder: Coder<Word, Code>) = object : Coder<Word, List<Code>> {
    override fun encode(word: Word) = listOf(coder.encode(word))
    override fun decode(code: List<Code>) = coder.decode(code[0])
}

fun <Word, Code> wrapWord(encoder: Encoder<Word, Code>) = object : Encoder<List<Word>, Code> {
    override fun encode(word: List<Word>) = encoder.encode(word[0])
}

fun <Word, Code> wrapWord(decoder: Decoder<Word, Code>) = object : Decoder<List<Word>, Code> {
    override fun decode(code: Code) = listOf(decoder.decode(code))
}

fun <Word, Code> wrapWord(coder: Coder<Word, Code>) = object : Coder<List<Word>, Code> {
    override fun encode(word: List<Word>) = coder.encode(word[0])
    override fun decode(code: Code) = listOf(coder.decode(code))
}
