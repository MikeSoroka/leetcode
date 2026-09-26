class Solution:
    def evaluate(self, s: str, knowledge: list[list[str]]) -> str:
        kd = {}
        for k, v in knowledge:
            kd[k] = v

        curr = []
        res = []
        for char in s:
            if char == "(":
                curr = ["("]
            elif char == ")":
                key = ''.join(curr[1:])
                if key in kd:
                    res.append(kd[key])
                else:
                    res.append("?")
                curr = []
            elif curr:
                curr.append(char)
            else:
                res.append(char)

        return ''.join(res)