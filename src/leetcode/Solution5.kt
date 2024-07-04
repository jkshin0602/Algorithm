package leetcode

class Solution5 {
    var left = 0
    var maxLen = 0

    private fun extendPalindrome(
        s: String,
        start: Int,
        end: Int,
    ) {
        var l = start
        var r = end

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        val len = r - l - 1

        if (maxLen < len) {
            left = l + 1
            maxLen = len
        }
    }

    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len < 2) return s

        for (i in 0 until len - 1) {
            extendPalindrome(s, i, i + 1)
            extendPalindrome(s, i, i + 2)
        }

        return s.substring(left, left + maxLen)
    }
}
