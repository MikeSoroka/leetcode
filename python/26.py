class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        offset = 0
        i = 0
        newlen = len(nums)
        while i + offset < len(nums):
            while i + offset + 1 < len(nums) and nums[i + offset] == nums[i + offset + 1]:
                offset += 1
                newlen -= 1
            nums[i] = nums[i + offset]
            i += 1

        return newlen