$(document).ready(function () {
	const params = new URLSearchParams(window.location.search);
	const codigo = params.get("codigo");

	if (codigo !== null && !isNaN(parseInt(codigo))) {
		exibirMensagem(parseInt(codigo));
	}
});

function exibirMensagem(codigo) {
	const mensagem = CodigosErro[codigo] || "Erro desconhecido.";

	const tipo = {
		sucesso: [7, 12, 15],
		info: [88],
		alerta: [999, 6, 8, 11, 14, 23, 28, 25, 29, 32],
		erro: [17],
	};

	let titulo = "Aviso";
	let icone = "warning";

	if (tipo.sucesso.includes(codigo)) {
		titulo = "Sucesso!";
		icone = "success";
	} else if (tipo.info.includes(codigo)) {
		titulo = "Informação";
		icone = "info";
	} else if (tipo.erro.includes(codigo)) {
		titulo = "Erro";
		icone = "error";
	}

	Swal.fire({
		title: titulo,
		text: mensagem,
		icon: icone,
		background: 'rgba(13, 17, 23, 0.4)',
		color: '#e5e7eb',
		confirmButtonColor: '#1e40af',
		customClass: {
			popup: 'swal-glass'
		}
	});
	limparUrl();
}

function limparUrl() {
	if (window.history.replaceState) {
		const novaUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
		window.history.replaceState({}, document.title, novaUrl);
	}
}

// Isso será executado ao carregar o JS
(function adicionarEstiloGlassAlert() {
	const style = document.createElement('style');
	style.innerHTML = `
		.swal-glass {
			background: rgba(13, 17, 23, 0.4) !important;
			backdrop-filter: blur(10px) !important;
			-webkit-backdrop-filter: blur(10px) !important;
			border: 1px solid rgba(212, 175, 55, 0.2) !important;
			box-shadow: 0 8px 32px rgba(0, 0, 0, 0.37) !important;
			border-radius: 10px !important;
		}
		.swal2-title {
			color: #d4af37 !important;
		}
		.swal2-confirm {
			background-color: #1e40af !important;
			color: #ffffff !important;
			border: none !important;
			border-radius: 5px !important;
			padding: 10px 24px !important;
		}
		.swal2-confirm:hover {
			background-color: #1e3a8a !important;
		}
	`;
	document.head.appendChild(style);
})();