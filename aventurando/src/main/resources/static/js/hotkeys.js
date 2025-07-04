$(document).ready(function() {
	
	// torna / um atalho para a barra de busca da tabela de componentes
    $(document).on('keydown', function(e) {
        if (e.key === '/' && !$(e.target).is('input, textarea')) {
			e.preventDefault();
            $('.search-input').focus();
        }
    });
});