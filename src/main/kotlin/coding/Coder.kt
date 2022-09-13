package coding

interface Coder<Word, Code> : Encoder<Word, Code>, Decoder<Word, Code>