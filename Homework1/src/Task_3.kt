typealias Array2d = Array<Array<Double>>
typealias Array3d = Array<Array2d>

enum class SliceDirection {
    TOP, FRONT, LEFT
}

fun isCube(array : Array3d) =
        array.count { !isSquare(it) } == 0 && array.size == array[0].size

fun isRectangular(array: Array2d) =
        array.count { it.size != array[0].size } == 0

fun isSquare(array : Array2d) =
        isRectangular(array) && array.size == array[0].size

fun getSlice(array : Array3d, direction : SliceDirection, number : Int) : Array2d {
    if (!isCube(array) || array.size <= number) {
        throw IllegalArgumentException()
    }

    return when (direction) {
        SliceDirection.LEFT -> array[number]

        SliceDirection.FRONT -> {
            val result = Array(array.size) { Array(array.size) { 0.0 } }

            for (i in array.indices) {
                for (j in array[i].indices) {
                    result[j][i] = array[i][j][number]
                }
            }

            result
        }

        else -> {
            val result = Array(array.size) { Array(array.size) { 0.0 } }

            for (i in array.indices) {
                for (j in array[number].indices) {
                    result[j][i] = array[i][number][j]
                }
            }

            result
        }
    }
}

fun getDeterminant2x2(array : Array2d) : Double {
    if (!isSquare(array) || array.size != 2) {
        throw IllegalArgumentException()
    }

    return array[0][0] * array[1][1] - array[0][1] * array[1][0]
}

fun getDeterminant3x3(array : Array2d) : Double {
    if (!isSquare(array) || array.size != 3) {
        throw IllegalArgumentException()
    }

    return  array[0][0] * array[1][1] * array[2][2] +
            array[0][1] * array[1][2] * array[2][0] +
            array[0][2] * array[1][0] * array[2][1] -
            array[0][2] * array[1][1] * array[2][0] -
            array[0][1] * array[1][0] * array[2][2] -
            array[0][0] * array[1][2] * array[2][1]
}

fun getDeterminant(array : Array2d) : Double {
    if (!isSquare(array) || array.size > 3) {
        throw IllegalArgumentException()
    }

    return when(array.size) {
        1 -> array[0][0]
        2 -> getDeterminant2x2(array)
        3 -> getDeterminant3x3(array)
        else -> throw IllegalArgumentException()
    }
}

fun printArray2d(array : Array2d) =
        array.forEach { it.forEach { elem -> print("$elem ") }; println() }