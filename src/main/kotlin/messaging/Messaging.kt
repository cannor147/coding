package messaging

import java.io.OutputStream

fun <M> Sender<M>.send(outputStream: OutputStream, data: Iterable<M>) = data.forEach { send(outputStream, it) }
fun <M> Sender<M>.send(outputStream: OutputStream, data: Array<M>) = data.forEach { send(outputStream, it) }