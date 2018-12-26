
fun main(args: Array<String>) {
    //Here 3 task is checked
    val array = Array(3) { Array(3) { Array (3) { 0.0 } } }

    var i = 1.0
    for (array2d in array) {
        for (array1d in array2d) {
            for (j in array1d.indices) {
                array1d[j] = i
                i++
            }
        }
    }

    val frontSlice = getSlice(array, SliceDirection.FRONT, 2)
    val topSlice = getSlice(array, SliceDirection.TOP, 1)
    val leftSlice = getSlice(array, SliceDirection.LEFT, 0)
    printArray2d(frontSlice)
    println()
    printArray2d(topSlice)
    println()
    printArray2d(leftSlice)
    println()
    println(getDeterminant(frontSlice))
    println(getDeterminant(topSlice))
    println(getDeterminant(leftSlice))
}