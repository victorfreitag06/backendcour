package com.court.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.court.entity.Ambiente;
import com.court.entity.service.AmbienteService;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {


	private final AmbienteService ambienteService;
	@Autowired
	public AmbienteController(AmbienteService ambienteService) {
		this.ambienteService = ambienteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ambiente> getAmbienteById(@PathVariable Long id) {
		Ambiente ambiente = ambienteService.getAmbienteById(id);
		if (ambiente != null) {
			return ResponseEntity.ok(ambiente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Ambiente>> getAllAmbiente() {
		List<Ambiente> ambiente = ambienteService.getAllAmbiente();
		return ResponseEntity.ok(ambiente);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Ambiente>> getPorData(@PathVariable String data){
		//List<Ambiente> ambiente = ambienteService.getPorData(data);
		//return ResponseEntity.ok(ambiente);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Ambiente> criarAmbiente(@RequestBody Ambiente ambiente) {
		Ambiente criarAmbiente = ambienteService.salvarAmbiente(ambiente);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAmbiente);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Ambiente> updateAmbiente(@PathVariable Long id,@RequestBody Ambiente ambiente) {
		Ambiente updatedAmbiente = ambienteService.updateAmbiente(id, ambiente);
		if (updatedAmbiente != null) {
			return ResponseEntity.ok(updatedAmbiente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAmbiente(@PathVariable Long id) {
		boolean deleted = ambienteService.deleteAmbiente(id);
		if (deleted) {
			return ResponseEntity.ok().body("O ambiente foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}
