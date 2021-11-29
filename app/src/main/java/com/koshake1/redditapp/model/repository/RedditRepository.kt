package com.koshake1.redditapp.model.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.koshake1.redditapp.model.data.Children
import kotlinx.coroutines.flow.Flow

interface RedditRepository {
   fun createDataFlow(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<Children>>

   private fun getDefaultPageConfig(): PagingConfig {
      return PagingConfig(pageSize = RedditRepositoryImpl.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
   }
}