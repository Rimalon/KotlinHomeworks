package test.third

class Graph (subjects: Collection<Subject>) {
    val content: MutableMap<Subject, MutableSet<Subject>>

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
                    for (person in content.keys) {
                        if (person is Person && (person.work == subject || person.previousWork == subject)) {
                            content[subject]!!.add(person)
                        }
                    }
                }
            }
        }
    }

    fun addSubject(subject: Subject) {
        if (!content.containsKey(subject)) {
            content.put(subject, mutableSetOf())
        }
    }

    fun changeLink(firstPerson: Person, secondPerson: Person, opType: OperationType) {
        if (content.containsKey(firstPerson)) {
            if (opType == OperationType.ADD) {
                content[firstPerson]?.add(secondPerson)
                firstPerson.friends.add(secondPerson)
                Logger.putInfo(firstPerson,"${firstPerson.name} is now friends with ${secondPerson.name}")
            } else {
                content[firstPerson]?.remove(secondPerson)
                firstPerson.friends.remove(secondPerson)
                Logger.putInfo(firstPerson,"${firstPerson.name}  is no longer friends with ${secondPerson.name}")
            }
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }
        if (content.containsKey(secondPerson)) {
            if (opType == OperationType.ADD) {
                content[secondPerson]?.add(firstPerson)
                secondPerson.friends.add(firstPerson)
                Logger.putInfo(secondPerson,"${secondPerson.name}  is now friends with ${firstPerson.name}")
            } else {
                content[secondPerson]?.remove(firstPerson)
                secondPerson.friends.remove(firstPerson)
                Logger.putInfo(secondPerson,"${secondPerson.name}  is no longer friends with ${firstPerson.name}")
            }
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    fun changeLink(person: Person, hobby: Hobby, opType: OperationType) {
        if (content.containsKey(person)) {
            if (opType == OperationType.ADD) {
                content[person]?.add(hobby)
                person.hobbies.add(hobby)
                Logger.putInfo(person,"${person.name} is now keen on ${hobby.name}")
            } else {
                content[person]?.remove(hobby)
                person.hobbies.remove(hobby)
                Logger.putInfo(person,"${person.name} is no longer keen on  ${hobby.name}")
            }
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }
        if (content.containsKey(hobby)) {
            if (opType == OperationType.ADD) {
                content[hobby]?.add(person)
            } else {
                content[hobby]?.remove(person)
            }
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    fun changeLink(person: Person, work: Work ) {
        if (content.containsKey(person)) {
            content[person]?.remove(person.previousWork)
            content[person]?.add(work)
            person.changeWork(work)
            Logger.putInfo(person,"${person.name} is now working on ${work.name}")
        } else {
            throw GraphsLinkException("Unexpected first argument")
        }
        if (content.containsKey(work)) {
            content[work]?.add(person)
            content[person.previousWork]?.remove(person)
        } else {
            throw GraphsLinkException("Unexpected second argument")
        }
    }

    operator fun plus(secondGraph: Graph): Graph {
        val subjects = this.content.keys.plus(secondGraph.content.keys).toSet()
        val result = Graph(subjects)
        for (subject in result.content.keys) {
            if (this.content.containsKey(subject)) {
                result.content[subject]?.addAll(this.content[subject]!!.toTypedArray())
            }
            if (secondGraph.content.containsKey(subject)) {
                result.content[subject]?.addAll(secondGraph.content[subject]!!.toTypedArray())
            }
        }
        return result
    }
}