package com.example.restapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
/*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       // lateinit var recyle:RecyclerView;
        lateinit var myadpter:UserAdapter;

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewResult: TextView = findViewById(R.id.textViewResult)
        //val textViewResultbyid: TextView = findViewById(R.id.textViewResultbyid)
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            try {

            val deleteResponse = ApiClient.apiService.deleteOffre(5)
                val newOffre = offre(190, "tw ", "tw", "tw", "tw", 190)
               val createResponse = ApiClient.apiService.createOffre(newOffre)



                val responseid = ApiClient.apiService.getOffreById(5)




                val offreToUpdate = offre(

                    intitule = "updaedd 666666666",
                    specialite = "updated",
                    societe = "lalal",
                    pays = "ddd",
                    nbpostes = 8
                )
                val offreIdToUpdate = 1


                    val responseupdate = ApiClient.apiService.updateOffre(offreIdToUpdate, offreToUpdate)


                val response = ApiClient.apiService.getAllOffres()

                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body().toString()
                    val responseBodyid = responseid.body().toString()

                    Log.i("Success", responseBody)
                    textViewResult.text = responseBody
                    //textViewResultbyid.text=responseBodyid





                } else {
                    val errorMessage = response.message()
                    Log.e("Error", errorMessage)
                    textViewResult.text = errorMessage
                }
            } catch (e: Exception) {
                val error = e.message.toString()
                Log.e("Error", error)
                textViewResult.text =error
            }
        }
    }
}
*/

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val offresList: ArrayList<offre> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RecycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter(offresList)
        recyclerView.adapter = userAdapter

        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            try {
                val response = ApiClient.apiService.getAllOffres()
                if (response.isSuccessful && response.body() != null) {
                    offresList.clear()
                    offresList.addAll(response.body()!!)
                    userAdapter.notifyDataSetChanged()
                } else {
                    showError("Failed to fetch data")
                }
            } catch (e: Exception) {
                showError(e.message ?: "An error occurred")
            }
        }
    }

    private fun showError(message: String) {
        Log.e("Error", message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
