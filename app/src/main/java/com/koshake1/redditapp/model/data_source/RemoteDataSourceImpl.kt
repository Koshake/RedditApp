package com.koshake1.redditapp.model.data_source

import com.koshake1.redditapp.api.ApiService

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {
    override suspend fun getRedditData() =
        apiService.getHotData().await()

}