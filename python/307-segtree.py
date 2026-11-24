class NumArray:
    nums: list[int]
    data: list[int]

    def __init__(self, nums: list[int]):
        self.nums = nums[:]
        self.data = [None] * (4 * len(nums))
        self.__construct(1, 0, len(self.nums))

    def update(self, index: int, val: int) -> None:
        self.__updateIter(1, 0, len(self.nums), index, val)
        self.nums[index] = val

    def sumRange(self, left: int, right: int) -> int:
        return self.__sumIter(1, 0, len(self.nums), left, right + 1)

    def __construct(self, v, tl, tr):
        if tr - tl == 1:
            self.data[v] = self.nums[tl]
            return

        tm = (tl + tr) // 2
        self.__construct(2 * v, tl, tm)
        self.__construct(2 * v + 1, tm, tr)

        self.data[v] = self.data[2 * v] + self.data[2 * v + 1]

    def __sumIter(self, v, tl, tr, l, r):
        if tr <= l or tl >= r:
            return 0
        elif l <= tl and tr <= r:
            return self.data[v]

        tm = (tl + tr) // 2
        return self.__sumIter(2 * v, tl, tm, l, r) + self.__sumIter(2 * v + 1, tm, tr, l, r)

    def __updateIter(self, v, tl, tr, index, newVal):
        if index < tl or index >= tr:
            return

        self.data[v] += newVal - self.nums[index]

        if tr - tl > 1:
            tm = (tl + tr) // 2
            self.__updateIter(2 * v, tl, tm, index, newVal)
            self.__updateIter(2 * v + 1, tm, tr, index, newVal)
