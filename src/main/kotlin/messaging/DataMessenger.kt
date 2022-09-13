package messaging

import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStream
import java.io.OutputStream

abstract class DataMessenger<Message> : Messenger<Message> {
    override fun send(outputStream: OutputStream, data: Message) = send(DataOutputStream(outputStream), data)
    abstract fun send(outputStream: DataOutputStream, data: Message)

    override fun receive(inputStream: InputStream): Message = receive(DataInputStream(inputStream))
    abstract fun receive(inputStream: DataInputStream): Message
}
