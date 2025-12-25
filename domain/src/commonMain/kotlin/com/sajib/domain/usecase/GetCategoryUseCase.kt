package com.sajib.domain.usecase

import com.sajib.domain.model.Category
import com.sajib.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryUseCase constructor(val categoryRepository: CategoryRepository) {

    suspend fun getCategory() : Result<List<Category>> = categoryRepository.getCategory()
}