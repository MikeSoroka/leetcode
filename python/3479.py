class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        n = len(baskets)
        size = int(n ** 0.5)
        block = []
        blocks = []
        maxes = []
        curmax = -1
        for b in baskets:
            block.append(b)
            curmax = max(curmax, b)
            if len(block) == size:
                blocks.append(block)
                maxes.append(curmax)
                block = []
                curmax = -1

        if block:
            blocks.append(block)
            maxes.append(curmax)

        unplaced = 0
        for f in fruits:
            for i in range(len(blocks)):
                if maxes[i] >= f:
                    for el in blocks[i]:
                        if el >= f:
                            blocks[i].remove(el)
                            break
                    if len(blocks[i]) == 0:
                        maxes[i] = 0
                    else:
                        maxes[i] = max(blocks[i])
                    break
            else:
                unplaced += 1

        return unplaced