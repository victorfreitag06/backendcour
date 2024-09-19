package com.court.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EquipamentoTest {

private Ambiente ambiente;
	
	//Arrange
	@BeforeEach
	void setUp() {
		ambiente = new Ambiente(1L, "Victor");
	}
	
	
	
	@Test
	@DisplayName("Tstando o getter e setter do campo Id")
	void testId() {
		//Action
		ambiente.setId(2L);
		
		//Assert
		assertEquals(2L, ambiente.getId());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Nome")
	void testNome() {
		//Action
		ambiente.setNome("Victor");
		
		//Assert
		assertEquals("Victor", ambiente.getNome());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		//act
		Ambiente  novoAmbiente = new Ambiente(3L, "Matheus");
		//Assert
		assertAll("novoAmbiente", 
				()-> assertEquals(3L, novoAmbiente.getId()),
				()-> assertEquals("Matheus", novoAmbiente.getNome())
				
				);
		
	}

};
