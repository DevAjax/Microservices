package com.backend.usersapi.controllers;

import com.backend.usersapi.models.UserSet;
import com.backend.usersapi.repositories.UserSetRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/userSet")
public class UserSetController {
    @Autowired
    UserSetRepository userSetRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<String> getUsersIdentifiers() {
        List<String> res = new LinkedList<>();
        List<UserSet> set = userSetRepository.findAll();
        for (int i = 0; i < set.size(); i++) {
            res.add(set.get(i).getUserIdentifier());
        }
        return res;
    }

    @RequestMapping(value = "/{userIdentifier}", method = RequestMethod.GET)
    public UserSet getUserSet(HttpServletRequest req, @PathVariable("userIdentifier") String userIdentifier) {
        Object attributes = req.getAttribute("claims");
        if (!(attributes instanceof Claims) || (attributes == null)) {
            throw new RuntimeException("Invalid JSON Web Token");
        }
        Claims claims = (Claims) attributes;
        if (userIdentifier.equalsIgnoreCase((String) claims.get("userIdentifier"))) {
            throw new AccessDeniedException("Access denied");
        }
        return userSetRepository.findByUserIdentifier(userIdentifier);
    }

}
