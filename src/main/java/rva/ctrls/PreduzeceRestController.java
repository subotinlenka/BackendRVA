package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Preduzece;
import rva.repository.PreduzeceRepository;

@CrossOrigin
@RestController
@Api(tags = ("Preduzeće CRUD operacije"))
public class PreduzeceRestController {

	@Autowired
	private PreduzeceRepository preduzeceRepository;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("preduzece")
	@ApiOperation(value="Vraća kolekciju svih preduzeća iz baze podataka")
	public Collection<Preduzece> getPreduzeca() {
		return preduzeceRepository.findAll();
	}
	
	@GetMapping("preduzece/{id}")
	@ApiOperation(value="Vraća preduzeće na osnovu prosleđenog ID-ija")
	public Preduzece getPreduzece(@PathVariable Integer id) {
		return preduzeceRepository.getOne(id);
	}
	
	@GetMapping("preduzeceNaziv/{naziv}")
	@ApiOperation(value="Vraća kolekciju preduzeća na osnovu prosleđenog naziva preduzeća")
	public Collection<Preduzece> getPreduzeceByNaziv(@PathVariable String naziv) {
		return preduzeceRepository.findByNazivContainingIgnoreCase(naziv);
		
	}
	
	@PostMapping("preduzece")
	@ApiOperation(value="Dodaje novo preduzeće u bazu podataka")
	public ResponseEntity<Preduzece> insertPreduzece(@RequestBody Preduzece preduzece) {
		if(!preduzeceRepository.existsById(preduzece.getId())) {
			preduzeceRepository.save(preduzece);
			return new ResponseEntity<Preduzece>(HttpStatus.OK);
		}
		return new ResponseEntity<Preduzece>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("preduzece")
	@ApiOperation(value="Update-uje preduzeće iz baze podataka")
	public ResponseEntity<Preduzece> updatePreduzece(@RequestBody Preduzece preduzece) {
		if(!preduzeceRepository.existsById(preduzece.getId())) {
			return new ResponseEntity<Preduzece>(HttpStatus.CONFLICT);
		}
		preduzeceRepository.save(preduzece);
		return new ResponseEntity<Preduzece>(HttpStatus.OK);
	}
	
	/*@Transactional*/
	@DeleteMapping("preduzece/{id}")
	@ApiOperation(value="Briše preduzeće iz baze podataka (na osnovu prosleđene ID vrednosti)")
	public ResponseEntity<Preduzece> deletePreduzece(@PathVariable Integer id) {
		if(!preduzeceRepository.existsById(id)) {
			return new ResponseEntity<Preduzece>(HttpStatus.NO_CONTENT);	
		}
		jdbcTemplate.execute("DELETE FROM radnik WHERE sektor IN (SELECT id FROM sektor WHERE preduzece=" + id + ")");
		jdbcTemplate.execute("DELETE FROM sektor WHERE preduzece= " + id);
		preduzeceRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute("INSERT INTO\"preduzece\" (\"id\", \"naziv\", \"pib\", \"sediste\", \"opis\")"
					+ "VALUES (-100, 'Test preduzece', '109784532', 'Test sediste', 'Test opis')");
		}
		return new ResponseEntity<Preduzece>(HttpStatus.OK);	
	}
	
}
