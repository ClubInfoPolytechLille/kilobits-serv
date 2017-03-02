package com.tbe.rest;

import com.tbe.database.VilleDao;
import com.tbe.json.Ville;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by badet on 02/03/2017.
 */

@RestController
@RequestMapping("/villes")
public class VilleREST {

    private VilleDao dao = Launcher.getDbi().open(VilleDao.class);

    public VilleREST() throws SQLException {
        if (!Launcher.tableExist("ville")) {
            dao.createVilleTable();
            dao.addVille("Lezennes");
            dao.addVille("Lille");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Ville> getAllVille() {
        return dao.getAllVille();
    }
}
