package com.example.composeperformanceplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BusinessUser(var id: Long, var name: String, var isSelected: Boolean)

@Composable
fun UnstableClassUsageScreen(viewModel: TypicalViewModel = hiltViewModel()) {
    val user by viewModel.user2.observeAsState()
    Box {
        UserDetails(user = user ?: BusinessUser(1, "x", false))
    }
}

@HiltViewModel
class TypicalViewModel @Inject constructor() : ViewModel() {

    private var i = 1
    private val _user = MutableStateFlow(BusinessUser(123L, "test", false))
    val user: StateFlow<BusinessUser> = _user.asStateFlow()

    private val _user2 = MutableLiveData(BusinessUser(133L, "test 2", false))
    val user2: LiveData<BusinessUser> = _user2

    fun increaseCounter() {
        i++
        viewModelScope.launch {
            _user.emit(user.value.copy(name = "TEST $i"))
        }
        viewModelScope.launch {
            //_user2.value?.name = "SECOND TEST $i"
            _user2.value = _user2.value?.copy(name = "SECOND TEST $i")
        }
    }
}

@Composable
private fun UserDetails(user: BusinessUser) {
    Column {
        AwesomeText(user = user)
    }
}

@Composable
private fun AwesomeText(user: BusinessUser) {
    Text(text = "name: ${user.name} id:${user.id}")
}