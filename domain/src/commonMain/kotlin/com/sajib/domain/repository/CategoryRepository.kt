package com.sajib.domain.repository

import com.sajib.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun getCategory() : Result<List<Category>>
}