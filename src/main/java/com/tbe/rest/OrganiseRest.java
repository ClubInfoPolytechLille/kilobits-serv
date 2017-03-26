package com.tbe.rest;

import com.tbe.database.EvenementDao;
import com.tbe.database.OrganiseDao;
import com.tbe.json.Evenement;
import com.tbe.json.Organise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/origanise")
public class OrganiseRest {

    private OrganiseDao dao = Launcher.getDbi().open(OrganiseDao.class);

    public OrganiseRest() throws SQLException {
        if (!Launcher.tableExist("organise")) {
            dao.createOrganiseTable();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{user}/{event}")
    public Organise getOrganise(@PathVariable("user") int user, @PathVariable("event") int event){
        return dao.getOrganise(user, event);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postOrganise(Organise organise) {
        int result = dao.addOrganise(organise.getEvenement(), organise.getUtilisateur());

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteOrganise(Organise organise){
        int result = dao.deleteOrganise(organise.getEvenement(), organise.getUtilisateur());
        if (result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(null);
    }
}
