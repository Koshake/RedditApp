package paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.koshake1.redditapp.model.data.Children
import com.koshake1.redditapp.model.data_source.RemoteDataSource
import java.io.IOException
import java.net.HttpRetryException

class PagingSource(
    private val dataSource: RemoteDataSource,
    ) : PagingSource<String, Children>() {

    override fun getRefreshKey(state: PagingState<String, Children>): String? {
        val pos = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(pos) ?: return null
        return page.prevKey ?: page.nextKey
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Children> {
        return try {
            val pageId = params.key
            val response = if (pageId == null) {
                dataSource.getRedditData()
            } else {
                dataSource.getRedditDataByAfter(pageId)
            }
            LoadResult.Page(
                response.data.children,
                prevKey = response.data.before,
                nextKey = response.data.after
            )
        } catch (exception : IOException) {
            return  LoadResult.Error(exception)
        } catch (exception : HttpRetryException) {
            return LoadResult.Error(exception)
        }

    }
}