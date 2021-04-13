package com.example.policeman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import retrofit2.Call

class department : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)

        var items: ArrayList<Response.departmentItem>? = null

        val service = ServiceBuilder.buildService(Service::class.java).department().enqueue(object: retrofit2.Callback<Response.department>{
            override fun onResponse(
                    p0: Call<Response.department>?,
                    p1: retrofit2.Response<Response.department>?
            ) {
                if (p1?.code() == 200){
                    items = p1?.body().data
                    val adapter = AdapterDepart(this@department, R.layout.department1, items!!)
                    findViewById<ListView>(R.id.listView2).adapter = adapter
                }

            }

            override fun onFailure(p0: Call<Response.department>?, p1: Throwable?) {
                TODO("Not yet implemented")
            }

        }
        )

    }
}