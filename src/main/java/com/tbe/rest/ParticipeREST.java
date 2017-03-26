package com.tbe.rest;

import com.tbe.database.ParticipeDao;
import com.tbe.json.Participe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/participe")
public class ParticipeREST {

    private ParticipeDao dao = Launcher.getDbi().open(ParticipeDao.class);

    public ParticipeREST() throws SQLException {
        if (!Launcher.tableExist("participe")) {
            dao.createParticipeTable();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Participe getParticipe(@PathVariable(value = "id") int id){
        return dao.getParticipe(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postParticipe(Participe participe) {
        // System.out.println("Post Evenement\nidFonc:" + evenement.getIdFonctionnality() + "\nidMember" + evenement.getIdMember());
        int result = dao.addParticipe(participe.getNombre(), participe.getEvenement(), participe.getUtilisateur());

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteEvent(int id){
        int result = dao.deleteParticipe(id);
        if (result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

}
