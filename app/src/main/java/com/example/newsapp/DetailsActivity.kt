package com.example.newsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.Models.NewsHeadlines
import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var headlines: NewsHeadlines

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // XML bileşenlerinin tanımlanması
        val txt_title = findViewById<TextView>(R.id.text_detail_title)
        val txt_author = findViewById<TextView>(R.id.text_detail_author)
        val txt_time = findViewById<TextView>(R.id.text_detail_time)
        val txt_detail = findViewById<TextView>(R.id.text_detail_detail)
        val txt_content = findViewById<TextView>(R.id.text_detail_content)
        val img_news = findViewById<ImageView>(R.id.img_detail_news)

        // Intent üzerinden haber başlığı nesnesinin alınması
        headlines = intent.getSerializableExtra("data") as NewsHeadlines

        // XML bileşenlerine haber başlığı bilgilerinin atanması
        txt_title.text = headlines.title
        txt_author.text = headlines.author
        txt_time.text = headlines.publishedAt
        txt_detail.text = headlines.description
        txt_content.text = headlines.content

        // Haber görselinin Picasso kütüphanesi ile yüklenmesi
        Picasso.get().load(headlines.urlToImage).into(img_news)
    }
}
