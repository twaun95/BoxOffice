package com.twaun95.presentation.util

import java.text.SimpleDateFormat
import java.util.*

object StringFormat {
    fun currentDate() : String {return SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis())}
    fun yesterdayDate() : String {
        val date = Date()
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale("ko", "KR"))
        val calendar = Calendar.getInstance().apply {
            time = date
            add(Calendar.DATE, -1)
        }

        return dateFormat.format(calendar.time)
    }

}