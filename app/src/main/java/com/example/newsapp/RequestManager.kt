package com.example.newsapp

import android.content.Context
import android.widget.Toast
import com.example.newsapp.Models.NewsApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RequestManager(private val context: Context) {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // API çağrısını yönetme
    fun getNewsHeadlines(listener: OnFetchDataListener, category: String, query: String?) {
        val callNewsApi = retrofit.create(NewsApiService::class.java)
        val call = callNewsApi.getHeadlines("tr", category, query ?: "", context.getString(R.string.api_key))

        call.enqueue(object : retrofit2.Callback<NewsApiResponse> {
            override fun onResponse(call: Call<NewsApiResponse>, response: retrofit2.Response<NewsApiResponse>) {
                if (response.isSuccessful) {
                    listener.onFetchData(response.body()?.articles ?: emptyList(), response.message())
                } else {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                listener.onError("Request failed!")
            }
        })
    }

    // Haber başlıklarını almak için kullanılacak API çağrısı tanımı
    interface NewsApiService {
        @GET("top-headlines")
        fun getHeadlines(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("q") query: String,
            @Query("apiKey") apiKey: String
        ): Call<NewsApiResponse>
    }
}




/*
package com.example.newsapp
import android.content.Context
import android.widget.Toast
import com.example.newsapp.Models.NewsApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


import retrofit2.Callback
import retrofit2.Response





class RequestManager(context: Context) {
    // Bağlam için değişken
    private val context: Context = context

    // Retrofit nesnesini oluşturuyoruz
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/") // API dokümanındaki kısmındaki URL'yi belirtiyoruz
        .addConverterFactory(GsonConverterFactory.create()) // Gson converter'ı ekliyoruz
        .build()


    // api çağrısını yönetme
    fun getNewsHeadlines(listener: OnFetchDataListener, category: String, query: String) {
        val callNewsApi = retrofit.create(CallNewsApi::class.java)
        val call = callNewsApi.callHeadlines("tr", category, query, context.getString(R.string.api_key))

        call.enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>) {
                if (response.isSuccessful) {
                    listener.onFetchData(response.body()?.articles ?: emptyList(), response.message())
                } else {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                listener.onError("request failed!!!!")
            }
        })
    }


    /*
User


    //api çağrısını yönetme
    public void getNewsHeadlines(onFetchDataListener listener,String category, String query ){
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse> call = callNewApi.callHeadlines( "tr", category,query,context.getString(R.string.api_key)  );

        try{
            call.enqueue(new Callback<NewsApiResponse>(){
                @override
                public void onResponse(Call<NewsApiResponse> call, Response <NewsApiResponse> response){
                    if(!response.isSuccessful()){
                        Toast.makeText(context,"error",Toast.LENGTH_SHORT.show(()))
                    }
                    listener.onFetchData(response.body().getArticles(), response.message());
                }
                @override
                public void onFailure(Call<NewsApiResponse> call, ){
                    listener.onError("request failed!!!!");
                }

            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }
kotline çevir ve açıkla

     */

    // Haber başlıklarını almak için kullanılacak API çağrısı tanımını yapıyoruz
    interface NewsApiService {
        @GET("top-headlines")
        fun getHeadlines(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("q") query: String,
            @Query("apiKey") apiKey: String
        ): Call<NewsApiResponse>
    }
}
*/