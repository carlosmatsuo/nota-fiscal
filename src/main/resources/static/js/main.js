
// Notas ERP
function loadNotasErp() {

	this.source = null;

	this.start = function() {

		var commentTable = document.getElementById("notas_erp");

		var bodyContent = document.getElementById("eventoBody");

		this.source = new EventSource("/monitor/notas_erp");

		console.log("Check this out: 0 ");

		this.source.addEventListener("message", function(event) {

			console.log("Check this out: 00 ");

			bodyContent.innerHTML = "";
			bodyContent.innerHTML = "<tr> </tr>";

			// These events are JSON, so parsing and DOM fiddling are needed
			// var comment = JSON.parse(event.data);

			var monitorEvento = JSON.parse(event.data);
			var arrayNotas = monitorEvento.notas;
			//var arrayNotas = JSON.parse(event.data);

			console.log("Check this out: 1 " + event.data);

			for (var i = 0; i < arrayNotas.length; i++) {

				console.log("Check this out: 5 ");

				var nota = arrayNotas[i];
				//var evento = JSON.parse(event.data);

				var row = commentTable.insertRow(commentTable.length);

				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);

				cell0.className = "author-style";
				cell0.innerHTML = nota.codigo;

				cell1.className = "text";
				cell1.innerHTML = nota.emissor;

				cell2.className = "date";
				cell2.innerHTML = nota.receptor;

			}




		});

		this.source.onerror = function() {
			this.close();
		};

	};

	this.stop = function() {
		this.source.close();
	}

}



// Notas RECEBIDAS
function loadNotasRecebidas() {

	this.source = null;

	this.start = function() {

		var commentTable = document.getElementById("notas_recebidas");

		var bodyContent = document.getElementById("eventoBody2");

		this.source = new EventSource("/monitor/notas_recebidas");

		console.log("Check this out: 0 ");

		this.source.addEventListener("message", function(event) {

			console.log("Check this out: 00 ");

			bodyContent.innerHTML = "";
			bodyContent.innerHTML = "<tr> </tr>";

			// These events are JSON, so parsing and DOM fiddling are needed
			// var comment = JSON.parse(event.data);

			var monitorNotas = JSON.parse(event.data);
			var arrayNotas = monitorNotas.notas;
			//var arrayEventos = JSON.parse(event.data);

			console.log("Check this out: 1 " + event.data);

			for (var i = 0; i < arrayNotas.length; i++) {

				console.log("Check this out: 5 ");

				var nota = arrayNotas[i];

				var row = commentTable.insertRow(commentTable.length);

				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);

				cell0.className = "author-style";
				cell0.innerHTML = nota.codigo;

				cell1.className = "text";
				cell1.innerHTML = nota.emissor;

				cell2.className = "date";
				cell2.innerHTML = nota.receptor;


			}




		});

		this.source.onerror = function() {
			this.close();
		};

	};

	this.stop = function() {
		this.source.close();
	}

}




// Notas Erp
notasErp = new loadNotasErp();

// Notas Recebidas
notasRecebidas = new loadNotasRecebidas();

/*
 * Register callbacks for starting and stopping the SSE controller.
 */

// ..
window.onload = function() {

	notasErp.start();
	notasRecebidas.start();

};


window.onbeforeunload = function() {

	notasErp.stop();
	notasRecebidas.stop();

}