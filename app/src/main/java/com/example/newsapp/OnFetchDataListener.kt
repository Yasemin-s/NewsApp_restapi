package com.example.newsapp

import com.example.newsapp.Models.NewsHeadlines
/*
interface OnFetchDataListener <NewsApiResponse>{

    // Veriyi getirecek, haber başlıklarının listesini alacağız.
    fun onFetchData(list: List<NewsHeadlines>, message: String)

    // Hata durumlarını işlemek için metot.
    fun onError(message: String)
}
*/

interface OnFetchDataListener {
    fun onFetchData(list: List<NewsHeadlines>, message: String)
    fun onError(message: String)
}
