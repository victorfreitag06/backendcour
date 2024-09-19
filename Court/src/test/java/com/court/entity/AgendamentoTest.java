package com.court.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AgendamentoTest {

	private Agendamento agendamento;
	private Equipamento equipamento;
	private Ambiente ambiente;
	private Usuario usuario;

	@BeforeEach
	public void setUp() {
		// Arrange
		agendamento = new Agendamento(1L, "15:00", LocalDate.of(2024, 11, 11),  usuario, ambiente, equipamento);

	}

	@Test
	public void testId() {
		// Act: Atribui o valor ao atributo 'id'
		agendamento.setId (2L) ;

		// Assert: Verifica se o valor foi corretamente atribuído
		assertEquals(2L, agendamento.getId(), "O ID deve ser igual ao valor atribuído");

	}

	@Test
	public void testData () {
	// Act:
	agendamento.setData(LocalDate.of(2024, 9, 1));

	// Assert:
	assertEquals(LocalDate.of(2024, 9,1), agendamento.getData(),
	"A data deve ser igual ao valor atribuído") ;

	}

	@Test
	public void testUsuario() {

		// Act:
		agendamento.setUsuario(usuario) ;

		// Assert:
		assertEquals(usuario, agendamento.getUsuario(), "O usuario deve ser igual ao valor atribuido");

	}
	
	
	@Test
	public void testAmbiente() {

		// Act:
		agendamento.setAmbiente(ambiente) ;

		// Assert:
		assertEquals(ambiente, agendamento.getAmbiente(), "O ambiente deve ser igual ao valor atribuido");

	}
	@Test
	public void testEquipamento() {

		// Act:
		agendamento.setEquipamento(equipamento) ;

		// Assert:
		assertEquals(equipamento, agendamento.getEquipamento(), "O equipamento deve ser igual ao valor atribuido");

	}

	
	@Test
	@DisplayName ("Testando o construtor com todos os argumentos")
	void testConstrutorAll () {
		// Act
		Agendamento novaAgendamento= new Agendamento(3L, "15:00",LocalDate.of(2024, 9, 1), usuario, ambiente,equipamento);
		// Assertion
		assertAll("novoAgendamento", 
				() -> assertEquals(3L, novaAgendamento.getId()),
				() -> assertEquals(LocalDate.of(2024, 9,1),novaAgendamento.getData()),
				() -> assertEquals("15:00", novaAgendamento.getHorario()),
				() -> assertEquals(equipamento, novaAgendamento.getEquipamento()),
				() -> assertEquals(ambiente, novaAgendamento.getAmbiente()),
				() -> assertEquals(usuario, novaAgendamento.getUsuario())
				
	);
	};

};
