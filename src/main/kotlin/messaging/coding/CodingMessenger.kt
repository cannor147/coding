package messaging.coding

import coding.Coder
import messaging.Messenger
import java.io.InputStream
import java.io.OutputStream

class CodingMessenger<Word, Code>(
    private val messenger: Messenger<Code>,
    private val coder: Coder<Word, Code>,
) : Messenger<Word> {
    override fun send(outputStream: OutputStream, data: Word) = messenger.send(outputStream, coder.encode(data))
    override fun receive(inputStream: InputStream): Word = coder.decode(messenger.receive(inputStream))
}