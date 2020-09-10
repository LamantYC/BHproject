package com.bh.bhlibrary.dao;

import com.bh.bhlibrary.entity.Book;
import com.bh.bhlibrary.entity.Category;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> , JpaSpecificationExecutor<Book>{

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String title,String author);

=======
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1,String keyword2);
>>>>>>> 664981a4b64553148f6a25410a355a869fe49197
}
