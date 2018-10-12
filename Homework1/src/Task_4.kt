fun printSubstrings(strArr: Array<String>){
    for (i in 0 until strArr.size){
        for (j in i+1 until strArr.size){
            if (strArr[j].contains(strArr[i].toRegex())){
                println(strArr[i])
                break
            }
            if (strArr[i].contains(strArr[j].toRegex())){
                println(strArr[j])
                break
            }
        }
    }
}