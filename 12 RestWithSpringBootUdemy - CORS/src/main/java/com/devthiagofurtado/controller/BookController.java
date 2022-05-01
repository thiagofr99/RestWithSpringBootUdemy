package com.devthiagofurtado.controller;

import com.devthiagofurtado.data.vo.BooksVO;
import com.devthiagofurtado.data.vo.PersonVO;
import com.devthiagofurtado.service.BookService;
import com.devthiagofurtado.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "Book Endpoint", description = "Description for Book", tags = {"Book Endpoint"})
@RestController
@RequestMapping("api/book/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Busca um registro de Book por Id.")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public BooksVO buscarPorId(@PathVariable(value = "id") Long id) {
        BooksVO booksVO = bookService.findById(id);
        booksVO.add(linkTo(methodOn(BookController.class).buscarPorId(id)).withSelfRel());
        return booksVO;
    }

    @ApiOperation(value = "Busca todos registros de Book")
    @GetMapping(value = {}, produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<BooksVO> buscarTodos() {
        List<BooksVO> booksVO = bookService.findAll();
        booksVO.forEach(p->{
            p.add(linkTo(methodOn(BookController.class).buscarPorId(p.getKey())).withSelfRel());
        });
        return booksVO;
    }

    @ApiOperation(value = "Cria um registro de Book.")
    @PostMapping(value = "/salvar", produces = {"application/json", "application/xml", "application/x-yaml"}
            , consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BooksVO salvar(@RequestBody BooksVO request) {
        BooksVO booksVO =bookService.create(request);
        booksVO.add(linkTo(methodOn(BookController.class).buscarPorId(booksVO.getKey())).withSelfRel());
        return booksVO;
    }

    @ApiOperation(value = "Atualiza um registro de Book.")
    @PutMapping( value = "/atualizar", produces = {"application/json", "application/xml", "application/x-yaml"}
            , consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BooksVO atualizar(@RequestBody BooksVO request) {
        BooksVO booksVO = bookService.update(request);
        booksVO.add(linkTo(methodOn(BookController.class).buscarPorId(booksVO.getKey())).withSelfRel());
        return booksVO;
    }

    @ApiOperation(value = "Deleta um registro de Book.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

}
