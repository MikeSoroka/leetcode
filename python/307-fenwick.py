class NumArray:

    def __init__(self, nums: List[int]):
        self.n = len(nums)
        self.nums = nums[:]
        self.tree = [0] * (self.n + 1)

        for index, num in enumerate(nums, start=1):
            self.tree[index] += num
            parent = index + (index & -index)
            if parent <= self.n:
                self.tree[parent] += self.tree[index]

    def add(self, index, delta):
        index += 1
        while index <= self.n:
            self.tree[index] += delta
            index += index & -index

    def prefsum(self, index):
        res = 0
        while index > 0:
            res += self.tree[index]
            index &= index - 1
        return res

    def update(self, index: int, val: int) -> None:
        self.add(index, val - self.nums[index])
        self.nums[index] = val

    def sumRange(self, left: int, right: int) -> int:
        return self.prefsum(right + 1) - self.prefsum(left)