$(function () {



	function escapeHTML(text) {
		return text.replace(/\&/g, '&amp;').replace(/\</g, '&lt;').replace(/\>/g, '&gt;');
	}

	function bytesToSize(bytes) {
		var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
		if (bytes == 0) return '0 Bytes';
		var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
		return Math.round(bytes / Math.pow(1024, i), 2) + ' ' + sizes[i];
	}
});


var baseUrl = 'http://localhost:8081/api/';

function getDocumentById(id){
	console.log(id);
	$.ajax({
		url: baseUrl + 'candidatos/'+id,
		type: 'GET',
		success: function (resp) {
			console.log(resp)
			document.getElementById("id_update").value=resp.id;
			document.getElementById("nombreYapellido").value=resp.nombreYapellido;
			document.getElementById("dni").value=resp.dni;
			document.getElementById("fechaNac").value=resp.fechaNac;
			document.getElementById("domicilio").value=resp.domicilio;
			document.getElementById("telefono").value=resp.telefono;
			document.getElementById("experiencia").value=resp.experiencia;
			document.getElementById("email").value=resp.mail;
			document.getElementById("fotoPreview").src=resp.foto;
		},
	});

}
function getCandidatos() { 
	
$.ajax({
	url: baseUrl + 'candidatos',
	type: 'GET',
	success: function (resp) {
		
		obj = JSON.stringify(resp);
		x = "";
		txt = "";
		txt += "<table border='1' class='table'>";
		txt +="<tr><td id='del_id'>id</td><td>Nombre y apelido</td><td>Dni</td><td>Funcion</td></tr>"
        for (x in resp) {
			txt += "<tr><td>" + resp[x].id+ "</td><td>" + resp[x].nombreYapellido+ "</td><td>" + resp[x].dni+ "</td><td><button onclick='delCandidato("+resp[x].id+")' class='btn btn-default'>Delete</button> <br> <button onclick='actualizarCandidato("+resp[x].id+")' class='btn btn-default'>Actualizar</button></td></tr>";
		}
		txt += "</table>"; 
		document.getElementById("table").innerHTML = txt;
		
	},
});
}

function getCandidatoByDni() { 
	var dni = document.getElementById("dni_serch").value;
	$.ajax({
		url: baseUrl + 'candidatos/dni/'+dni,
		type: 'GET',
		success: function (resp) {
			
			obj = JSON.stringify(resp);
			x = "";
			txt = "";
			txt += "<table border='1' class='table'>";
			txt +="<tr><td id='del_id'>id</td><td>Nombre y apelido</td><td>Dni</td><td>Funcion</td></tr>"
			
				txt += "<tr><td>" + resp.id+ "</td><td>" + resp.nombreYapellido+ "</td><td>" + resp.dni+ "</td><td><button onclick='delCandidato("+resp.id+")' class='btn btn-default'>Delete</button> <br> <button onclick='actualizarCandidato("+resp.id+")' class='btn btn-default'>Actualizar</button></td></tr>";
			
			txt += "</table>"; 
			document.getElementById("table").innerHTML = txt;
			
		},
	});
}
function getCandidatoByNombreYapellido() { 
	var nombre = document.getElementById("nombreYapellido_serch").value;
	$.ajax({
		url: baseUrl + 'candidatos/nombreyapellido/'+nombre,
		type: 'GET',
		success: function (resp) {
			
			obj = JSON.stringify(resp);
			x = "";
			txt = "";
			txt += "<table border='1' class='table'>";
			txt +="<tr><td id='del_id'>id</td><td>Nombre y apelido</td><td>Dni</td><td>Funcion</td></tr>"
			
				txt += "<tr><td>" + resp.id+ "</td><td>" + resp.nombreYapellido+ "</td><td>" + resp.dni+ "</td><td><button onclick='delCandidato("+resp.id+")' class='btn btn-default'>Delete</button> <br> <button onclick='actualizarCandidato("+resp.id+")' class='btn btn-default'>Actualizar</button></td></tr>";
			
			txt += "</table>"; 
			document.getElementById("table").innerHTML = txt;
			
		},
	});
}

function create(){
	document.getElementById("formCreate").style.display = 'block';
}
function putCandidato(){ 
	var data = {};
		data.id=document.getElementById("id_update").value;
		data.nombreYapellido=document.getElementById("nombreYapellido").value;
		data.dni=document.getElementById("dni").value;;
		data.fechaNac="2018-08-02";
		data.domicilio=document.getElementById("domicilio").value;
		data.telefono=document.getElementById("telefono").value;
		data.experiencia=document.getElementById("experiencia").value;
		data.mail=document.getElementById("email").value;
		
file = document.getElementById("foto").files[0]
		var reader  = new FileReader();

		reader.addEventListener("load", function () {
			data.foto= reader.result;
		


		console.log(baseUrl);
		$.ajax({
		type: 'PUT',
		data: JSON.stringify(data),
		contentType: 'application/json',
        url: baseUrl +'candidatos/'+data.id,						
        success: function(data) {
            console.log('success');
            console.log(JSON.stringify(data));
        }
		});
	document.getElementById("formUpdate").style.display = 'none';	}, false);
	  
	if (file) {
		reader.readAsDataURL(file);
	}
}
function saveCandidato(){ 
	var data = {};
		data.nombreYapellido=document.getElementById("fc_nombreYapellido").value;
		data.dni=document.getElementById("fc_dni").value;;
		data.fechaNac="2018-08-02";
		data.domicilio=document.getElementById("fc_domicilio").value;
		data.telefono=document.getElementById("fc_telefono").value;
		data.experiencia=document.getElementById("fc_experiencia").value;
		data.mail=document.getElementById("fc_email").value;
		
file = document.getElementById("fc_foto").files[0]
		var reader  = new FileReader();

		reader.addEventListener("load", function () {
			data.foto= reader.result;
		


		console.log(baseUrl);
		$.ajax({
		type: 'POST',
		data: JSON.stringify(data),
		contentType: 'application/json',
        url: baseUrl +'candidatos',						
        success: function(data) {
            console.log('success');
            console.log(JSON.stringify(data));
        }
		});
	
	document.getElementById("formCreate").style.display = 'none';	}, false);
	  
	if (file) {
		reader.readAsDataURL(file);
	}
	getCandidatos()
}

function actualizarCandidato(id){
	document.getElementById("formUpdate").style.display = 'block';
	getDocumentById(id);		
}

function delCandidato(id) { 
		console.log(id);
		console.log(baseUrl);
		var data = {};
		data.id=id;
		$.ajax({
			type: "DELETE",
			url: baseUrl + 'candidatos/'+id ,
			headers: {"id": id},
			data: JSON.stringify(data)
        });
}
function login(){
	var username = document.getElementById("username").value
	var password = document.getElementById("password").value
	$.ajax({
		url: 'http://localhost:8081/api/login/'+username,
		type: 'GET',
		success: function (resp) {
			console.log(resp)
			if(resp!=null){
				if(resp.username == username && resp.password == password){
					localStorage.setItem('username',resp.username)
					localStorage.setItem('password',resp.password)
					window.location = "./form.html"
				}
			}
			else{
				alert("el usuario no existe")
			}
			
		},
	});


}
function loginValid(){
	var username = localStorage.getItem("username")
	var password = localStorage.getItem("password")
	$.ajax({
		url: 'http://localhost:8081/api/login/'+username,
		type: 'GET',
		success: function (resp) {
			console.log(resp)
			if(resp!=null){
				if(resp.username == username && resp.password == password){
					getCandidatos()
				}
			}
			else{
				localStorage.setItem('username','')
				localStorage.setItem('password','')
				window.location="./index.html"
			}
			
		},
	});


}
