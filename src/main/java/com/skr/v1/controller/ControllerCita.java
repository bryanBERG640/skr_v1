package com.skr.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Cita;
import com.skr.v1.repository.RepositoryCita;
import com.skr.v1.repository.RepositoryCliente;
import com.skr.v1.repository.RepositoryEmpresa;
import com.skr.v1.repository.RepositoryEstatusCita;
import com.skr.v1.repository.RepositoryPostulanteB;


@RestController
@RequestMapping("/cita")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerCita {
	
	private final Logger log = LoggerFactory.getLogger(ControllerCita.class);
	
	//PK
	@Autowired
	private RepositoryCita repositoryCita;
	private Cita citA;
	
	//FK EstatusCita
	@Autowired
	private RepositoryEstatusCita repositoryEstatusCita;
	
	//FK PostulanteB
	@Autowired
	private RepositoryPostulanteB respositoryPostulanteB;
	
	@Autowired
	private RepositoryEmpresa repositoryEmpresa;
	
	@Autowired
	private RepositoryCliente repositoryCliente;
	
	@Autowired
	public ControllerCita(RepositoryCita repositoryCita) {
		this.repositoryCita = repositoryCita;
	}
	
	@RequestMapping("/get")
	public List<Cita> citaList(){
		return repositoryCita.findAll();
	}
	
	@PostMapping("/{estatusCita}/{postulanteB}/{empresa}/{cliente}/post")
	public Cita addCita(@PathVariable (value = "estatusCita") int estatusCita,
								@PathVariable (value = "postulanteB") int postulanteB,
								@PathVariable(value="empresa") int empresa,
								@PathVariable (value="cliente") int cliente,
									  @Valid @RequestBody Cita cita) {
		log.error("Request to insert cita: {}", cita);
		this.citA = cita;	
		
		repositoryEstatusCita.findById(estatusCita).map(eCit ->{
			this.citA.setEstatuscita(eCit);
			return this.citA;
		});
		
		respositoryPostulanteB.findById(postulanteB).map(pB ->{
			this.citA.setPostulanteb(pB);
			return this.citA;
		});
		
		repositoryEmpresa.findById(empresa).map(emp ->
		{
			this.citA.setEmpresa(emp);
			return this.citA;
		});
		
		repositoryCliente.findById(cliente).map(cl ->
		{
			this.citA.setCliente(cl);
			return this.citA;
		});
		
		return repositoryCita.save(cita);
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getCita(@PathVariable int id) {
        Optional<Cita> cita = repositoryCita.findById(id);
        return cita.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PutMapping("/{estatusCita}/{postulanteB}/{empresa}/{cliente}/put/{id}")
    ResponseEntity<Cita> updateCita(@PathVariable (value= "estatusCita") int estatusCita,
    									@PathVariable (value= "postulanteB") int postulanteB,
    									@PathVariable(value="empresa") int empresa,
    									@PathVariable(value ="cliente") int cliente,
    									@Valid @RequestBody Cita cita) {
		log.error("Request to update cita: {}", cita);
        this.citA = cita;
        repositoryEstatusCita.findById(estatusCita).map(cit ->{
			this.citA.setEstatuscita(cit);
			return this.citA;
		});
        respositoryPostulanteB.findById(postulanteB).map(tE ->{
			this.citA.setPostulanteb(tE);
			return this.citA;
		});
        
        repositoryEmpresa.findById(empresa).map(emp ->
		{
			this.citA.setEmpresa(emp);
			return this.citA;
		});
        
        repositoryCliente.findById(cliente).map(cl ->
		{
			this.citA.setCliente(cl);
			return this.citA;
		});
        
        Cita result = repositoryCita.save(cita);
        return ResponseEntity.ok().body(result);
    }
	
}
