package test.third



class Person (name: String,
              val age: Int,
              val address: String,
              val phone: String,
              _familyStatus: FamilyStatus = FamilyStatus.SINGLE,
              val friends: MutableList<Person> = mutableListOf(),
              val hobbies: MutableList<Hobby> = mutableListOf(),
              val works: MutableList<Work> = mutableListOf(Work(), Work())) : Subject(name){

    var familyStatus = _familyStatus
        private set(value) {field = value}

    var work = works[1]
        private set(value) {
            field = value
            works.add(value)
        }

    var previousWork = works[0]
        private set(value) {field = value}

    fun getInfo() : String{
        var result = StringBuilder()
        result.append("name: $name\nage: $age\naddress: $address\nphone: $phone\nfamily status: ")
        when (familyStatus){
            FamilyStatus.MARRIED -> result.append("married\n")
            FamilyStatus.SINGLE -> result.append("single\n")
            FamilyStatus.DATING -> result.append("dating\n")
        }
        result.append("friends: ")
        for (friend in friends){
            result.append("${friend.name} ")
        }
        result.append("\nhobbies: ")
        for (hobby in hobbies){
            result.append("${hobby.name} ")
        }
        for (w in works){
            result.append("\nwork #${works.indexOf(w)}: ${w.name}")
        }
        return result.toString()
    }

    fun changeWork(newWork: Work){
        previousWork = work
        work = newWork
    }

    fun changeFamilyStatus(newStatus: FamilyStatus){
        familyStatus = newStatus
    }
}