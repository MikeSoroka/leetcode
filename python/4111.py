class Solution:
    def countConsistent(self, nums: list[int]) -> int:
        res = len(nums)

        for i in range(len(nums)):
            minval = nums[i]
            andval = nums[i]
            for j in range(i + 1, len(nums)):
                andval &= nums[j]
                minval = min(minval, nums[j])
                if andval == minval:
                    res += 1

        return res