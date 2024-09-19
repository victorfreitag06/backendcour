$(document).ready(function() {
    loadGuests();

    $('#guestForm').submit(function(event) {
        event.preventDefault();
        const id = $('#guestId').val();
        if (id) {
            updateGuest(id);
        } else {
            addGuest();
        }
    });
});

function loadGuests() {
    $.getJSON('/usuario/', function(data) {
        $('#guestTableBody').empty();
        data.forEach(guest => {
            $('#guestTableBody').append(
                `<tr>
                    <td>${guest.id}</td>
                    <td>${guest.nome}</td>
                    <td>${guest.cpf}</td>
                    <td>${guest.telefone}</td>
                    <td>${guest.rua}</td>
                    <td>${guest.numero}</td>
                    <td>${guest.bairro}</td>
                    <td>${guest.email}</td>
                    <td>${guest.nascimento}</td>
					<td>${guest.senha}</td>
                    <td>
                        <button class="btn btn-sm btn-warning" onclick="showEditGuestForm(${guest.id}, '${guest.nome}', '${guest.cpf}', '${guest.telefone}', '${guest.rua}', '${guest.numero}', '${guest.bairro}', '${guest.email}', '${guest.nascimento}','${guest.bairro}')">Editar</button>
                        <button class="btn btn-sm btn-danger" onclick="deleteGuest(${guest.id})">Delete</button>
                    </td>
                </tr>`
            );
        });
    });
}

function showAddGuestForm() {
    $('#formTitle').text('Incluir Hóspede');
    $('#guestId').val('');
    $('#guestNome').val('');
    $('#guestCpf').val('');
    $('#guestTelefone').val('');
    $('#guestRua').val('');
    $('#guestNumero').val('');
    $('#guestBairro').val('');
    $('#guestEmail').val('');
    $('#guestNascimento').val('');
	$('#guestSenha').val('');
    $('#guestFormModal').show(); 
}

function showEditGuestForm(id, nome, cpf, telefone, rua, numero, bairro, email, nascimento,senha) {
    $('#formTitle').text('Editar Hóspede');
    $('#guestId').val(id);
    $('#guestNome').val(nome);
    $('#guestCpf').val(cpf);
    $('#guestTelefone').val(telefone);
    $('#guestRua').val(rua);
    $('#guestNumero').val(numero);
    $('#guestBairro').val(bairro);
    $('#guestEmail').val(email);
    $('#guestNascimento').val(nascimento);
	$('#guestSenha').val(senha);
    $('#guestFormModal').show();
}

function closeGuestForm() {
    $('#guestFormModal').hide(); 
}

function addGuest() {
    const guest = {
        nome: $('#guestNome').val(),
        cpf: $('#guestCpf').val(),
        telefone: $('#guestTelefone').val(),
        rua: $('#guestRua').val(),
        numero: $('#guestNumero').val(),
        bairro: $('#guestBairro').val(),
        email: $('#guestEmail').val(),
        nascimento: $('#guestNascimento').val(),
		senha: $('#guestSenha').val()
    };
    $.ajax({
        url: '/usuario/',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(guest),
        success: function() {
            closeGuestForm();
            loadGuests();
        }
    });
}

function updateGuest(id) {
    const guest = {
        nome: $('#guestNome').val(),
        cpf: $('#guestCpf').val(),
        telefone: $('#guestTelefone').val(),
        rua: $('#guestRua').val(),
        numero: $('#guestNumero').val(),
        bairro: $('#guestBairro').val(),
        email: $('#guestEmail').val(),
        nascimento: $('#guestNascimento').val(),
		senha: $('#guestSenha').val()
    };
    $.ajax({
        url: `/usuario/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(guest),
        success: function() {
            closeGuestForm();
            loadGuests();
        }
    });
}

function deleteGuest(id) {
    if (confirm('Realmente vai deletar?')) {
        $.ajax({
            url: `/usuario/${id}`,
            type: 'DELETE',
            success: function() {
                loadGuests();
            }
        });
    }
}
