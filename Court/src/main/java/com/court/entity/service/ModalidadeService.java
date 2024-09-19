package com.court.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.entity.Modalidade;
import com.court.entity.repository.ModalidadeRepository;

@Service
public class ModalidadeService {

private final ModalidadeRepository modalidadeRepository;
	
	@Autowired
	public ModalidadeService(ModalidadeRepository modalidadeRepository) {
		this.modalidadeRepository = modalidadeRepository;
	}

	public List<Modalidade> getAllModalidade() {
		return modalidadeRepository.findAll();
	}

	public Modalidade getModalidadeById(Long id) {
		Optional<Modalidade> Modalidade = modalidadeRepository.findById(id);
		return Modalidade.orElse(null);
	}
	//Query Method
	//public List<Modalidade> getPorData(String data){
		//return modalidadeRepository.findByData(data);
	//}

	public Modalidade salvarModalidade(Modalidade modalidade) {
		return modalidadeRepository.save(modalidade);
	}

	public Modalidade updateModalidade(Long id, Modalidade updatedModalidade) {
		Optional<Modalidade> existingModalidade = modalidadeRepository.findById(id);
		if (existingModalidade.isPresent()) {
			updatedModalidade.setId(id);
			return modalidadeRepository.save(updatedModalidade);
		}
		return null;
	}

	public boolean deleteModalidade(Long id) {
		Optional<Modalidade> existingModalidade = modalidadeRepository.findById(id);
		if (existingModalidade.isPresent()) {
			modalidadeRepository.deleteById(id);
			return true;
		}
		return false;
	}



}
