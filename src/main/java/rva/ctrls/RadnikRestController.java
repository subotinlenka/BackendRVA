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
import rva.jpa.Obrazovanje;
import rva.jpa.Radnik;
import rva.jpa.Sektor;
import rva.repository.ObrazovanjeRepository;
import rva.repository.RadnikRepository;
import rva.repository.SektorRepository;

@CrossOrigin
@RestController
@Api(tags = ("Radnik CRUD operacije"))
public class RadnikRestController {

	@Autowired
	private RadnikRepository radnikRepository;
	
	@Autowired
	private SektorRepository sektorRepository;	
	
	@Autowired
	private ObrazovanjeRepository obrazovanjeRepository;
	
	@Autowired 
	private JdbcTemplate jdbcTemplate; 
	
	@GetMapping("radnik")
	@ApiOperation(value="Vraća kolekciju svih radnika iz baze podataka")
	public Collection<Radnik> getRadnici() {
		return radnikRepository.findAll();
	}
	
	@GetMapping("radnik/{id}")
	@ApiOperation(value="Vraća radnika na osnovu prosleđenog ID-ija")
	public Radnik getRadnik(@PathVariable("id") Integer id) {
		return radnikRepository.getOne(id);
	}
	
	@GetMapping("radnikIme/{ime}")
	@ApiOperation(value="Vraća kolekciju radnika na osnovu prosleđenog imena radnika")
	public Collection<Radnik> getRadnikByIme(@PathVariable String ime) {
		return radnikRepository.findByImeContainingIgnoreCase(ime);
		
	}
	
	@GetMapping("radnikSektor/{id}")
	@ApiOperation(value="Vraća kolekciju radnika na osnovu prosleđenog ID-ija sektora")
	public Collection<Radnik> getRadnikBySektor(@PathVariable Integer id) {
		Sektor sektor = sektorRepository.getOne(id);
		return radnikRepository.findBySektor(sektor);
	}
	
	@GetMapping("radnikObrazovanje/{id}")
	@ApiOperation(value="Vraća kolekciju radnika na osnovu prosleđenog ID-ija obrazovanja")
	public Collection<Radnik> getRadnikByObrazovanje(@PathVariable Integer id) {
		Obrazovanje obrazovanje = obrazovanjeRepository.getOne(id);
		return radnikRepository.findByObrazovanje(obrazovanje);
		
	}
	
	@PostMapping("radnik")
	@ApiOperation(value="Dodaje novog radnika u bazu podataka")
	public ResponseEntity<Radnik> insertRadnik(@RequestBody Radnik radnik) {
		if(!radnikRepository.existsById(radnik.getId())) {
			radnikRepository.save(radnik);
			return new ResponseEntity<Radnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Radnik>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("radnik")
	@ApiOperation(value="Update-uje radnika iz baze podataka")
	public ResponseEntity<Radnik> updateRadnik(@RequestBody Radnik radnik) {
		if(!radnikRepository.existsById(radnik.getId())) {
			return new ResponseEntity<Radnik>(HttpStatus.CONFLICT);
		}
		radnikRepository.save(radnik);
		return new ResponseEntity<Radnik>(HttpStatus.OK);
	}
	
	@DeleteMapping("radnik/{id}")
	@ApiOperation(value="Briše radnika iz baze podataka (na osnovu prosleđene ID vrednosti)")
	public ResponseEntity<Radnik> deleteRadnik(@PathVariable Integer id) {
		if(!radnikRepository.existsById(id)) {
			return new ResponseEntity<Radnik>(HttpStatus.NO_CONTENT);	
		}
		
		radnikRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute("INSERT INTO\"radnik\" (\"id\", \"ime\", \"prezime\", \"broj_lk\", \"obrazovanje\", \"sektor\")"
					+ "VALUES (-100, 'Test ime', 'Test prezime', '965734120', '1', '1')");
		}
		return new ResponseEntity<Radnik>(HttpStatus.OK);	
	}

	
}
