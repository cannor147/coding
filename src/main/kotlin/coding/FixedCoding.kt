package coding

class FixedCoding<Element>(val size: Int) : Coding<Collection<Element>> {
    override fun test(t: Collection<Element>): Boolean = t.size == size
}