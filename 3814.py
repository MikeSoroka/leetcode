from bisect import bisect_left

class Solution:
    def maxCapacity(costs, capacity, budget):
        items = sorted(zip(costs, capacity))
        c = [cost for cost, _ in items]
        pref = []
        best = 0

        for i, (cost, cap) in enumerate(items):
            if cost >= budget:
                break
            best = max(best, cap)

            j = bisect_left(c, budget - cost, 0, i) - 1
            if j >= 0:
                best = max(best, cap + pref[j])

            pref.append(max(pref[-1], cap) if pref else cap)

        return best


