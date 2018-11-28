package test.third

class Graph (subjects: Collection<Subject>){
    val content :  MutableMap<Subject, MutableSet<Subject>>

    init {
        content = mutableMapOf()
        for (subject in subjects) {
            when (subject) {
                is Person -> content.put(
                        subject,
                        subject.friends
                                .plus(subject.hobbies)
                                .plus(subject.previousWork)
                                .plus(subject.work)
                                .toMutableSet())
                is Hobby -> content.put(subject, mutableSetOf())
                is Work -> content.put(subject, mutableSetOf())
            }
        }
        for (subject in content.keys) {
            when (subject) {
                is Hobby -> {
                    for (person in content.keys) {
                        if (person is Person && person.hobbies.contains(subject)) {
                            content[subject]!!.add(person)
                        }
                    }
                }
                is Work -> {
                    for (person in content.keys){
                        if (person is Person && (person.work == subject || person.previousWork == subject)){
                                content[subject]!!.add(person)
                        }
                    }
                }
            }
        }
    }

    fun addSubject(subject: Subject){
        if (!content.containsKey(subject)){
            content.put(subject, mutableSetOf())
        }
    }

    fun addLink(firstPerson: Person, secondPerson: Person ){
        if (content.containsKey(firstPerson)) {
            content[firstPerson]?.add(secondPerson)
            firstPerson.friends.add(secondPerson)
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }
        if (content.containsKey(secondPerson)) {
            content[secondPerson]?.add(firstPerson)
            secondPerson.friends.add(firstPerson)
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    fun addLink(person: Person, hobby: Hobby){
        if (content.containsKey(person)) {
            content[person]?.add(hobby)
            person.hobbies.add(hobby)
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }

        if (content.containsKey(hobby)) {
            content[hobby]?.add(person)
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    fun addLink(person: Person, work: Work){
        if (content.containsKey(person)){
            content[person]?.remove(person.previousWork)
            content[person]?.add(work)
            person.changeWork(work)
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }
        if (content.containsKey(work)){
            content[work]?.add(person)
            content[person.previousWork]?.remove(person)
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    fun removeLink(firstPerson: Person,secondPerson: Person){
        if (content.containsKey(firstPerson)) {
            content[firstPerson]?.remove(secondPerson)
            firstPerson.friends.remove(secondPerson)
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }
        if (content.containsKey(secondPerson)) {
            content[secondPerson]?.remove(firstPerson)
            secondPerson.friends.remove(firstPerson)
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    fun removeLink(person: Person,hobby: Hobby){
        if (content.containsKey(person)) {
            content[person]?.remove(hobby)
            person.hobbies.remove(hobby)
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }

        if (content.containsKey(hobby)) {
            content[hobby]?.remove(person)
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    operator fun plus(secondGraph: Graph) : Graph{
        val subjects = this.content.keys.plus(secondGraph.content.keys).toSet()
        val result = Graph(subjects)
        for (subject in result.content.keys){
            if (this.content.containsKey(subject)){
                result.content[subject]?.addAll(this.content[subject]!!.toTypedArray())
            }
            if (secondGraph.content.containsKey(subject)){
                result.content[subject]?.addAll(secondGraph.content[subject]!!.toTypedArray())
            }
        }
        return result
    }
}