package com.bh.bhlibrary.dao;

import com.bh.bhlibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
