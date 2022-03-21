package co.grandcircus.AvengersApi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class CharacterController {
	@Autowired
	private CharacterRepository ch_repo;
	
	
	@GetMapping("/reset")
	public String reset() {
		
		// Delete all
		ch_repo.deleteAll();
		
		// Add characters
		
		AvCharacter ac = new AvCharacter("Iron Man",8,true);
		ch_repo.insert(ac);
		
		ac = new AvCharacter("Thor",9,true);
		ch_repo.insert(ac);
		
		ac = new AvCharacter("Hulk",10,true);
		ch_repo.insert(ac);
		
		ac = new AvCharacter("Black Panther",8,true);
		ch_repo.insert(ac);

		ac = new AvCharacter("Dr. Strange",7,true);
		ch_repo.insert(ac);
		
		ac = new AvCharacter("Thanos",9,false);
		ch_repo.insert(ac);
		
		return "Data reset.";

	}
	
	// C(R)UD -- Read All
	
	@GetMapping("/character")
	public List<AvCharacter> readAll() {
		return ch_repo.findAll();
	}
	
	// C(R)UD -- Read One
	
	@GetMapping("/character/{id}")
	public AvCharacter readOne(@PathVariable("id") String id) {
		return ch_repo.findById(id).orElseThrow(() -> new CharacterNotFoundException(id) );
	}
	
	// (C)RUD -- Create
	@PostMapping("/character")
	@ResponseStatus(HttpStatus.CREATED)
	public AvCharacter create(@RequestBody AvCharacter avchar) {
		ch_repo.insert(avchar);
		return avchar;
	}
	
	// CRU(D) -- Delete
	@DeleteMapping("/character/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		ch_repo.deleteById(id);
	}
	
	// CR(U)D -- Update
	@PutMapping("/character")
	public AvCharacter update(@RequestBody AvCharacter avchar) {
		return ch_repo.save(avchar);
	}
	
	@ResponseBody
	@ExceptionHandler(CharacterNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String characterNotFoundHandler(CharacterNotFoundException ex) {
		return ex.getMessage();
	}	
}
