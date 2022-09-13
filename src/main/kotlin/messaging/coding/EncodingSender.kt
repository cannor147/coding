package messaging.coding

import coding.Encoder
import messaging.Sender
import java.io.OutputStream

class EncodingSender<Word, Code>(
    private val sender: Sender<Code>,
    private val encoder: Encoder<Word, Code>,
) : Sender<Word> {
    override fun send(outputStream: OutputStream, data: Word) = sender.send(outputStream, encoder.encode(data))
}