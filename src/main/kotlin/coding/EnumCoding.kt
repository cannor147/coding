package coding

class EnumCoding<Code : Enum<Code>>(private val enum: Class<Code>) : Coding<String> {
    override fun test(t: String) = try {
        java.lang.Enum.valueOf(enum, t)
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}