package leetcode

import kotlin.math.*

class Solution42 {
    fun trap(height: IntArray): Int {
        var volume = 0
        var left = 0
        var right = height.size - 1

        var leftMax = height[left]
        var rightMax = height[right]

        while (left < right) {
            leftMax = max(height[left], leftMax)
            rightMax = max(height[right], rightMax)

            if (leftMax <= rightMax) {
                // 최대 높이와의 차이를 더하고 포인터 이동
                volume += leftMax - height[left]
                left += 1
            } else {
                // 최대 높이와의 차이를 더하고 포인터 이동
                volume += rightMax - height[right]
                right -= 1
            }
        }

        return volume
    }
}
