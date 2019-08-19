package com.example.spinner_using_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.dropdown)
        val textView: TextView = findViewById(R.id.heading)
        val spinner2 : Spinner = findViewById(R.id.dropdown2)
        // Initialize the String Array
        val color = arrayOf("Red", "Green", "Blue", "Perpale", "Pink", "Magenda", "Gray")
        val red = arrayOf("Got", "Slot","Pen", "Keyboard")
        val blue = arrayOf("apple", "popy", "Iluminati", "Deep Web")
        //Initialize the Array Adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, color)
        // Set the Drop Down View Resourese
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the Adapter To the spinner
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, Id: Long) {
                //textView.text = "Selected Item is : ${parent?.getItemAtPosition(position).toString()}"
                textView.text =  "Selected Item is : ${color.get(position)} "
                if (position == 0){
                    val adapter2 = ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_dropdown_item, red)
                    adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                    spinner2.adapter = adapter2
                    spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }
                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                            val itemSelect = red[p2]
                            Toast.makeText(this@MainActivity, "Selected item is :- $itemSelect", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
                if (position == 1){
                    val adapter3 = ArrayAdapter(this@MainActivity, android.R.layout.simple_dropdown_item_1line, blue)
                    adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                    spinner2.adapter = adapter3
                    spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(p0: AdapterView<*>?) {

                        }

                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                            val itemSelect2 = blue[p2]
                            Toast.makeText(this@MainActivity, "Selected item is :- $itemSelect2", Toast.LENGTH_LONG).show()
                        }

                    }
                }
                if (position == 2){

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                textView.text = " please select an option"
            }

        }

    }
}












































