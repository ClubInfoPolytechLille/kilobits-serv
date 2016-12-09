package com.tbe.rest;

import com.tbe.database.LangueDao;
import com.tbe.json.Langue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/langues")
public class LangueREST {

    private LangueDao dao = Launcher.getDbi().open(LangueDao.class);

    public LangueREST() throws SQLException {
        if (!Launcher.tableExist("langue")) {
            dao.createLangueTable();
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Langue> getAllLangues() {
		return dao.getAllLangue();
	}

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> postLangue(Langue langue) {
        // System.out.println("Post Langue\nidFonc:" + langue.getIdFonctionnality() + "\nidMember" + langue.getIdMember());
        int result = dao.addLangue(langue.getLangue());

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

}
