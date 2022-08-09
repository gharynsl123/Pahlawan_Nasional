package com.example.pahlawannasional.ui.searchrepo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.data.respone.RepoRespone

class SearchRepoViewModel: ViewModel() {

    val listRepo = MutableLiveData<RepoRespone>()

}