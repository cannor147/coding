package messaging

interface Messenger<Message> : Sender<Message>, Receiver<Message>