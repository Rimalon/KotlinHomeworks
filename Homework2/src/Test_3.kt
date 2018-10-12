val isAmicables = {x : Pair<Int,Int> ->
    var firstSum = 0
    var secondSum = 0
    for (i in 1 .. x.first / 2){
        if (x.first % i == 0){
            firstSum += i
        }
    }
    for (i in 1 .. x.second / 2){
        if (x.second % i == 0){
            secondSum += i
        }

    }
    ((firstSum == x.second)&& (secondSum == x.first))}

fun getAmicables(arr : Array<Pair<Int,Int>>) = arr.filter(isAmicables)