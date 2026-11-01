class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        res = []
        for mask in range(2 ** len(nums)):
            idx = 0
            subset = []
            while mask > 0:
                print(mask, idx)
                if mask & 1:
                    subset.append(nums[idx])
                mask = mask >> 1
                idx += 1

            res.append(subset)

        return res
