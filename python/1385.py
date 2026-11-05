from bisect import bisect

class Solution:
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        res = 0
        arr2 = sorted(arr2)
        for num1 in arr1:
            index = bisect(arr2, num1)
            if not(abs(arr2[index] - num1) <= d or (index < len(arr2) - 1 and abs(arr2[index + 1] - num1) <= d)):
                res += 1


        return res