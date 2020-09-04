package com.bh.bhlibrary.dao;

import com.bh.bhlibrary.entity.Book;
import com.bh.bhlibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> , JpaSpecificationExecutor<Book>{

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String title,String author);

}
