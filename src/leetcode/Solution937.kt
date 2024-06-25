package leetcode

class Solution937 {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val numberLog = mutableListOf<String>()
        val letterLog = mutableListOf<String>()

        logs.forEach {
            if (it.split(" ")[1].toCharArray().first().isDigit()) {
                numberLog.add(it)
            } else {
                letterLog.add(it)
            }
        }

        letterLog.sortWith { o1, o2 ->
            val s1 = o1.split(" ", limit = 2)
            val s2 = o2.split(" ", limit = 2)
            s1[1].compareTo(s2[1])
                .takeUnless { it == 0 }
                ?: s1[0].compareTo(s2[0])
        }

        return (letterLog + numberLog).toTypedArray()
    }
}

fun main() {
    val x = Solution937()
    val result = x.reorderLogFiles(arrayOf("j mo", "5 m w", "g 07", "o 2 0", "t q h"))

    result.forEach {
        println(it)
    }

    println("mo".compareTo("mw"))
}
