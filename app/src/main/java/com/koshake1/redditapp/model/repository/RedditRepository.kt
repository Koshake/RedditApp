package com.koshake1.redditapp.model.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.koshake1.redditapp.model.data.Children
import com.koshake1.redditapp.model.data.RedditResponse
import kotlinx.coroutines.flow.Flow
import javax.sql.DataSource

interface RedditRepository {
   suspend fun getRedditData() : RedditResponse
   suspend fun getRedditDataByAfter(after : String) : RedditResponse
   fun createDataFlow(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<Children>>

   private fun getDefaultPageConfig(): PagingConfig {
      return PagingConfig(pageSize = RedditRepositoryImpl.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
   }
}