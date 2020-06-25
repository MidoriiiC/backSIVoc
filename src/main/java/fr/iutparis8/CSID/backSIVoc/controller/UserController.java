package fr.iutparis8.CSID.backSIVoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.dto.UserDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.UserMapper;
import fr.iutparis8.CSID.backSIVoc.model.User;
import fr.iutparis8.CSID.backSIVoc.service.UserService;


/**
 * 
 * @author midoriiiC
 * 
 * Le but de la classe UtilisateurControleur est de permettre aux modérateurs et aux admins
 * de créer un compte, de modifier un compte, et de voir la liste des utilisateurs.
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService userS) {
		this.service = userS;
	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<UserDTO> getAllUsers() {
		List<User> listU = this.service.getAllUsers();
		List<UserDTO> listDTO = UserMapper.listUserToUserDTO(listU);
		return listDTO;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createUserWithAuthority")
	public ResponseEntity<?> createAccountwithAuthority(@RequestBody UserDTO userDTo){
		User user = UserMapper.userDTOtoUser(userDTo);
		User reponse = this.service.createUserWithAuthority(user);
		if(reponse.getName()==userDTo.getName())
			return ResponseEntity.created(null).build();
		return ResponseEntity.badRequest().build();
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public UserDTO eventParId(@PathVariable int id) {
		return UserMapper.userToUserDTO(this.service.getUserById(id));
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        this.service.delete(id);
    }
	
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyUser(@PathVariable int id, @RequestBody UserDTO user){
        if(id != user.getId()) {
    		return ResponseEntity.badRequest().build();
        }
        User userModified = this.service.modify(UserMapper.userDTOtoUser(user));
        return ResponseEntity.created(null).body(UserMapper.userToUserDTO(userModified));
	}

}
