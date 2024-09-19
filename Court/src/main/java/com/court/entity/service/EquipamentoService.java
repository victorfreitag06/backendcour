package com.court.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.entity.Equipamento;
import com.court.entity.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

private final EquipamentoRepository equipamentoRepository;
	
	@Autowired
	public EquipamentoService(EquipamentoRepository equipamentoRepository) {
		this.equipamentoRepository = equipamentoRepository;
	}

	public List<Equipamento> getAllEquipamento() {
		return equipamentoRepository.findAll();
	}

	public Equipamento getEquipamentoById(Long id) {
		Optional<Equipamento> Equipamento = equipamentoRepository.findById(id);
		return Equipamento.orElse(null);
	}
	//Query Method
	//public List<Equipamento> getPorData(String data){
		//return equipamentoRepository.findByData(data);
	//}

	public Equipamento salvarEquipamento(Equipamento equipamento) {
		return equipamentoRepository.save(equipamento);
	}

	public Equipamento updateEquipamento(Long id, Equipamento updatedEquipamento) {
		Optional<Equipamento> existingEquipamento = equipamentoRepository.findById(id);
		if (existingEquipamento.isPresent()) {
			updatedEquipamento.setId(id);
			return equipamentoRepository.save(updatedEquipamento);
		}
		return null;
	}

	public boolean deleteEquipamento(Long id) {
		Optional<Equipamento> existingEquipamento = equipamentoRepository.findById(id);
		if (existingEquipamento.isPresent()) {
			equipamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

