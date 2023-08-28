package com.librarian.book.service.impl;

import com.librarian.book.model.security.CurrentUserPrincipleModel;
import com.librarian.book.service.CommonService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CommonServiceImpl implements CommonService {

    private static CurrentUserPrincipleModel getContext(){
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.getPrincipal() instanceof  CurrentUserPrincipleModel){
            return(CurrentUserPrincipleModel) authentication.getPrincipal();
        }else{
            return new CurrentUserPrincipleModel();
        }
    }


    @Override
    public String getName() {
        return getContext().getName();
    }

    @Override
    public String getEmail() {
        return getContext().getEmail();
    }

    @Override
    public String getId() {
        return getContext().getUserId();
    }
}
