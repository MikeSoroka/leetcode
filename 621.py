from collections import Counter

class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        ct = Counter(tasks)

        mp = max(ct.values())
        mc = 0
        for task in ct:
            if ct[task] == mp:
                mc += 1

        return max(len(tasks), (mp - 1) * (n + 1) + mc)