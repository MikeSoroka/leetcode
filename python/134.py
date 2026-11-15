from collections import deque


class Solution:
    def canCompleteCircuit(self, gas: list[int], cost: list[int]) -> int:
        # cost i -> i + 1 - refill(i)
        # arr -> arr + arr

        n = len(gas)
        diff = 0
        changes = []
        for i in range(n):
            changes.append(gas[i] - cost[i])

        acc = 0
        worst = float('inf')
        worst_index = -1
        for i in range(n):
            acc += gas[i] - cost[i]
            if acc < worst:
                worst = acc
                worst_index = index

        print(changes)
        start = (worst_index + 1) % n
        curr = 0
        for i in range(start, start + n):
            actual = i % n
            curr += changes[actual]
            if curr < 0:
                return -1

        return start
