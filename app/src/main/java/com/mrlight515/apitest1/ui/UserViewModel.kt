package com.mrlight515.apitest1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrlight515.apitest1.network.UserApi
import com.mrlight515.apitest1.network.UserCard
import kotlinx.coroutines.launch

enum class UserApiStatus { LOADING, ERROR, DONE }

class UserViewModel : ViewModel() {

    private val _status = MutableLiveData<UserApiStatus>()
    private val _users = MutableLiveData<List<UserCard>>()

    val status : LiveData<UserApiStatus> = _status
    val users : LiveData<List<UserCard>> = _users

    init {
        getUserCards()
    }

    private fun getUserCards(){
        viewModelScope.launch {
            _status.value = UserApiStatus.LOADING
            try {
                val listResult = UserApi.retrofitService.getUsers()
                _users.value = listResult
                _status.value = UserApiStatus.DONE
            }catch (e:Exception){
                _status.value = UserApiStatus.ERROR
                _users.value = listOf()
            }
        }
    }
}