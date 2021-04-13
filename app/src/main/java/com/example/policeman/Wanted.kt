package com.example.policeman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import retrofit2.Call
import javax.security.auth.callback.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Wanted.newInstance] factory method to
 * create an instance of this fragment.
 */
class Wanted : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_wanted, container, false)
        var items: ArrayList<Response.wantedItem>? = null

        val service = ServiceBuilder.buildService(Service::class.java).wanted().enqueue(object: retrofit2.Callback<Response.wanted>{
            override fun onFailure(p0: Call<Response.wanted>?, p1: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                p0: Call<Response.wanted>?,
                p1: retrofit2.Response<Response.wanted>?
            ) {
                if (p1?.code() == 200){
                    items = p1?.body().data
                    val adapter = AdapterListView(context!!, R.layout.prestupnik1, items!!)

                        view.findViewById<ListView>(R.id.listView).adapter = adapter
                        }

            }
        })

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Wanted.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Wanted().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}