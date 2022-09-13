package messaging

import java.io.DataInputStream
import java.io.DataOutputStream

class CharMessenger : DataMessenger<Char>() {
    override fun send(outputStream: DataOutputStream, data: Char) = outputStream.writeChar(data.code)
    override fun receive(inputStream: DataInputStream): Char = inputStream.readChar()
}