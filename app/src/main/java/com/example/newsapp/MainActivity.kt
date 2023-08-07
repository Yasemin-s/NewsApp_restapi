import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.CustomAdapter
import com.example.newsapp.Models.NewsHeadlines
import com.example.newsapp.OnFetchDataListener
import com.example.newsapp.R
import com.example.newsapp.RequestManager
//46.dk
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = RequestManager(this)
        manager.getNewsHeadlines(listener, "general", null)
    }

    private val listener = object : OnFetchDataListener {
        override fun onFetchData(list: List<NewsHeadlines>, message: String) {
            showNews(list)
        }

        override fun onError(message: String) {
            // Error handling if needed
        }
    }

    private fun showNews(list: List<NewsHeadlines>) {
        recyclerView = findViewById(R.id.recycler_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        adapter = CustomAdapter(this, list)
        recyclerView.adapter = adapter
    }
}


/*
package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.Models.NewsHeadlines

class MainActivity : AppCompatActivity() {

    RecyclerView recyclerView;
    CustomAdapter adapter;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>(){
        @override
        public void onFetchData(List<NewsHeadlines> list, String message){
            showNews(list);
        }

        @override
        public void onError(String message){

        }
    };
    private void showNews(List<NewsHeadlines> list){
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
} kotline çevir ve açıkla


 */