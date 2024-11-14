package com.mycustomspinnerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mycustomspinnerdemo.databinding.ActivityMainBinding
import com.sriyank.spinner.Countries

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        simpleAdapter()
        CustomAdapterImpl()
    }

    private fun CustomAdapterImpl() {
        var adapter = CustomAdapter(this,Countries.list!!)
        binding.customSpinner.adapter = adapter
    }

    private fun simpleAdapter() {
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.countries,
            android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.simpleSpinner.adapter = adapter

        binding.simpleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var selectedItem = p0?.getItemAtPosition(p2)

                Toast.makeText(this@MainActivity,"Selected Country is : "+"$selectedItem",Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}