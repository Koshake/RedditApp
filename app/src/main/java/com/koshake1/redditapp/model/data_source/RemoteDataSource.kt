package com.koshake1.redditapp.model.data_source

import com.koshake1.redditapp.model.data.RedditResponse

interface RemoteDataSource {
    suspend fun getRedditData() : RedditResponse
}