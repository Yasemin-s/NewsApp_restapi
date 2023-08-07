package com.example.newsapp
// implementation 'com.squareup.picasso:picasso:2.8'
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.newsapp.Models.NewsHeadlines



class CustomAdapter(private val context: Context, private val headlines: List<NewsHeadlines>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // XML dosyasını inflate ederek CustomViewHolder'ı oluşturuyoruz.
        val itemView = LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // Haber başlığını ve haber kaynağını görselleştiriyoruz.
        val headline = headlines[position]
        holder.text_title.text = headline.title
        holder.text_source.text = headline.source?.name

        // Haber resmi varsa, Picasso kütüphanesi ile görseli yüklüyoruz.
        if (headline.urlToImage != null) {
            Picasso.get().load(headline.urlToImage).into(holder.img_headline)
        }
    }

    override fun getItemCount(): Int {
        // Haber başlıklarının toplam sayısını döndürüyoruz.
        return headlines.size
    }
}
