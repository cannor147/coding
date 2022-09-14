package affect

interface Affection<Data> {
    fun affect(data: Data): Data
}