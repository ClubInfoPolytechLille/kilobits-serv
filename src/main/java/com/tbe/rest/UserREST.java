package com.tbe.rest;

import com.tbe.database.UserDao;
import com.tbe.json.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserREST {

    private UserDao dao = Launcher.getDbi().open(UserDao.class);

    public UserREST() throws SQLException{
        if (!Launcher.tableExist("utilisateur")) {
            dao.createUserTable();
            dao.addUser(new User("badetitou", "Verhaeghe", "Benoit", "unicorn", "lezennes"
            , true, true, "Team Leader", true));
        }

    }

    //CARE THIS IS FOR TESTING
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser(){
        return dao.getAllUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(User user) {
        System.out.println("Post User");
        String result = dao.addUser(user);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public User connectUser(User user){
        System.out.println("Connect user");
        return dao.connectUser(user);
    }

}
