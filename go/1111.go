func maxDepthAfterSplit(seq string) []int {
    cntA := 0
    cntB := 0
    solution := make([]int, len(seq))

    for i, c := range seq {
        switch c {
        case '(':
            if cntA == cntB {
                solution[i] = 0
                cntA ++
            } else {
                solution[i] = 1
                cntB ++
            }
        case ')':
            if cntA == cntB {
                solution[i] = 1
                cntB --
            } else {
                solution[i] = 0
                cntA --
            }
        }
    }

    return solution
}