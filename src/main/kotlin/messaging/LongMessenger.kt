package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class LongMessenger : DataMessenger<Long>() {
    override fun send(outputStream: DataOutputStream, data: Long) = outputStream.writeLong(data)
    override fun receive(inputStream: DataInputStream): Long = inputStream.readLong()
}