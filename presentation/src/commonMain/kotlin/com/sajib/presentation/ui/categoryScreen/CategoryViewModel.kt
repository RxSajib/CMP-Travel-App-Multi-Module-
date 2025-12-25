package com.sajib.presentation.ui.categoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajib.domain.usecase.GetCategoryUseCase
import kotlinx.coroutines.launch

class CategoryViewModel constructor(val categoryUseCase: GetCategoryUseCase) : ViewModel() {

    init {
        getCategory()
    }

    fun getCategory(){
        viewModelScope.launch {
           val response = categoryUseCase.getCategory()
            if(response.isSuccess){
                val categoryData = response.getOrNull()
                if(categoryData != null){
                    println("data is $categoryData")
                }else {
                    println("data is null")
                }
            }else {
                println("failed")
            }
        }
    }
}