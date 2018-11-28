package test.third

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task_1KtTest {
    @Test
    fun plus() {
        val yandex = Work("Yandex")
        val gazprom = Work("Gazprom")
        val sberbank = Work("Sberbang")
        val mcDonadls = Work("mcDonadls")
        val guitar = Hobby("Guitar")
        val piano = Hobby("Piano")
        val drawing = Hobby("Drawing")
        val petya = Person("Petya",
                43,
                "Ligovskiy 134",
                "+79058757483",
                FamilyStatus.SINGLE,
                mutableListOf(),
                mutableListOf(piano,guitar),
                gazprom,
                sberbank)
        val slava = Person("Slava",
                27,
                "Ligovskiy 78",
                "+79058757496",
                FamilyStatus.MARRIED,
                mutableListOf(),
                mutableListOf(guitar,drawing),
                yandex,
                gazprom)
        val stepan = Person("Stepan",
                18,
                "Botanicheskaya 70",
                "+78034269494",
                FamilyStatus.SINGLE,
                mutableListOf(),
                mutableListOf(),
                mcDonadls,
                gazprom)
        val fullGraph = Graph(arrayListOf(yandex,gazprom,sberbank,mcDonadls,guitar,piano,drawing,petya,slava,stepan))
        assertTrue(fullGraph.content[guitar]!!.contains(petya))
        assertTrue(fullGraph.content[guitar]!!.contains(slava))
        assertTrue(fullGraph.content[drawing]!!.contains(slava))
        assertTrue(fullGraph.content[gazprom]!!.contains(stepan))
        val graph1 = Graph(arrayListOf(petya,slava,stepan,mcDonadls,gazprom,guitar,yandex))
        graph1.addLink(stepan,slava)
        graph1.addLink(stepan,guitar)
        graph1.addLink(stepan,yandex)
        assertTrue(stepan.friends.contains(slava))
        assertTrue(stepan.hobbies.contains(guitar))
        assertTrue(stepan.previousWork == mcDonadls)
        assertTrue(stepan.work == yandex)
        assertTrue(graph1.content[stepan]!!.contains(slava))
        assertTrue(graph1.content[stepan]!!.contains(guitar))
        assertTrue(graph1.content[stepan]!!.contains(mcDonadls))
        assertTrue(graph1.content[stepan]!!.contains(yandex))
        assertFalse(graph1.content[stepan]!!.contains(gazprom))
        graph1.removeLink(stepan,guitar)
        graph1.removeLink(stepan,slava)
        assertFalse(stepan.friends.contains(slava))
        assertFalse(stepan.hobbies.contains(guitar))
        assertFalse(graph1.content[stepan]!!.contains(slava))
        assertFalse(graph1.content[stepan]!!.contains(guitar))
   }
}