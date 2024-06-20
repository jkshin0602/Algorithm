package leetcode

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        val input = s.trim().lowercase().replace("[^a-zA-Z0-9]".toRegex(), "")
        val len = input.length

        return if (len % 2 == 0) {
            input.substring(0, len / 2) == input.substring(len / 2).reversed()
        } else {
            input.substring(0, len / 2) == input.substring(len / 2 + 1).reversed()
        }
    }
}
