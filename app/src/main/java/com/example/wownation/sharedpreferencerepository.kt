package com.example.wownation

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.datastore: DataStore<Preferences> by preferencesDataStore("das")
class loginmanager(context: Context) {


    private val dataStore = context.datastore
    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
    val getloginstatus:Flow<Int> = dataStore.data.map {
         it[EXAMPLE_COUNTER] ?: 0
        }

    suspend fun setloginstatus(){
        val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
        dataStore.edit {
            it[EXAMPLE_COUNTER] = 1
        }

    }

}