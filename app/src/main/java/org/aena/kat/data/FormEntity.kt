package org.aena.kat.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forms")
data class FormEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val field1: String,
    val field2: String,
    val synced: Boolean = false
)
