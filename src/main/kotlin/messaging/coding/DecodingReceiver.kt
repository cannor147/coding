package messaging.coding

import coding.Decoder
import messaging.Receiver
import java.io.InputStream

class DecodingReceiver<Word, Code>(
    private val receiver: Receiver<Code>,
    private val decoder: Decoder<Word, Code>,
) : Receiver<Word> {
    override fun receive(inputStream: InputStream) = decoder.decode(receiver.receive(inputStream))
}