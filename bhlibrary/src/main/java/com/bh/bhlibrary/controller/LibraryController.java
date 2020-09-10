package com.bh.bhlibrary.controller;

<<<<<<< HEAD
import com.bh.bhlibrary.dao.BookDao;
import com.bh.bhlibrary.entity.Book;
import com.bh.bhlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class LibraryController extends HttpServlet {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;
=======
import com.bh.bhlibrary.entity.Book;
import com.bh.bhlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private BookService bookService;
>>>>>>> 664981a4b64553148f6a25410a355a869fe49197

    @GetMapping("/api/books")
    public List<Book> list() {
        return bookService.list();
    }
<<<<<<< HEAD
        //图书添加模块
=======

>>>>>>> 664981a4b64553148f6a25410a355a869fe49197
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return book;
    }
<<<<<<< HEAD
    //图书删除模块
=======

>>>>>>> 664981a4b64553148f6a25410a355a869fe49197
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) {
        if (cid != 0) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }


<<<<<<< HEAD
    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords){
        //关键字为空时查询所有
        if ("".equals(keywords)) {
            return bookService.list();
        }else {
            return bookService.search('%'+keywords+'%','%'+keywords+'%');
        }
    }

//    @RequestParam(value = "keywords", required = false) String keywords,
//    @RequestParam(value = "cid", required = false) Integer ci
    @GetMapping("/api/book")
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                   @RequestParam(value = "pagesize", required = false, defaultValue = "8") Integer pagesize,
                                   @RequestParam(value = "cid", required = false) Integer cid,
                                   @RequestParam(value = "keywords", required = false) String keywords
                                    ){
        //return bookService.list();
        PageRequest pageRequest=PageRequest.of(currentPage-1,pagesize);
        Page<Book> pagination=bookDao.findAll(pageRequest);
        Map<String,Object> map=new HashMap<>();
        map.put("pagination",pagination);
        map.put("currentPage",currentPage);
        map.put("pagesize",pagesize);
        return map;
    }
=======
>>>>>>> 664981a4b64553148f6a25410a355a869fe49197
}
