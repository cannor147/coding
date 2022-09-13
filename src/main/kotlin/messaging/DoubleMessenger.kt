package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class DoubleMessenger : DataMessenger<Double>() {
    override fun send(outputStream: DataOutputStream, data: Double) = outputStream.writeDouble(data)
    override fun receive(inputStream: DataInputStream): Double = inputStream.readDouble()
}
