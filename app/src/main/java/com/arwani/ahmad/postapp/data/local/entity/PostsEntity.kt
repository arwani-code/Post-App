package com.arwani.ahmad.postapp.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "posts")
data class PostsEntity(
    @field:PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id")
    val id: Int = 0,

    @field:ColumnInfo(name = "name")
    var name: String,

    @field:ColumnInfo(name = "email")
    var email: String,

    @field:ColumnInfo(name = "body")
    var body: String
) : Parcelable
