package com.librarian.book.controller;

import com.librarian.book.resources.book.assigned.AssignBook;
import com.librarian.book.resources.book.assigned.AssignBookGetResources;
import com.librarian.book.resources.book.assigned.AssignBookPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("assignBook/")
public interface AssignBookController {
    @PostMapping("create")
   ResponseEntity<AssignBookGetResources> assign(@RequestBody AssignBookPostResources assignBookPostResources);
    @GetMapping("/get-All")
    ResponseEntity<List<AssignBookGetResources>> getAll();
}
