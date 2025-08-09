package com.example.postfetcherice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.content.Intent
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFragment3 : Fragment() {

    private lateinit var tvUserId: TextView
    private lateinit var tvId: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvBody: TextView
    private lateinit var btnGenerateJson: Button

    private var currentPost: Post? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post3, container, false)

        tvUserId = view.findViewById(R.id.tvUserId)
        tvId = view.findViewById(R.id.tvId)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvBody = view.findViewById(R.id.tvBody)
        btnGenerateJson = view.findViewById(R.id.btnGenerateJson)

        fetchPost()

        btnGenerateJson.setOnClickListener {
            currentPost?.let {
                val gson = Gson()
                val jsonString = gson.toJson(it)
                val intent = Intent(requireContext(), JsonDisplayActivity::class.java)
                intent.putExtra("json_data", jsonString)
                startActivity(intent)
            } ?: Toast.makeText(requireContext(), "No data to generate JSON", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun fetchPost() {
        RetrofitClient.instance.getPost(userId = 1, id = 5).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    currentPost = response.body()!![0]
                    tvUserId.text = "User ID: ${currentPost!!.userId}"
                    tvId.text = "ID: ${currentPost!!.id}"
                    tvTitle.text = "Title: ${currentPost!!.title}"
                    tvBody.text = "Body: ${currentPost!!.body}"
                } else {
                    Toast.makeText(requireContext(), "No post found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("PostFragment3", "API call failed", t)
            }
        })
    }
}
