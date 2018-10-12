fun isPossibleToReach(numberOfSteps : Int, pos : Pair<Int,Int> = Pair(1,1)) : Boolean {
    var result = false
    if ((numberOfSteps == 0) && (pos == Pair(8, 8))) {
        return true
    } else if ((numberOfSteps == 0) && (pos != Pair(8, 8)) || (numberOfSteps < 0)) {
        return false
    } else {
        val possiblePositions = mutableListOf<Pair<Int, Int>>()
        for (i in setOf(-1, 1)) {
            for (j in setOf(-2, 2)) {
                if ((pos.first + i <= 8 && pos.first >= 1) && (pos.second + j <= 8 && pos.second >= 1)) {
                    possiblePositions.add(Pair(pos.first + i, pos.second + j))
                }
            }
        }
        for (i in setOf(-2, 2)) {
            for (j in setOf(-1, 1)) {
                if ((pos.first + i <= 8 && pos.first >= 1) && (pos.second + j <= 8 && pos.second >= 1)) {
                    possiblePositions.add(Pair(pos.first + i, pos.second + j))
                }
            }
        }
        for (step in possiblePositions)
            result = result || isPossibleToReach(numberOfSteps - 1, step)
    }
    return result
}
