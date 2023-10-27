package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edit_text:EditText=findViewById(R.id.edt_1)
        val button:Button=findViewById(R.id.btn_1)
        val list_view:ListView=findViewById(R.id.listview_1)
        val Activity_list= mutableListOf<String>("dancing","swimming","karate","football","cricket","rangoli making","art and craft")
        val Activity_adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,Activity_list)
         button.setOnClickListener {
             val name=edit_text.text.toString()
             Activity_list.add(name)
             Activity_adapter.notifyDataSetChanged()
         }
        list_view.adapter=Activity_adapter
        list_view.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Activity_list.removeAt(p2)
                Activity_adapter.notifyDataSetChanged()

            }

        })
    }

}