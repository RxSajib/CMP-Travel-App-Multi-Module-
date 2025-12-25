package com.sajib.data.mapper

import com.sajib.data.model.CategoryDto
import com.sajib.domain.model.Category

object CategoryMapper {
    
    fun toCategory(category : CategoryDto) : List<Category> {
      return category.data.map {item ->
          Category(
              id = item.id,
              name = item.name,
              banner = item.banner,
              icon = item.icon
          )
      }
    }
}