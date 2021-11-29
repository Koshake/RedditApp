package com.koshake1.redditapp.model.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.koshake1.redditapp.model.data.Children
import com.koshake1.redditapp.model.data_source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import paging.PagingSource

class RedditRepositoryImpl(private val dataSource: RemoteDataSource) : RedditRepository {
    override fun createDataFlow(pagingConfig: PagingConfig): Flow<PagingData<Children>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { PagingSource(dataSource) }
        ).flow
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 20
    }
}