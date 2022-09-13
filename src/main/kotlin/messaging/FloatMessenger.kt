package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class FloatMessenger : DataMessenger<Float>() {
    override fun send(outputStream: DataOutputStream, data: Float) = outputStream.writeFloat(data)
    override fun receive(inputStream: DataInputStream): Float = inputStream.readFloat()
}