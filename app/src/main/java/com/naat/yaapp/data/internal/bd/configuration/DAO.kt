package com.naat.yaapp.data.internal.bd.configuration

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.naat.yaapp.data.models.Recharge

@Dao
interface DAO {
    @Insert
    fun insertRecharges(recharges: Array<Recharge>)

    @Query("SELECT * FROM Recharge")
    fun selectRecharges(): Array<Recharge>

    @Query("SELECT companyName FROM Recharge GROUP BY companyName")
    fun selectCompanyRecharges(): Array<String>
}