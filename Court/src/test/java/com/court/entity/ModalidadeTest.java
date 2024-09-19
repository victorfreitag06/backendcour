package com.court.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModalidadeTest {


	private Modalidade modalidade;
	private Equipamento equipamento;
	private Ambiente ambiente;
	private Usuario usuario;

	@BeforeEach
	public void setUp () {
		// Arrange
		modalidade = new Modalidade(1L, "Victor",  equipamento, ambiente, usuario);

	}

	@Test
	public void testId() {
		// Act: Atribui o valor ao atributo 'id'
		modalidade.setId (2L) ;

		// Assert: Verifica se o valor foi corretamente atribuído
		assertEquals(2L, modalidade.getId(), "O ID deve ser igual ao valor atribuído");

	}

	@Test
	@DisplayName("Tstando o getter e setter do campo Nome")
	void testNome() {
		//Action
		modalidade.setNome("Victor");

		//Assert
		assertEquals("Victor", modalidade.getNome());
	}

	@Test
	public void testEquipamento() {

		// Act:
		modalidade.setEquipamento(equipamento) ;

		// Assert:
		assertEquals(equipamento, modalidade.getEquipamento(), "O equipamento deve ser igual ao valor atribuido");

	}
	@Test
	public void testAmbiente() {

		// Act:
		modalidade.setAmbiente(ambiente) ;

		// Assert:
		assertEquals(ambiente, modalidade.getAmbiente(), "O ambiente deve ser igual ao valor atribuido");

	}

	@Test
	public void testUsuario() {

		// Act:
		modalidade.setUsuario(usuario) ;

		// Assert:
		assertEquals(usuario, modalidade.getUsuario(), "O usuario deve ser igual ao valor atribuido");

	}
	@Test
	@DisplayName ("Testando o construtor com todos os argumentos")
	void testConstrutorAll () {
		// Act
		Modalidade novaModalidade= new Modalidade(3L, "Math", equipamento, ambiente,usuario);
		// Assertion
		assertAll("novoModalidade", 
				() -> assertEquals(3L, novaModalidade.getId()),
				() -> assertEquals("Math", novaModalidade.getNome()),
				() -> assertEquals(equipamento, novaModalidade.getEquipamento()),
				() -> assertEquals(ambiente, novaModalidade.getAmbiente()),
				() -> assertEquals(usuario, novaModalidade.getUsuario())
				
	);
	};

};