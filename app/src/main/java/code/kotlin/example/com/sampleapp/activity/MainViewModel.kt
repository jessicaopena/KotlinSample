package code.kotlin.example.com.sampleapp.activity

import android.arch.lifecycle.MutableLiveData
import code.kotlin.example.com.sampleapp.model.ContactModel
import code.kotlin.example.com.sampleapp.utils.LceState

class MainViewModel constructor() {


    val contacts = MutableLiveData<LceState<ContactModel>>()


}