package com.court.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.entity.Ambiente;
import com.court.entity.repository.AmbienteRepository;

@Service
public class AmbienteService {

private final AmbienteRepository ambienteRepository;
	
	@Autowired
	public AmbienteService(AmbienteRepository ambienteRepository) {
		this.ambienteRepository = ambienteRepository;
	}

	public List<Ambiente> getAllAmbiente() {
		return ambienteRepository.findAll();
	}

	public Ambiente getAmbienteById(Long id) {
		Optional<Ambiente> Ambiente = ambienteRepository.findById(id);
		return Ambiente.orElse(null);
	}
	//Query Method
	//public List<Ambiente> getPorData(String data){
		//return ambienteRepository.findByData(data);
	//}

	public Ambiente salvarAmbiente(Ambiente ambiente) {
		return ambienteRepository.save(ambiente);
	}

	public Ambiente updateAmbiente(Long id, Ambiente updatedAmbiente) {
		Optional<Ambiente> existingAmbiente = ambienteRepository.findById(id);
		if (existingAmbiente.isPresent()) {
			updatedAmbiente.setId(id);
			return ambienteRepository.save(updatedAmbiente);
		}
		return null;
	}

	public boolean deleteAmbiente(Long id) {
		Optional<Ambiente> existingAmbiente = ambienteRepository.findById(id);
		if (existingAmbiente.isPresent()) {
			ambienteRepository.deleteById(id);
			return true;
		}
		return false;
	}



}
