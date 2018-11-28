package test.third



class Person (name: String,
              val age: Int,
              val address: String,
              val phone: String,
              _familyStatus: FamilyStatus = FamilyStatus.SINGLE,
              val friends: MutableList<Person> = mutableListOf(),
              val hobbies: MutableList<Hobby> = mutableListOf(),
              _work: Work = Work(),
              _previousWork: Work = Work()) : Subject(name){
    var familyStatus = _familyStatus
        private set(value) {field = value}

    var work = _work
        private set(value) {field = value}

    var previousWork = _previousWork
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
        result.append("\nprevious work: ${previousWork.name}\ncurrent work: ${work.name}\n")
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