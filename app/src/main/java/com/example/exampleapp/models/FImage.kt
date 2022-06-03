package com.example.exampleapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "image_table")
class FImage(@PrimaryKey @ColumnInfo(name = "image") val image: String)