package com.sunidhi.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sunidhi.notes.db.RoomRepository
import com.sunidhi.notes.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RoomRepository): ViewModel(){
    var userData: MutableLiveData<List<UserEntity>> = MutableLiveData()

    init{
        loadRecord()
    }

    fun getRecordObserver(): MutableLiveData<List<UserEntity>>{
        return userData
    }

    fun loadRecord(){
        val list = repository.getRecord()
        userData.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity){
        repository.insertRecord(userEntity)
        loadRecord()
    }

}

