package com.sajib.data.repository

import com.sajib.data.datasources.RemoteDataSources
import com.sajib.data.mapper.CategoryMapper
import com.sajib.domain.model.Category
import com.sajib.domain.repository.CategoryRepository


class CategoryRepositoryImpl(val remoteDataSources: RemoteDataSources) : CategoryRepository {
    override suspend fun getCategory(): Result<List<Category>> {
       return try {
           val response = remoteDataSources.getCategory()
           if(response.isSuccess){
               val categoryResponse = response.getOrNull()

               if(categoryResponse != null){
                   val category = CategoryMapper.toCategory(categoryResponse)
                   Result.success(category)
               }else {
                   Result.failure(Exception("Error getting category"))
               }

           }else {
               Result.failure(Exception("Error getting category"))
           }

       }catch (e : Exception){
           Result.failure(e)
       }
    }
}