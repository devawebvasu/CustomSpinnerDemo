package com.mycustomspinnerdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mycustomspinnerdemo.databinding.SpinnerItemBinding
import com.sriyank.spinner.Country

class CustomAdapter(context: Context,val countryList : ArrayList<Country>) : ArrayAdapter<Country>(context,0,countryList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup) : View{
        val country = getItem(position)

        val view = LayoutInflater.from(context).inflate(R.layout.spinner_item,parent,false)

        val countryName = view.findViewById<TextView>(R.id.countryName)
        val countryImage = view.findViewById<ImageView>(R.id.countryImage)

        countryName.text = country?.name
        countryImage.setImageResource(country!!.image)

        return view
    }
}