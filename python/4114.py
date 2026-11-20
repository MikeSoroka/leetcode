class Solution:
    def countConsistent(self, nums: list[int]) -> int:
        n = len(nums)
        bits = max(nums).bit_length()

        lastzero = [-1] * bits
        lastsame = {}
        left = {index: -1 for index in range(n)}

        for index, num in enumerate(nums):
            left[index] = lastsame.get(num, -1)
            for bit in range(bits):
                if num >> bit & 1:
                    left[index] = max(left[index], lastzero[bit])
                else:
                    lastzero[bit] = index

            lastsame[num] = index

        nextzero = [n] * bits
        right = {index: n for index in range(n)}

        for index in reversed(range(n)):
            num = nums[index]
            for bit in range(bits):
                if num >> bit & 1:
                    right[index] = min(right[index], nextzero[bit])
                else:
                    nextzero[bit] = index

        total = 0
        for index in range(n):
            total += (index - left[index]) * (right[index] - index)

        return total