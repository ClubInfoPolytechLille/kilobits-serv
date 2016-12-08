package com.tbe.rest;

import com.tbe.database.UsersRequest;
import com.tbe.json.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserREST {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(User user) {
        System.out.println("Post User");
        String result = UsersRequest.addUser(user);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public User connectUser(User user){
        System.out.println("Connect user");
        return UsersRequest.connectUser(user);
    }

}
