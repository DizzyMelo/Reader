package com.study.reader.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.study.reader.data.FirebaseDao
import com.study.reader.utils.Constants
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    //    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun signInWithEmailAndPassword(email: String, password: String, navigate: () -> Unit) =
        viewModelScope.launch {
            try {
                if (_loading.value == true) return@launch
                _loading.value = true
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        _loading.value = false
                        if (task.isSuccessful) {
                            //TODO("take user to home screen")
                            navigate.invoke()
                        } else {
                            //TODO("display fail attempt message")
                        }
                    }
            } catch (exception: Exception) {
                Log.d("FB Auth", "signInWithEmailAndPassword: ${exception.message}")
            }
        }

    fun createUserWithEmailAndPassword(email: String, password: String, navigate: () -> Unit) =
        viewModelScope.launch {
            try {
                if (_loading.value == true) return@launch
                _loading.value = true
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    _loading.value = false
                    if (task.isSuccessful) {
                        createUser()
                        navigate.invoke()
                    } else {
                        //TODO("display fail attempt message")
                    }
                }
            } catch (exception: Exception) {
                Log.d("FB Auth", "createUserWithEmailAndPassword: ${exception.message}")
            }
        }

    private fun createUser() {
        val user = auth.currentUser!!
        val userMap = hashMapOf<String, Any>()
        userMap["user_id"] = user.uid
        userMap["display_name"] = user.email!!.split("@").first()

        FirebaseDao.createDocument(
            collectionName = Constants.USERS_COLLECTION_NAME,
            documentMap = userMap,
            onSuccess = {
                Log.d("FB", "createUser: user created successfully")
            },
            onFailure = {
                Log.d("FB", "createUser: something went wrong")
            })
    }

}