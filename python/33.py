class Solution:
    def search(self, nums: list[int], target: int) -> int:
        def binsearch(arr, target):
            left = 0
            right = len(arr) - 1
            while left < right:
                mid = (left + right) // 2
                if arr[mid] < target:
                    left = mid + 1
                else:
                    right = mid

                print(left, right)

            return -1 if arr[left] != target else left

        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1

        if (nums[0] < nums[-1]):
            return binsearch(nums, target)
        else:
            left = 0
            right = len(nums) - 1
            while left < right:
                if right == left + 1:
                    start = right
                    break
                mid = (left + right) // 2
                if (nums[mid + 1]) < nums[mid]:
                    start = mid + 1
                    break
                if nums[mid] > nums[left]:
                    left = mid + 1
                else:
                    right = mid
            else:
                start = right

        arr1 = nums[0:start]
        arr2 = nums[start:len(nums)]

        search1 = binsearch(arr1, target)
        if search1 != -1:
            return search1

        search2 = binsearch(arr2, target)
        if search2 != -1:
            return search2 + start

        return -1

