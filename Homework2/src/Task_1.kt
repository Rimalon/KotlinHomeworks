fun countNeededElems(arr: Array<Int>) = arr.filter { x -> (x % 10 != 0)}
                                           .map {x -> x * arr.size }
                                           .toSet()
                                           .count { x -> x > 10}

