package messaging

import java.io.InputStream

interface Receiver<Message> {
    fun receive(inputStream: InputStream): Message
}