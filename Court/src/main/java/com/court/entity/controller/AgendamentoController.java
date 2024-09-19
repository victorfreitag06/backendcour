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

import com.court.entity.Agendamento;
import com.court.entity.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {


	private final AgendamentoService agendamentoService;
	@Autowired
	public AgendamentoController(AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agendamento> getAgendamentoById(@PathVariable Long id) {
		Agendamento agendamento = agendamentoService.getAgendamentoById(id);
		if (agendamento != null) {
			return ResponseEntity.ok(agendamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Agendamento>> getAllAgendamento() {
		List<Agendamento> agendamento = agendamentoService.getAllAgendamento();
		return ResponseEntity.ok(agendamento);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Agendamento>> getPorData(@PathVariable String data){
		//List<Agendamento> agendamento = agendamentoService.getPorData(data);
		//return ResponseEntity.ok(agendamento);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
		Agendamento criarAgendamento = agendamentoService.salvarAgendamento(agendamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAgendamento);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Agendamento> updateAgendamento(@PathVariable Long id,@RequestBody Agendamento agendamento) {
		Agendamento updatedAgendamento = agendamentoService.updateAgendamento(id, agendamento);
		if (updatedAgendamento != null) {
			return ResponseEntity.ok(updatedAgendamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAgendamento(@PathVariable Long id) {
		boolean deleted = agendamentoService.deleteAgendamento(id);
		if (deleted) {
			return ResponseEntity.ok().body("O agendamento foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}