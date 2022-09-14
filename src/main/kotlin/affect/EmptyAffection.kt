package affect

class EmptyAffection<Data> : Affection<Data> {
    override fun affect(data: Data) = data
}