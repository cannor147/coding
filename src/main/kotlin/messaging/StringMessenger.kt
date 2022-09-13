package messaging

import java.io.InputStream
import java.io.OutputStream

class StringMessenger : Messenger<String> {
    override fun send(outputStream: OutputStream, data: String) = outputStream.write(data.toByteArray())
    override fun receive(inputStream: InputStream): String = String(inputStream.readAllBytes())
}