package com.court.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.entity.Agendamento;
import com.court.entity.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

private final AgendamentoRepository agendamentoRepository;
	
	@Autowired
	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}

	public List<Agendamento> getAllAgendamento() {
		return agendamentoRepository.findAll();
	}

	public Agendamento getAgendamentoById(Long id) {
		Optional<Agendamento> Agendamento = agendamentoRepository.findById(id);
		return Agendamento.orElse(null);
	}
	//Query Method
	//public List<Agendamento> getPorData(String data){
		//return agendamentoRepository.findByData(data);
	//}

	public Agendamento salvarAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}

	public Agendamento updateAgendamento(Long id, Agendamento updatedAgendamento) {
		Optional<Agendamento> existingAgendamento = agendamentoRepository.findById(id);
		if (existingAgendamento.isPresent()) {
			updatedAgendamento.setId(id);
			return agendamentoRepository.save(updatedAgendamento);
		}
		return null;
	}

	public boolean deleteAgendamento(Long id) {
		Optional<Agendamento> existingAgendamento = agendamentoRepository.findById(id);
		if (existingAgendamento.isPresent()) {
			agendamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}


