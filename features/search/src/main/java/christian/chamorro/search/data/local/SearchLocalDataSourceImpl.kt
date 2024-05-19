package christian.chamorro.search.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import christian.chamorro.search.data.datasources.SearchLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchLocalDataSourceImpl
    @Inject
    constructor(
        private val dataStore: DataStore<Preferences>,
    ) : SearchLocalDataSource {
        private val queries = stringSetPreferencesKey("queries")

        override suspend fun getQueries(): Flow<List<String>> {
            return dataStore.data.map {
                it[queries]?.toList() ?: emptyList()
            }
        }

        override suspend fun saveQuery(query: String) {
            dataStore.edit {
                val currentQueries = it[queries]?.toList() ?: emptyList()
                val lastQuery = listOf(query) + currentQueries
                if (lastQuery.indices.last > 9){
                    it[queries] = lastQuery.subList(0, 10).toSet()
                }else{
                    it[queries] = lastQuery.toSet()
                }

            }
        }

        override suspend fun deleteQuery(query: String) {
            dataStore.edit {
                val currentQueries = it[queries]?.toMutableList() ?: mutableListOf()
                currentQueries.remove(query)
                it[queries] = currentQueries.toSet()
            }
        }
    }
