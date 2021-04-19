package com.example.policeman

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class AdapterListView(context: Context, resource: Int): BaseAdapter() {
    var resource: Int? = null
    var items: ArrayList<Response.wantedItem>? = null

    constructor(context: Context, resource: Int, items: ArrayList<Response.wantedItem>): this(context, resource){

        this.resource = resource
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = null

        if (convertView == null){
            view = LayoutInflater.from(parent?.context).inflate(resource!!, parent, false)
        } else {
            view = convertView
        }

        Picasso.get().load(items?.get(position)?.photo).into(view?.findViewById<ImageView>(R.id.photoPrestupnika))

        view?.findViewById<TextView>(R.id.first)?.text = items?.get(position)?.first_name
        view?.findViewById<TextView>(R.id.last)?.text = items?.get(position)?.last_name
        view?.findViewById<TextView>(R.id.nick)?.text = items?.get(position)?.nicknames
        view?.findViewById<TextView>(R.id.status)?.text = items?.get(position)?.status
        view?.findViewById<TextView>(R.id.lastlocation)?.text = items?.get(position)?.last_location
        view?.findViewById<TextView>(R.id.description)?.text = items?.get(position)?.description

        return view!!

    }

    override fun getItem(position: Int): Response.wantedItem? {
    return  items?.get(position)
    }

    override fun getItemId(position: Int): Long {
    return position.toLong()
    }

    override fun getCount(): Int {
        return items?.size!!
    }
}