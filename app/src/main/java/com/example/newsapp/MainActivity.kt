import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.*
import android.widget.SearchView
import com.example.newsapp.Models.NewsHeadlines

class MainActivity : AppCompatActivity(), SelectListener, View.OnClickListener {

    // Gerekli bileşenlerin tanımlamaları
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SearchView bileşenini tanımlama ve onQueryTextListener eklemesi
        searchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Arama yapıldığında yapılacak işlemler
                progressBar.visibility = View.VISIBLE
                val manager = RequestManager(this@MainActivity)
                manager.getNewsHeadlines(listener, category, query)
                progressBar.visibility = View.GONE
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Arama metni değiştiğinde yapılacak işlemler
                return false
            }
        })

        // ProgressBar bileşenini tanımlama ve görünürlüğünü ayarlama
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        // Butonları tanımlama ve tıklama dinleyicisi ekleme
        b1 = findViewById(R.id.btn_1)
        b2 = findViewById(R.id.btn_2)
        b3 = findViewById(R.id.btn_3)
        b4 = findViewById(R.id.btn_4)
        b5 = findViewById(R.id.btn_5)
        b6 = findViewById(R.id.btn_6)
        b7 = findViewById(R.id.btn_7)

        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)

        // Haber başlıklarını getiren istek yöneticisi
        val manager = RequestManager(this)
        manager.getNewsHeadlines(listener, "general", null)
    }

    // Haber başlıkları getirildiğinde tetiklenen listener
    private val listener = object : OnFetchDataListener {
        override fun onFetchData(list: List<NewsHeadlines>, message: String) {
            if (list.isEmpty()) {
                Toast.makeText(this@MainActivity, "No data found!!!", Toast.LENGTH_SHORT).show()
            } else {
                showNews(list)
                progressBar.visibility = View.GONE
            }
        }

        override fun onError(message: String) {
            Toast.makeText(this@MainActivity, "An Error Occurred!!!", Toast.LENGTH_SHORT).show()
        }
    }

    // Haber başlıklarını RecyclerView'da gösterme
    private fun showNews(list: List<NewsHeadlines>) {
        recyclerView = findViewById(R.id.recycler_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        adapter = CustomAdapter(this, list, this)
        recyclerView.adapter = adapter
    }

    // Haber başlığına tıklanıldığında çalışan metod
    override fun onNewsClicked(headline: NewsHeadlines) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("data", headline)
        startActivity(intent)
    }

    // Kategori butonlarına tıklanıldığında çalışan metod
    override fun onClick(v: View?) {
        val button = v as Button
        val category = button.text.toString()

        progressBar.visibility = View.VISIBLE

        val manager = RequestManager(this)
        manager.getNewsHeadlines(listener, category, null)

        progressBar.visibility = View.GONE
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