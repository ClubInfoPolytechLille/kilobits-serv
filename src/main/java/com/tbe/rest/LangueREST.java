package com.tbe.rest;

import com.tbe.database.LangueRequest;
import com.tbe.json.Langue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/langues")
public class LangueREST {

    @RequestMapping(method = RequestMethod.GET)
    public Langue[] getAllLangues() {
		System.out.println("GET ALL langue");
		List<Langue> langues = LangueRequest.getAllLangue();
		Langue[] p = new Langue[langues.size()];
		for (int i = 0; i < p.length; ++i) {
			p[i] = langues.get(i);
		}
		return p;
	}

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> postLangue(Langue langue) {
        // System.out.println("Post Langue\nidFonc:" + langue.getIdFonctionnality() + "\nidMember" + langue.getIdMember());
        int result = LangueRequest.addLangue(langue.getLangue());

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(null);
    }

}
