package com.librarian.book.controller.impl;

import com.librarian.book.controller.ApprovedBookRequestController;
import com.librarian.book.entity.ApprovedBookRequest;
import com.librarian.book.repository.ApprovedBookRequestRepository;
import com.librarian.book.resources.book.ApprovedBookRequestGetResources;
import com.librarian.book.resources.book.ApprovedBookRequestPostResources;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApprovedBookRequestControllerImpl implements ApprovedBookRequestController {
    private  final ApprovedBookRequestRepository approvedBookRequestRepository;
    @Override
    public ResponseEntity<ApprovedBookRequestGetResources> approve(ApprovedBookRequestPostResources approvedBookRequestPostResources) {
        ApprovedBookRequest approvedBookRequest=new ApprovedBookRequest();
        approvedBookRequest.setBookName(approvedBookRequestPostResources.getBookName());
        approvedBookRequest.setRequestBy(approvedBookRequestPostResources.getRequestBy());
        approvedBookRequest.setOparation(approvedBookRequestPostResources.getOparation());
        approvedBookRequestRepository.save( approvedBookRequest);

        ApprovedBookRequestGetResources approvedBookRequestGetResources=new ApprovedBookRequestGetResources();
        approvedBookRequestGetResources.setId(approvedBookRequest.getId().toHexString());
        approvedBookRequestGetResources.setBookName(approvedBookRequest.getBookName());
        approvedBookRequestGetResources.setRequestBy(approvedBookRequest.getRequestBy());
        approvedBookRequestGetResources.setOparation(approvedBookRequest.getOparation());

        return ResponseEntity.ok(approvedBookRequestGetResources);
    }
}
