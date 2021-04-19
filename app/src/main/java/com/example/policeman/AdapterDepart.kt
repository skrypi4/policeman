package com.example.policeman

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView

class AdapterDepart(val ctx: Context,val resource: Int, val items: ArrayList<Response.departmentItem>): ArrayAdapter<Response.departmentItem>(ctx, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = null

        if (convertView == null){
            view = LayoutInflater.from(parent?.context).inflate(resource!!, parent, false)
        } else {
            view = convertView
        }
        view?.findViewById<TextView>(R.id.depatId)?.text = items?.get(position)?.id
        view?.findViewById<TextView>(R.id.departAdress)?.text = items?.get(position)?.address
        view?.findViewById<TextView>(R.id.departBoss)?.text = items?.get(position)?.boss
        view?.findViewById<TextView>(R.id.departName)?.text = items?.get(position)?.name
        view?.findViewById<TextView>(R.id.departPhone)?.text = items?.get(position)?.phone
        view?.findViewById<TextView>(R.id.departEmail)?.text = items?.get(position)?.email
        view?.findViewById<TextView>(R.id.departDescr)?.text = items?.get(position)?.description
        view?.findViewById<TextView>(R.id.departCoord)?.text = items?.get(position)?.coords
        return  view!!
    }
}