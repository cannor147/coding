package messaging

import java.io.OutputStream

interface Sender<Message> {
    fun send(outputStream: OutputStream, data: Message)
}