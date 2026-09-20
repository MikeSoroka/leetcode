class Solution:
    def canPartition(self, nums: list[int]) -> bool:
        if sum(nums) & 1:
            return False
        target = sum(nums) // 2

        memo = {}
        def rec(i, cursum):
            if (i, cursum) in memo:
                return memo[(i, cursum)]
            if cursum == target:
                return True
            elif cursum > target:
                return False
            elif i >= len(nums):
                return False

            if rec(i + 1, cursum + nums[i]) or rec(i + 1, cursum):
                memo[(i, cursum)] = True
                return True


            memo[(i, cursum)] = False
            return False

        return rec(0, 0)