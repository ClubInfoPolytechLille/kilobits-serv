package com.tbe.rest;

import com.tbe.database.EvenementDao;
import com.tbe.json.Evenement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementREST {

    private EvenementDao dao = Launcher.getDbi().open(EvenementDao.class);

    public EvenementREST() throws SQLException {
        if (!Launcher.tableExist("evenement")) {
            dao.createEvenementTable();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Evenement> getAllEvenements() {
		return dao.getAllEvenement();
	}

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postEvenement(Evenement evenement) {
        // System.out.println("Post Evenement\nidFonc:" + evenement.getIdFonctionnality() + "\nidMember" + evenement.getIdMember());
        int result = dao.addEvenement(evenement.getLieu(), evenement.getDat(), evenement.getDescription());

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

}
