package com.example.newsapp.Models

class NewsHeadlines : java.io.Serializable {

    var source: Source? = null
    var author: String = ""
    var title: String = ""
    var description: String = ""
    var url: String = ""
    var urlToImage: String = ""
    var publishedAt: String = ""
    var content: String = ""

}