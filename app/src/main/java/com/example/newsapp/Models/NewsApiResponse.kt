package com.example.newsapp.Models

import java.io.Serializable

class NewsApiResponse : Serializable {
    var status: String = ""
    var totalResults: Int = 0
    var articles: List<NewsHeadlines>? = null
}
