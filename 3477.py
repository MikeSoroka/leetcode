class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        n = len(baskets)
        segtree = [None] * (4 * n)
        def construct(v, sl, sr):
            if sr - sl == 1:
                segtree[v] = baskets[sl]
                return

            sm = (sl + sr) // 2
            construct(2 * v, sl, sm)
            construct(2 * v + 1, sm, sr)
            segtree[v] = max(segtree[2 * v], segtree[2 * v + 1])

        def getFirstFit(v, sl, sr, limit):
            if segtree[v] < limit:
                return -1
            if sr - sl == 1:
                return sl
            sm = (sl + sr) // 2
            left = getFirstFit(v * 2, sl, sm, limit)
            if left > -1:
                return left
            return getFirstFit(v * 2 + 1, sm, sr, limit)

        def removeBasket(v, sl, sr, index):
            if index < sl or sr <= index:
                return
            if sr - sl == 1:
                if sl == index:
                    segtree[v] = 0
                return
            sm = (sl + sr) // 2
            removeBasket(v * 2, sl, sm, index)
            removeBasket(v * 2 + 1, sm, sr, index)

            segtree[v] = max(segtree[2 * v], segtree[2 * v + 1])

        count = 0
        construct(1, 0, n)
        for f in fruits:
            res = getFirstFit(1, 0, n, f)
            if res == -1:
                count += 1
            else:
                baskets[res] = 0
                removeBasket(1, 0, n, res)

        return count

