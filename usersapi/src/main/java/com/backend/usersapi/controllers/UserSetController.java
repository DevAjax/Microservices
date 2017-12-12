package com.backend.usersapi.controllers;

import com.backend.usersapi.UsersApiApplication;
import com.backend.usersapi.models.UserSet;
import com.backend.usersapi.repositories.UserSetRepository;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/userset")
public class UserSetController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UsersApiApplication.class);

    @Autowired
    UserSetRepository userSetRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUsersIdentifiers() {
        List<String> res = new LinkedList<>();
        List<UserSet> set = userSetRepository.findAll();
        for (int i = 0; i < set.size(); i++) {
            res.add(set.get(i).getUserIdentifier());
        }
        return new Gson().toJson(res);
    }

    @RequestMapping(value = "/userdata", method = RequestMethod.GET)
    public Map<String,String> getUserData(@RequestParam("userIdentifier") String userIdentifier){
        log.info("Invoked getUserData method with userIdentifier: "+ userIdentifier);
        return userSetRepository.findByUserIdentifier(userIdentifier).getSet();
    }


}
