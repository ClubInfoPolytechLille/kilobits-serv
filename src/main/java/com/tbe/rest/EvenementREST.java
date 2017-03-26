package com.tbe.rest;

import com.tbe.database.EvenementDao;
import com.tbe.json.Evenement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Evenement getEvenement(@PathVariable(value = "id") int id){
        return dao.getEvenement(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postEvenement(Evenement evenement) {
        // System.out.println("Post Evenement\nidFonc:" + evenement.getIdFonctionnality() + "\nidMember" + evenement.getIdMember());
        int result = dao.addEvenement(evenement.getLieu(), evenement.getDat(), evenement.getDescription());

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteEvent(int id){
        int result = dao.deleteEvenement(id);
        if (result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

}
