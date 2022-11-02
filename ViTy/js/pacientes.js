function loadData(){
    let request = sendRequest('paciente/list', 'GET', ''); //Preguntar cual es el endpoint
    let table = document.getElementById('pacientes-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) =>{
            table.innerHTML += `
            <tr>
            <td>${element.idp}</td>
            <td>${element.documento}</td>
            <td>${element.nombrePaciente}</td>
            <td>${element.telefono}</td>
            <td>${element.correo}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick='window.location="formPacientes.html?id=${element.idp}"'>Editar</button>
                    <button type="button" class="btn btn-danger" onclick='deletePaciente(${element.idp})'>Eliminar</button>
                </td>
            </tr>
            `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6>Error al recuperar los datos</td>
            </tr>
            `;      
    }
}

function savePaciente(){
    let documento = document.getElementById('paciente-document').value;
    let nombrePaciente = document.getElementById('paciente-name').value;
    let telefono = document.getElementById('paciente-phone').value;
    let correo = document.getElementById('paciente-email').value;
    let id = document.getElementById('paciente-id').value;
    let data = {'idp': id, 'documento': documento, 'nombrePaciente': nombrePaciente, 'telefono': telefono, 'correo': correo}
    let request = sendRequest('paciente/',id ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = 'pacientes.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios')
    }
}

function deletePaciente(idp){
    let request = sendRequest('paciente/'+idp,'DELETE','')
    request.onload = function(){
        window.location = 'pacientes.html';
    }
}

function loadPaciente(idp){
    let request = sendRequest('paciente/list/'+idp, 'GET', '')
    let documento = document.getElementById('paciente-document');
    let nombrePaciente = document.getElementById('paciente-name');
    let telefono = document.getElementById('paciente-phone');
    let correo = document.getElementById('paciente-email');
    let id = document.getElementById('paciente-id');
    request.onload = function(){
        let data = request.response
        id.value = data.idp
        documento.value = data.documento
        nombrePaciente.value = data.nombrePaciente
        telefono.value = data.telefono
        correo.value = data.correo
    }
    request.onerror = function(){
        alert('Error al recuperar los datos');
    }
}