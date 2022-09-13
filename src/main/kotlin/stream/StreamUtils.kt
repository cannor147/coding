package stream

import java.io.InputStream
import java.util.function.Predicate

fun InputStream.readWhile(predicate: Predicate<in List<Byte>>): List<Byte> {
    val bytes = mutableListOf<Byte>()
    while (predicate.test(bytes)) {
        val byte = this.read()
        if (byte == -1) {
            break
        }
        bytes.add(byte.toByte())
    }
    return bytes
}

fun InputStream.readUntil(predicate: Predicate<in List<Byte>>) = this.readWhile(Predicate.not(predicate))
