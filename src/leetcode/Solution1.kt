package leetcode

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val maps = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            // target - num -> 정답
            if (maps.containsKey(target - num)) {
                return intArrayOf(maps[target - num] ?: 0, i)
            }
            maps[num] = i
        }
        return intArrayOf()
    }
}
