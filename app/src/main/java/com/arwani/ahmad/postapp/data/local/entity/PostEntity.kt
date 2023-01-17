package com.arwani.ahmad.postapp.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "posts")
data class PostEntity(
    @field:PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id")
    val id: Int = 0,

    @field:ColumnInfo(name = "name")
    val name: String,

    @field:ColumnInfo(name = "email")
    val email: String,

    @field:ColumnInfo(name = "body")
    val body: String
) : Parcelable
