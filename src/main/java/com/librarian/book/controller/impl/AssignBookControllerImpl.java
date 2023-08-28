package com.librarian.book.controller.impl;

import com.librarian.book.controller.AssignBookController;
import com.librarian.book.entity.AssignBook;
import com.librarian.book.repository.AssignRepository;
import com.librarian.book.resources.book.assigned.AssignBookGetResources;
import com.librarian.book.resources.book.assigned.AssignBookPostResources;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignBookControllerImpl implements AssignBookController {

    private final AssignRepository assignRepository;
    @Override
    public ResponseEntity<AssignBookGetResources> assign(AssignBookPostResources assignBookPostResources) {
        AssignBook assignBook=new AssignBook();
        assignBook.setBookName(assignBookPostResources.getBookName());
        assignBook.setWriterName(assignBookPostResources.getWriterName());
        assignRepository.save(assignBook);

        AssignBookGetResources assignBookGetResources=new AssignBookGetResources();
        assignBookGetResources.setId(assignBook.getId().toHexString());
        assignBookGetResources.setBookName(assignBook.getBookName());
//        assignBookGetResources.setWriterName(assignBook.getWriterName());
        return ResponseEntity.ok(assignBookGetResources);
    }

    @Override
    public ResponseEntity<List<AssignBookGetResources>> getAll() {
        List<AssignBook> assign = assignRepository.findAll();
        List<AssignBookGetResources> response = new ArrayList<>();

        assign.forEach(assignBook -> {
           AssignBookGetResources resources=new AssignBookGetResources();
            resources.setId(assignBook .getId().toHexString());
            resources.setBookName(assignBook.getBookName());
//            resources.setWriterName(assignBook.getWriterName());
            response.add( resources);

        });
        return ResponseEntity.ok(response);
    }
}
