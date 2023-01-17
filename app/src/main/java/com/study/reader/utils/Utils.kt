package com.study.reader.utils

import com.google.firebase.auth.FirebaseAuth

object Utils {
    fun getUserName(): String =
        FirebaseAuth.getInstance().currentUser?.email.toString().split("@").first()
            .ifEmpty { "N/A" }

}