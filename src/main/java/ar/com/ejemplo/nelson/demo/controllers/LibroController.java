package ar.com.ejemplo.nelson.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ejemplo.nelson.demo.entities.LibroEntity;
import ar.com.ejemplo.nelson.demo.repository.LibroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
@Api(value="libros", description="Operations pertaining to books")
public class LibroController {

	@Autowired
	private LibroRepository libroRepository;
	
	@ApiOperation(value = "View a list of available libros",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})

	@RequestMapping(value = "/libro", method = RequestMethod.POST)
	public ResponseEntity<?> crearAlgo(@RequestBody LibroEntity usuario) {
		try{
			if(usuario.getId() != null)
				throw new Exception("No puede ser un id menor a 0"); 
			return ResponseEntity.status(HttpStatus.OK).body(libroRepository.save(usuario).getId());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ameo le erraste, los update son con PUT");
		}
	}

	@RequestMapping(value = "/libro/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> decirMacriGato(@PathVariable Long id) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(libroRepository.findById(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Macri Gato!");
		}
	}

	@RequestMapping(value = "/libro", method = RequestMethod.PUT)
	public ResponseEntity<?> upgradearAlgo(@RequestBody LibroEntity usuario) {
		try{
			libroRepository.save(usuario);
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Macri Gato!");
		}
	}

	@RequestMapping(value = "/libro", method = RequestMethod.DELETE)
	public ResponseEntity<?> borrarAlgo(@RequestBody LibroEntity usuario) {
		try{
			libroRepository.delete(usuario);
			return ResponseEntity.ok().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Macri Gato!");
		}
	}

	@RequestMapping(value = "/libro", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(libroRepository.findAll());
	}

	/**
	 * @return the libroRepository
	 */
	public LibroRepository getLibroRepository() {
		return libroRepository;
	}

	/**
	 * @param libroRepository the libroRepository to set
	 */
	public void setLibroRepository(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}
}
