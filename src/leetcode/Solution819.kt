package leetcode

class Solution819 {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val counts = mutableMapOf<String, Int>()
        val lowerCaseBanned = banned.map { it.lowercase() }.toSet()

        paragraph.lowercase()
            .replace("\\W+".toRegex(), " ")
            .split(" ")
            .forEach {
                if (it.isNotBlank() && !lowerCaseBanned.contains(it)) {
                    counts[it] = counts.getOrDefault(it, 0) + 1
                }
            }

        return counts.maxByOrNull { it.value }!!.key
    }
}
