package com.example.shoestore.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "shoe_table")
class Item(
    @ColumnInfo var name: String,
    @ColumnInfo var description: String,
    @ColumnInfo var price: Double,
    @ColumnInfo var company: String,
    @ColumnInfo var sex: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
): Parcelable