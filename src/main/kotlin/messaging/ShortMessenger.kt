package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class ShortMessenger : DataMessenger<Short>() {
    override fun send(outputStream: DataOutputStream, data: Short) = outputStream.writeShort(data.toInt())
    override fun receive(inputStream: DataInputStream): Short = inputStream.readShort()
}