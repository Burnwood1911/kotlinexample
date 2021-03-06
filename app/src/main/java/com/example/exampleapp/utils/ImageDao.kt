package com.example.exampleapp.utils

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exampleapp.models.FImage

@Dao
interface ImageDao {

    @Query("SELECT * FROM image_table")
    fun getImages(): List<FImage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(image: FImage)

}