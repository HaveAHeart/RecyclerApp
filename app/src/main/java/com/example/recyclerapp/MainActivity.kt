package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import name.ank.lab4.BibDatabase
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db: BibDatabase = openDatabase() ?: throw(NullPointerException())
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = RecViewAdapter(db)

        recView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun openDatabase(): BibDatabase? {
        InputStreamReader(javaClass.getResourceAsStream("/mixed.bib"))
            .use { reader -> return BibDatabase(reader) }
    }
}