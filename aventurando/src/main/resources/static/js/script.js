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
})