import java.io.IOException

typealias double2dArr = Array<Array<Double>>

fun isGoodMatrix(m : double2dArr) : Boolean {
    var flag = true
    val size = m[0].size
    for (row in m) {
        flag = flag && (row.size == size)
    }
    return flag
}

fun matrixComp(m1 : double2dArr, m2 : double2dArr) : double2dArr{
    var flag = isGoodMatrix(m1) && isGoodMatrix(m2)
    flag = flag && (m1.size == m2[0].size)

    if (flag){
        val res = Array(m1.size) {Array<Double> (m2[0].size) {0.0}}
        for (i in 0 until  m1.size){
            for (j in 0 until m2[0].size){
                var sum = 0.0
                for (k in 0 until m1[0].size){
                    sum += m1[i][k] * m2[k][j]
                }
                res [i][j] = sum
            }
        }
        return res
    }
    else {
        throw IOException()
    }
}