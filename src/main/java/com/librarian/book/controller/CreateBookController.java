package com.librarian.book.controller;

import com.librarian.book.resources.book.create.CreateBookGetResources;
import com.librarian.book.resources.book.create.CreateBookPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("createBook")

public interface CreateBookController {
    @PostMapping("/createBook")
    ResponseEntity<CreateBookGetResources> createBook(@RequestBody CreateBookPostResources createBookPostResources);

    @GetMapping("/getAll")
    ResponseEntity<List<CreateBookGetResources>> getAll();
}
