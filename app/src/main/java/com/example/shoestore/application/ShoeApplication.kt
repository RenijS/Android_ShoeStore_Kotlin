package com.example.shoestore.application

import android.app.Application
import com.example.shoestore.model.ItemRepository
import com.example.shoestore.model.ItemRoomDatabase

//need to add this as name in AndroidManifest
class ShoeApplication: Application() {

    private val database by lazy { ItemRoomDatabase.getDatabase(this) }

    val repository by lazy { ItemRepository(database.getItemDao()) }
}