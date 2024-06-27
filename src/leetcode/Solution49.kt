package leetcode

class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        strs.forEach { str ->
            val sortedStr = str.toCharArray().sorted().joinToString(separator = "")
            map[sortedStr] = map.getOrPut(sortedStr) { mutableListOf() }.apply { this.add(str) }
        }
        return map.values.map { it }
    }
}
