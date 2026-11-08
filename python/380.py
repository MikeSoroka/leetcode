from random import randint


class RandomizedSet:

    def __init__(self):
        self.arr = []
        self.map = dict()

    def insert(self, val: int) -> bool:
        if val in self.map:
            return False

        self.arr.append(val)
        self.map[val] = len(self.arr) - 1

        return True

    def remove(self, val: int) -> bool:
        if val not in self.map:
            return False

        index = self.map[val]
        self.map.pop(val)
        if index == len(self.arr) - 1:
            self.arr.pop()
        else:
            last = self.arr.pop()
            self.arr[index] = last
            self.map[last] = index

        return True

    def getRandom(self) -> int:
        rand_index = randint(0, len(self.arr) - 1)
        return self.arr[rand_index]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()