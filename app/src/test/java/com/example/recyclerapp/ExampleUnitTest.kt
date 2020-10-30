package com.example.recyclerapp


import name.ank.lab4.BibDatabase
import name.ank.lab4.Keys
import org.junit.Test
import java.io.IOException
import java.io.InputStreamReader


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Throws(IOException::class)
    private fun openDatabase(s: String): BibDatabase? {
        InputStreamReader(javaClass.getResourceAsStream(s))
            .use { reader -> return BibDatabase(reader) }
    }

    @Test
    fun biblibTesting() {
        val database: BibDatabase = openDatabase("/mixed.bib") ?: throw(NullPointerException())
        val first = database.getEntry(1)
        println(database.size())
        println(first.type)
        println(first.getField(Keys.AUTHOR))
    }
}