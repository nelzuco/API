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
import ar.com.ejemplo.nelson.demo.entities.UsuarioEntity;
import ar.com.ejemplo.nelson.demo.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/")
@RestController
@Api(value="users", description="Operations pertaining to users")
public class EjemploController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@ApiOperation(value = "View a list of available users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<?> crearAlgo(@RequestBody UsuarioEntity usuario) {
		try{
			if(usuario.getId() != null)
				throw new Exception("No puede ser un id menor a 0"); 
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepo.save(usuario).getId());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ameo le erraste, los update son con PUT");
		}
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> decirMacriGato(@PathVariable Long id) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepo.findById(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Macri Gato!");
		}
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public ResponseEntity<?> upgradearAlgo(@RequestBody UsuarioEntity usuario) {
		try{
			usuarioRepo.save(usuario);

			
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Macri Gato!");
		}
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
	public ResponseEntity<?> borrarAlgo(@RequestBody UsuarioEntity usuario) {
		try{
			usuarioRepo.delete(usuario);
			return ResponseEntity.ok().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Macri Gato!");
		}
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepo.findAll());
	}

	/**
	 * @return the usuarioRepo
	 */
	public UsuarioRepository getUsuarioRepo() {
		return usuarioRepo;
	}

	/**
	 * @param usuarioRepo
	 *            the usuarioRepo to set
	 */
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

}
