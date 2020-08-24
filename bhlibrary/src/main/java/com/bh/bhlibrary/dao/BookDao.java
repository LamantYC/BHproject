package com.bh.bhlibrary.dao;

import com.bh.bhlibrary.entity.Book;
import com.bh.bhlibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1,String keyword2);
}
