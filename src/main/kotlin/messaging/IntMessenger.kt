package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class IntMessenger : DataMessenger<Int>() {
    override fun send(outputStream: DataOutputStream, data: Int) = outputStream.writeInt(data)
    override fun receive(inputStream: DataInputStream): Int = inputStream.readInt()
}