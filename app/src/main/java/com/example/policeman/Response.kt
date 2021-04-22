package com.example.policeman

class Response {
    data class response(
        val data: responseItem,
        val success: Boolean
    )

    data class responseItem (
        val id: String,
        val login: String,
        val name: String,
        val token: String
    )

    data class wanted(
            val data: ArrayList<wantedItem>,
            val success: Boolean
    )

    data class wantedItem(
            val id: String,
            val first_name: String,
            val last_name: String,
            val last_location: String,
            val nicknames: String,
            val description: String,
            val photo: String,
            val status: String
    )

    data class department(
            val data: ArrayList<departmentItem>,
            val success: Boolean
    )

    data class departmentItem(
        val id: String,
        val address: String,
        val boss: String,
        val name: String,
        val phone: String,
        val email: String,
        val description: String,
        val coords: String
    )
}