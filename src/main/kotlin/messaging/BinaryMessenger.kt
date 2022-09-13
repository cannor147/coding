package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class BinaryMessenger : DataMessenger<Boolean>() {
    override fun send(outputStream: DataOutputStream, data: Boolean) = outputStream.writeBoolean(data)
    override fun receive(inputStream: DataInputStream): Boolean = inputStream.readBoolean()
}