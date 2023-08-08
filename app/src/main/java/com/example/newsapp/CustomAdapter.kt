package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.newsapp.Models.NewsHeadlines

class CustomAdapter(
    private val context: Context,
    private val headlines: List<NewsHeadlines>,
    private val listener: SelectListener // SelectListener'ı burada tanımladık
) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val headline = headlines[position]
        holder.text_title.text = headline.title
        holder.text_source.text = headline.source?.name

        if (headline.urlToImage != null) {
            Picasso.get().load(headline.urlToImage).into(holder.img_headline)
        }

        // Kart görünümü için tıklama dinleyicisi oluşturuluyor.
        holder.cardView.setOnClickListener {
            listener.onNewsClicked(headlines[position])
        }


        /*holder.itemView.setOnClickListener {
            listener.onHeadlineSelected(headline)
        }*/
    }

    override fun getItemCount(): Int {
        return headlines.size
    }
}
