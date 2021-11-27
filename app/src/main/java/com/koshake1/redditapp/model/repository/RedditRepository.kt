package com.koshake1.redditapp.model.repository

import com.koshake1.redditapp.model.data.RedditResponse
import javax.sql.DataSource

interface RedditRepository {
   suspend fun getRedditData() : RedditResponse
}