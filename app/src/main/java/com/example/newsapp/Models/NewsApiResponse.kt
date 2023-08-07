package com.example.newsapp.Models

class NewsApiResponse {
    var status: String = ""
    var totalResults: Int = 0
    var articles: List<NewsHeadlines>? = null
}