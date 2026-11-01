class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        n = len(nums)
        count = {}
        for num in nums:
            count[num] = count.get(num, 0) + 1
            if count[num] > n // 2:
                return num