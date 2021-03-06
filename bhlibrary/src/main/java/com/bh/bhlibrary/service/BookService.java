package com.bh.bhlibrary.service;

import com.bh.bhlibrary.dao.BookDao;
import com.bh.bhlibrary.entity.Book;
import com.bh.bhlibrary.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CategoryService categoryService;

    public List<Book> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book){
        bookDao.save(book);
    }

    public void deleteById(int id){
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }

    public List<Book> search(String keywords,String keyword2) {
        return bookDao.findAllByTitleLikeOrAuthorLike(keywords,keyword2);
    }

}
