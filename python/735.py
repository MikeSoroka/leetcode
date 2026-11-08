class Solution:
    def asteroidCollision(self, asteroids: list[int]) -> list[int]:
        res = []
        for asteroid in asteroids:
            if asteroid < 0:
                while res and res[-1] > 0 and res[-1] < abs(asteroid):
                    res.pop()

                if res and res[-1] == abs(asteroid):
                    res.pop()
                elif res and res[-1] > abs(asteroid):
                    continue
                else:
                    res.append(asteroid)

            else:
                res.append(asteroid)

        return res

