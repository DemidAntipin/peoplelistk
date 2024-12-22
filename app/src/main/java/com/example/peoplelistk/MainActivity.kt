package com.example.peoplelistk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val people = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lvPeople = findViewById<ListView>(R.id.people)
        //val people = arrayOf("Petya", "Vasya", "Mary") // массив неизменяем
        var names = resources.getStringArray(R.array.names)
        names = names.toList().shuffled().toTypedArray()
        var surnames = resources.getStringArray(R.array.surnames)
        surnames = surnames.toList().shuffled().toTypedArray()
        for (i in 0 until names.size){
            people.add((names[i]+" "+surnames[i]))
        }
        val adapter = ArrayAdapter<String>(this, R.layout.item, people)
        lvPeople.adapter = adapter // задаём адаптер (посредник) для отображения данных на списке

    }

    fun onAddPersonClick(view: View) {
        val newperson = findViewById<EditText>(R.id.newperson)
        people.add(newperson.text.toString())
        newperson.text.clear()
    }
}