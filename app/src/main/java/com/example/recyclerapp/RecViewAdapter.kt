package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import name.ank.lab4.BibDatabase
import name.ank.lab4.Keys
import name.ank.lab4.Types
import kotlinx.android.synthetic.main.listitem.*
import kotlinx.android.synthetic.main.listitem.view.*

class RecViewAdapter(private val db : BibDatabase) : RecyclerView.Adapter<RecViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return MyViewHolder(itemView)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var title: TextView = itemView.title
            var author: TextView = itemView.author
            var etc: TextView = itemView.etc
            var type: TextView = itemView.type

    }

    override fun getItemCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val position = (position) % 96
        val entry = db.getEntry(position) //Pos starts from 0
        val contTitle = entry.getField(Keys.TITLE)
        val contAuthor = entry.getField(Keys.AUTHOR)
        val contEtc: String
        val contType: String
        when (entry.type) {
            Types.ARTICLE -> {
                contEtc = entry.getField(Keys.JOURNAL)
                contType = "article"
            }
            Types.BOOK ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "book"
            }
            Types.BOOKLET ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "booklet"
            }
            Types.CONFERENCE ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "conference"
            }
            Types.INBOOK ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "inbook"
            }
            Types.INCOLLECTION ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "incollection"
            }
            Types.INPROCEEDINGS ->  {
                contEtc = entry.getField(Keys.BOOKTITLE)
                contType = "inproceeding"
            }
            Types.MANUAL ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "manual"
            }
            Types.MASTERSTHESIS ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "masterthesis"
            }
            Types.MISC ->  {
                contEtc = entry.getField(Keys.EDITOR)
                contType = "misc"
            }
            Types.PHDTHESIS ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "phdthesis"
            }
            Types.PROCEEDINGS ->  {
                contEtc = entry.getField(Keys.YEAR)
                contType = "proceedings"
            }
            Types.TECHREPORT ->  {
                contEtc = entry.getField(Keys.PUBLISHER)
                contType = "techreport"
            }
            Types.UNPUBLISHED ->  {
                contEtc = entry.getField(Keys.URL)
                contType = "unpublished"
            }
            else -> {
                contEtc = "UNKNOWN"
                contType = "UNKNOWN"
            }
        }

        holder.title.text = contTitle
        holder.author.text = contAuthor
        holder.etc.text = contEtc
        holder.type.text = contType
    }
}