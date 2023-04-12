package com.librarian.book.controller.impl;
import com.librarian.book.controller.CreateBookController;
import com.librarian.book.entity.CreateBook;
import com.librarian.book.repository.CreateBookRepository;
import com.librarian.book.resources.book.create.CreateBookGetResources;
import com.librarian.book.resources.book.create.CreateBookPostResources;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class CreateBookControllerImpl implements CreateBookController {
    private final CreateBookRepository createBookRepository;
    @Override
    public ResponseEntity<CreateBookGetResources> createBook(CreateBookPostResources createBookPostResources) {
        CreateBook createBook=new CreateBook();
        createBook.setBookName(createBookPostResources.getBookName());
        createBook.setWriterName(createBookPostResources.getWriterName());
        createBookRepository.save(createBook);

        CreateBookGetResources createBookGetResources=new CreateBookGetResources();
        createBookGetResources.setId(createBook.getId().toHexString());
        createBookGetResources.setBookName(createBook.getBookName());
        createBookGetResources.setWriterName(createBook.getWriterName());

        return ResponseEntity.ok(createBookGetResources);
    }

    @Override
    public ResponseEntity<List<CreateBookGetResources>> getAll() {


        List<CreateBook> createBooks = createBookRepository.findAll();
        List<CreateBookGetResources> response = new ArrayList<>();

        createBooks.forEach(createBook ->  {
            CreateBookGetResources resources=new CreateBookGetResources();
            resources.setId(createBook .getId().toHexString());
            resources.setBookName(createBook.getBookName());
            resources.setWriterName(createBook.getWriterName());
            response.add( resources);

        });
        return ResponseEntity.ok(response);
    }
}
