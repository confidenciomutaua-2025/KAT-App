package org.aena.kat.data

import androidx.room.*

@Dao
interface FormDao {
    @Insert suspend fun insert(form: FormEntity)
    @Query("SELECT * FROM forms") suspend fun getAll(): List<FormEntity>
    @Update suspend fun update(form: FormEntity)
}
