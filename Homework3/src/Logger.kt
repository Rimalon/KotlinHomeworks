package test.third

class Logger {
    companion object {
        private val content: MutableMap<Person, StringBuilder> = mutableMapOf()

        fun getHistoryOfPerson(person: Person): String{
            return if (content.containsKey(person)){
                content[person]!!.toString()
            } else{
                "There is no such person"
            }
        }

        fun putInfo(person: Person, message : String){
            if (!content.containsKey(person)){
                content[person] = StringBuilder(message + "\n")
            }
            else{
                content[person]?.append(message + "\n")
            }
        }
    }
}