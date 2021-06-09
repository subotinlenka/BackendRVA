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
import rva.jpa.Sektor;
import rva.repository.SektorRepository;

@CrossOrigin
@RestController
@Api(tags = ("Sektor CRUD operacije"))
public class SektorRestController {
	
	@Autowired
	private SektorRepository sektorRepository;	
	
	@Autowired 
	private JdbcTemplate jdbcTemplate; 
	
	@GetMapping("sektor")
	@ApiOperation(value="Vraća kolekciju svih sektora iz baze podataka")
	public Collection<Sektor> getSektori() {
		return sektorRepository.findAll();
	}
	
	@GetMapping("sektor/{id}")
	@ApiOperation(value="Vraća sektor na osnovu prosleđenog ID-ija")
	public Sektor getSektor(@PathVariable("id") Integer id) {
		return sektorRepository.getOne(id);
	}
	
	@GetMapping("sektorNaziv/{naziv}")
	@ApiOperation(value="Vraća kolekciju sektora na osnovu prosleđenog naziva sektora")
	public Collection<Sektor> getSektorByNaziv(@PathVariable String naziv) {
		return sektorRepository.findByNazivContainingIgnoreCase(naziv);
		
	}
	
	@PostMapping("sektor")
	@ApiOperation(value="Dodaje novi sektor u bazu podataka")
	public ResponseEntity<Sektor> insertSektor(@RequestBody Sektor sektor) {
		if(!sektorRepository.existsById(sektor.getId())) {
			sektorRepository.save(sektor);
			return new ResponseEntity<Sektor>(HttpStatus.OK);
		}
		return new ResponseEntity<Sektor>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("sektor")
	@ApiOperation(value="Update-uje sektor iz baze podataka")
	public ResponseEntity<Sektor> updateSektor(@RequestBody Sektor sektor) {
		if(!sektorRepository.existsById(sektor.getId())) {
			return new ResponseEntity<Sektor>(HttpStatus.CONFLICT);
		}
		sektorRepository.save(sektor);
		return new ResponseEntity<Sektor>(HttpStatus.OK);
	}
	
	/*@Transactional*/
	@DeleteMapping("sektor/{id}")
	@ApiOperation(value="Briše sektor iz baze podataka (na osnovu prosleđene ID vrednosti)")
	public ResponseEntity<Sektor> deleteSektor(@PathVariable Integer id) {
		if(!sektorRepository.existsById(id)) {
			return new ResponseEntity<Sektor>(HttpStatus.NO_CONTENT);	
		}
		jdbcTemplate.execute("DELETE FROM radnik WHERE sektor= " + id);
		sektorRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute("INSERT INTO\"sektor\" (\"id\", \"naziv\", \"oznaka\",  \"preduzece\")"
					+ "VALUES (-100, 'Test naziv', 'TESTOZN', '1')");
		}
		return new ResponseEntity<Sektor>(HttpStatus.OK);	
	}
	
	
}
