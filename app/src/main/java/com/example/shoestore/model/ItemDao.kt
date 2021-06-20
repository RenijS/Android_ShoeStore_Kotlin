package com.example.shoestore.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert
    suspend fun insertShoeDetails(item: Item)

    @Query("SELECT * FROM shoe_table ORDER BY ID")
    fun getAllShoeList(): Flow<List<Item>>

    @Query("SELECT * FROM shoe_table WHERE id = :id")
    fun getShoeWithId(id:Int): Item
}