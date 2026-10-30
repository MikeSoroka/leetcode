import heapq


class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], labels: str, k: int) -> int:
        DEFAULT = float('inf')

        adj = [[] for i in range(n)]
        for start, end, weight in edges:
            adj[start].append((end, weight))

        distances = [[DEFAULT for i in range(k + 1)] for i in range(n)]
        pq = [(0, 1, 0)]  # dist, consecutives, node

        while pq:
            dist, consCount, node = heapq.heappop(pq)
            if node == n - 1:
                return dist

            distances[node][consCount] = min(distances[node][consCount], dist)
            for neig, ndist in adj[node]:
                if labels[neig] == labels[node]:
                    if consCount + 1 > k:
                        continue
                    elif dist + ndist < distances[neig][consCount + 1]:
                        distances[neig][consCount + 1] = dist + ndist
                        heapq.heappush(pq, (dist + ndist, consCount + 1, neig))
                elif dist + ndist < distances[neig][1]:
                    distances[neig][1] = dist + ndist
                    heapq.heappush(pq, (dist + ndist, 1, neig))

        return -1

