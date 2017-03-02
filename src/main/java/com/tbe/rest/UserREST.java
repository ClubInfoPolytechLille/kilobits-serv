package com.tbe.rest;

import com.tbe.database.UserDao;
import com.tbe.json.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserREST {

    private UserDao dao = Launcher.getDbi().open(UserDao.class);

    public UserREST() throws SQLException{
        new VilleREST();
        if (!Launcher.tableExist("utilisateur")) {
            dao.createUserTable();
            dao.addUser(
                    new User("badetitou", "Verhaeghe", "Benoit", "unicorn", 1
            , true, true, "Hello World", true));

        }
    }

    //CARE THIS IS FOR TESTING
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser(){
        return dao.getAllUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        System.out.println("Post User");
        int result = dao.addUser(user);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public ResponseEntity<User> connectUser(@RequestBody User user){
        System.out.println("Connect user : " + user.getMdp());
        User res = dao.connectUser(user);
        if (res == null){
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dao.connectUser(user), HttpStatus.ACCEPTED);
    }
}
