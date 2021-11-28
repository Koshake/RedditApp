package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.koshake1.redditapp.model.data.Children
import com.koshake1.redditapp.model.repository.RedditRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val repository : RedditRepository) : ViewModel() {
    fun fetchData(): Flow<PagingData<Children>> {
        return repository.createDataFlow()
            .cachedIn(viewModelScope)
    }
}