package com.ata.core.data.datasource.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ata.core.util.TableConstants.COL_NAME
import com.ata.core.util.TableConstants.COL_PAYMENT
import com.ata.core.util.TableConstants.TABLE_FRIEND

//@Parcelize
@Entity(tableName = TABLE_FRIEND)
data class Friend(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = COL_NAME) val name: String = "",
    @ColumnInfo(name = COL_PAYMENT) val payment: Int = 0
)
//    : Parcelable