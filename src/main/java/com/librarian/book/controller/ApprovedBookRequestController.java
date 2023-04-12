package com.librarian.book.controller;

import com.librarian.book.resources.book.ApprovedBookRequestGetResources;
import com.librarian.book.resources.book.ApprovedBookRequestPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("approveBookRequest")
public interface ApprovedBookRequestController {
    @PostMapping("/create")
    ResponseEntity<ApprovedBookRequestGetResources> approve(@RequestBody ApprovedBookRequestPostResources approvedBookRequestPostResources);


}
