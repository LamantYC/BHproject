package com.bh.bhlibrary.service;

import com.bh.bhlibrary.dao.CategoryDAO;
import com.bh.bhlibrary.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    public Category get(int id){
        Category category = categoryDAO.findById(id).orElse(null);
        return category;
    }
}
