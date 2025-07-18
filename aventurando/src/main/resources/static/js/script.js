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
	

	function abrirModalCadastro(buttonElement) {
		const tipoComponente = $(buttonElement).data('componente');
		const schema = schemasDeFormulario[tipoComponente];
	    const modalElement = document.getElementById('modalDinamico');
	    const modal = new bootstrap.Modal(modalElement);
	    const modalTitle = $('#modalDinamicoLabel');
	    const modalBody = $('#modalDinamicoBody');
	    const url = `/admin/formularios/${tipoComponente}`;

	    modalTitle.text('Carregando Formulário...');
	    modalBody.html('<div class="text-center py-5"><div class="spinner-border text-primary" role="status"></div></div>');
	    modal.show();

	    $.get(url)
	        .done(function(formHtml) {
	            modalTitle.text('Cadastrar Novo(a) ' + tipoComponente.replace(/s$/, ''));
	            modalBody.html(formHtml);
	        })
	        .fail(function() {
	            modalTitle.text('Erro');
	            modalBody.html('<div class="alert alert-danger">Não foi possível carregar o formulário. Tente novamente.</div>');
	        });

	    $('#btnSalvarFormDinamico').off('click').on('click', function() {
	        const form = $('#formDinamico');
	        // ... Lógica para validar, serializar e enviar o form via AJAX ...
	        // ... E então, chamar o SweetAlert para o fluxo de "cadastrar mais um"...
	        console.log('Botão Salvar clicado para o formulário:', form.serialize());
	    });
	}
})