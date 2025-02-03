package com.mycompany.ecomerce.repository;

import com.mycompany.ecomerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
