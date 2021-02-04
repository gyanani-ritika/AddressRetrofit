package com.example.placesretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import io.harkema.retrofitcurlprinter.RetrofitCurlPrinterInterceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var txtResult: TextView? = null
    lateinit var edttxt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult = findViewById(R.id.txtv)
        edttxt = findViewById(R.id.etdtext)
        val search: Button = findViewById(R.id.btn)
        search.setOnClickListener {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(RetrofitCurlPrinterInterceptor(object :
                io.harkema.retrofitcurlprinter.Logger {
                override fun log(message: String) {
                    Log.i("api", message)
                }
            }))
            val retrofit = Retrofit.Builder()
                .baseUrl("http://125.21.241.6/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
            val jsonAPI: JsonAPI = retrofit.create(JsonAPI::class.java)
            val call: Call<Example> = jsonAPI.getPlaces(
                limit = 2,
                uhm = false,
                query = edttxt.text.toString(),
                pincode = true
            )
            call.enqueue(object : Callback<Example> {
                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    if (response.isSuccessful) {
                        txtResult?.text = Gson().toJson(response.body())
                        return
                    }
                    txtResult?.text = "Not Successful"
                }

                override fun onFailure(call: Call<Example>, t: Throwable) {
                    txtResult?.text = t.message
                }

            })
        }
    }
}
