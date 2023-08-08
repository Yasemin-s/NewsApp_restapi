package com.example.newsapp

import com.example.newsapp.Models.NewsHeadlines

interface SelectListener {
    //fun onHeadlineSelected(headline: NewsHeadlines)
    fun onNewsClicked(headline: NewsHeadlines) // onNewsClicked fonksiyonunu burada tanımlayın
}
