$(document).ready(function () {
	let $inputSenha = $('#senha')
	let $inputConfSenha = $('#conf_senha')
	let $inputValido = $('#senhaValida')
	
	function verificarSenha(){
		const senha = $inputSenha.val()
		const confirmacao = $inputConfSenha.val()
		
		if(senha.length === 0 || confirmacao.length === 0){
			$inputSenha.removeClass('input-valid input-invalid')
			$inputConfSenha.removeClass('input-valid input-invalid')
			$inputValido.val('')
			return false
		}
		
		if(senha !== confirmacao){
			$inputSenha.addClass('input-invalid').removeClass('input-valid')
			$inputConfSenha.addClass('input-invalid').removeClass('input-valid')
			$inputValido.val('')
			return false
		}else{
			$inputSenha.addClass('input-valid').removeClass('input-invalid')
			$inputConfSenha.addClass('input-valid').removeClass('input-invalid')
			$inputValido.val(senha)
			return true
		}
	}
	$inputSenha.on('input', verificarSenha)
	$inputConfSenha.on('input', verificarSenha)
	
	$('#fab-main').click(function () {
        $('.fab-options').toggleClass('active');
        $(this).find('i').toggleClass('fa-plus fa-times');
    });
})

function abrirModalCadastro(buttonElement) {
    const tipoComponente = $(buttonElement).data('componente');
    const modalElement = document.getElementById('modalDinamico');
    // Usamos 'new' apenas uma vez. Para reabrir, usamos getInstance.
    const modal = bootstrap.Modal.getOrCreateInstance(modalElement);
    const modalTitle = $('#modalDinamicoLabel');
    const modalBody = $('#modalDinamicoBody');
    const url = `/admin/formularios/${tipoComponente}`;

    modalTitle.text('Carregando Formulário...');
    modalBody.html('<div class="text-center py-5"><div class="spinner-border text-primary" role="status"></div></div>');
    modal.show();

    // Carregar o formulário do backend
    $.get(url)
        .done(function(formHtml) {
            modalTitle.text('Cadastrar Novo(a) ' + tipoComponente.replace(/s$/, ''));
            modalBody.html(formHtml);
        })
        .fail(function() {
            modalTitle.text('Erro');
            modalBody.html('<div class="alert alert-danger">Não foi possível carregar o formulário. Tente novamente.</div>');
        });

    // Lógica do Botão Salvar - ESSA É A PARTE NOVA E IMPORTANTE
    $('#btnSalvarFormDinamico').off('click').on('click', function() {
        const form = $('#formDinamico');
        const actionUrl = form.attr('action'); // Pega a URL do th:action
        const formData = form.serialize(); // Pega todos os dados dos inputs

        $.ajax({
            type: "POST",
            url: actionUrl,
            data: formData,
            dataType: "json", // Esperamos uma resposta JSON do controller
            
            // Se a requisição der certo...
            done: function(response) {
                modal.hide();
                Swal.fire({
                    title: 'Sucesso!',
                    text: response.message, // Mensagem vinda do ResponseEntity
                    icon: 'success',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#aaa',
                    confirmButtonText: 'Cadastrar outro',
                    cancelButtonText: 'Fechar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Se o usuário clicar em "Cadastrar outro", abre a modal de novo
                        abrirModalCadastro(buttonElement);
                    } else {
                        // Se clicar em "Fechar", recarrega a página para atualizar a tabela
                        location.reload(); 
                    }
                });
            },

            // Se a requisição falhar...
            fail: function(error) {
                const errorMsg = error.responseJSON ? error.responseJSON.error : 'Ocorreu um erro desconhecido.';
                Swal.fire(
                    'Oops...',
                    'Não foi possível salvar: ' + errorMsg,
                    'error'
                );
            }
        });
    });
}