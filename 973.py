import random

class Solution:
    def kClosest(self, points, k):
        dist = lambda p: p[0]**2 + p[1]**2
        lo, hi = 0, len(points) - 1
        while lo < hi:
            p = random.randint(lo, hi)
            points[p], points[hi] = points[hi], points[p]
            pivot, store = dist(points[hi]), lo
            for i in range(lo, hi):
                if dist(points[i]) < pivot:
                    points[i], points[store] = points[store], points[i]
                    store += 1
            points[store], points[hi] = points[hi], points[store]
            if store == k:
                break
            elif store < k:
                lo = store + 1
            else:
                hi = store - 1
        return points[:k]