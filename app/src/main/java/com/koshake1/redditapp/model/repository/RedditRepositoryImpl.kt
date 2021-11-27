package com.koshake1.redditapp.model.repository

import com.koshake1.redditapp.model.data_source.RemoteDataSource

class RedditRepositoryImpl(private val dataSource: RemoteDataSource) : RedditRepository {
    override suspend fun getRedditData() =
        dataSource.getRedditData()
}