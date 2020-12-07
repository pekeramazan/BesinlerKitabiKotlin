package com.ramazanpeker.besinlerkitabikotlin.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ramazanpeker.besinlerkitabikotlin.model.Besin
@Dao
interface BesinDAO {
    //data access object
    @Insert
    suspend fun  insertAll(vararg besin:Besin): List<Long>

    //Insert -> room,insret into
    //suspend-> coroutone scope
    //vararg->birden fazla ve istediğimiz sayıda besin
    //List<Long> *> long id ler listesi

    @Query("SELECT*FROM besin")
    suspend fun getAllBesin():List<Besin>

    @Query("SELECT*FROM besin WHERE uuid=:besinId")
    suspend fun  getBesin(besinId:Int):Besin

    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()

}