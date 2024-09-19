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

import com.court.entity.Modalidade;
import com.court.entity.service.ModalidadeService;

@RestController
@RequestMapping("/modalidade")
public class ModalidadeController {


	private final ModalidadeService modalidadeService;
	@Autowired
	public ModalidadeController(ModalidadeService modalidadeService) {
		this.modalidadeService = modalidadeService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Modalidade> getModalidadeById(@PathVariable Long id) {
		Modalidade modalidade = modalidadeService.getModalidadeById(id);
		if (modalidade != null) {
			return ResponseEntity.ok(modalidade);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Modalidade>> getAllModalidade() {
		List<Modalidade> modalidade = modalidadeService.getAllModalidade();
		return ResponseEntity.ok(modalidade);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Modalidade>> getPorData(@PathVariable String data){
		//List<Modalidade> modalidade = modalidadeService.getPorData(data);
		//return ResponseEntity.ok(modalidade);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Modalidade> criarModalidade(@RequestBody Modalidade modalidade) {
		Modalidade criarModalidade = modalidadeService.salvarModalidade(modalidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarModalidade);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Modalidade> updateModalidade(@PathVariable Long id,@RequestBody Modalidade modalidade) {
		Modalidade updatedModalidade = modalidadeService.updateModalidade(id, modalidade);
		if (updatedModalidade != null) {
			return ResponseEntity.ok(updatedModalidade);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteModalidade(@PathVariable Long id) {
		boolean deleted = modalidadeService.deleteModalidade(id);
		if (deleted) {
			return ResponseEntity.ok().body("O modalidade foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}
