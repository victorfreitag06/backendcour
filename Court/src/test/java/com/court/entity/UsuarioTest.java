package com.court.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class UsuarioTest {

	private Usuario medicamento;
	
	//Arrange
	@BeforeEach
	void setUp() {
		medicamento = new Usuario(1L, "Victor","49027741867","15996317887","Rua Aurea","65","Jardim Leonel","victorfreitag2006@gmail.com","11/11/2006","pass");
	}
	
	
	
	@Test
	@DisplayName("Tstando o getter e setter do campo Id")
	void testId() {
		//Action
		medicamento.setId(2L);
		
		//Assert
		assertEquals(2L, medicamento.getId());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Nome")
	void testNome() {
		//Action
		medicamento.setNome("Victor");
		
		//Assert
		assertEquals("Victor", medicamento.getNome());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Cpf")
	void testCpf() {
		//Action
		medicamento.setCpf("49027741867");
		
		//Assert
		assertEquals("49027741867", medicamento.getCpf());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Telefone")
	void testTelefone() {
		//Action
		medicamento.setTelefone("15996317887");
		
		//Assert
		assertEquals("15996317887", medicamento.getTelefone());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Rua")
	void testRua() {
		//Action
		medicamento.setRua("Rua Aurea");
		
		//Assert
		assertEquals("Rua Aurea", medicamento.getRua());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Numero")
	void testNumero() {
		//Action
		medicamento.setNumero("67");
		
		//Assert
		assertEquals("67", medicamento.getNumero());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Bairro")
	void testBairro() {
		//Action
		medicamento.setBairro("Jardim Leonel");
		
		//Assert
		assertEquals("Jardim Leonel", medicamento.getBairro());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Email")
	void testEmail() {
		//Action
		medicamento.setEmail("victorfreitag2006@gmail.com");
		
		//Assert
		assertEquals("victorfreitag2006@gmail.com", medicamento.getEmail());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Nascimento")
	void testNascimento() {
		//Action
		medicamento.setNascimento("11/11/2006");
		
		//Assert
		assertEquals("11/11/2006", medicamento.getNascimento());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		//act
		Usuario  novoUsuario = new Usuario(3L, "Matheus","48027741877","11996164656","Rua do Lagos","15","Jardim das Flores","matheus@gmail.com","15/02/20001","senha");
		//Assert
		assertAll("novoUsuario", 
				()-> assertEquals(3L, novoUsuario.getId()),
				()-> assertEquals("Matheus", novoUsuario.getNome()),
				()-> assertEquals("48027741877", novoUsuario.getCpf()),
				()-> assertEquals("11996164656", novoUsuario.getTelefone()),
				()-> assertEquals("Rua do Lagos", novoUsuario.getRua()),
				()-> assertEquals("15", novoUsuario.getNumero()),
				()-> assertEquals("Jardim das Flores", novoUsuario.getBairro()),
				()-> assertEquals("matheus@gmail.com", novoUsuario.getEmail()),
				()-> assertEquals("15/02/20001", novoUsuario.getNascimento())
				
				);
	};
	
		
	

};
