package com.study.reader.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseDao {

    companion object {
        fun createDocument(
            collectionName: String,
            documentMap: HashMap<String, Any>,
            onSuccess: () -> Unit = {},
            onFailure: () -> Unit = {},
        ) {
            try {
                FirebaseFirestore.getInstance().collection(collectionName).add(documentMap)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) onSuccess.invoke() else onFailure.invoke()
                    }
            } catch (exception: Exception) {
                Log.d("FB", "createDocument: ${exception.message}")
            }

        }
    }
}