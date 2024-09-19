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

import com.court.entity.Equipamento;
import com.court.entity.service.EquipamentoService;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {


	private final EquipamentoService equipamentoService;
	@Autowired
	public EquipamentoController(EquipamentoService equipamentoService) {
		this.equipamentoService = equipamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable Long id) {
		Equipamento equipamento = equipamentoService.getEquipamentoById(id);
		if (equipamento != null) {
			return ResponseEntity.ok(equipamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Equipamento>> getAllEquipamento() {
		List<Equipamento> equipamento = equipamentoService.getAllEquipamento();
		return ResponseEntity.ok(equipamento);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Equipamento>> getPorData(@PathVariable String data){
		//List<Equipamento> equipamento = equipamentoService.getPorData(data);
		//return ResponseEntity.ok(equipamento);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Equipamento> criarEquipamento(@RequestBody Equipamento equipamento) {
		Equipamento criarEquipamento = equipamentoService.salvarEquipamento(equipamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarEquipamento);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Equipamento> updateEquipamento(@PathVariable Long id,@RequestBody Equipamento equipamento) {
		Equipamento updatedEquipamento = equipamentoService.updateEquipamento(id, equipamento);
		if (updatedEquipamento != null) {
			return ResponseEntity.ok(updatedEquipamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEquipamento(@PathVariable Long id) {
		boolean deleted = equipamentoService.deleteEquipamento(id);
		if (deleted) {
			return ResponseEntity.ok().body("O equipamento foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}
