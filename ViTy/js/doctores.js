function loadData(){
    let request = sendRequest('especialista/list', 'GET', ''); //Preguntar cual es el endpoint
    let table = document.getElementById('doctor-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) =>{
            table.innerHTML += `
            <tr>
                <td>${element.ide}</td>
                <td>${element.documento}</td>
                <td>${element.nombreEspecialista}</td>
                <td>${element.telefono}</td>
                <td>${element.correo}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick='window.location="formDoctores.html?id=${element.ide}"'>Editar</button>
                    <button type="button" class="btn btn-danger" onclick='deleteDoctor(${element.ide})'>Eliminar</button>
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

function saveDoctor(){
    let documento = document.getElementById('doctor-document').value;
    let nombreEspecialista = document.getElementById('doctor-name').value;
    let telefono = document.getElementById('doctor-phone').value;
    let correo = document.getElementById('doctor-email').value;
    let id = document.getElementById('doctor-id').value;
    let data = {'ide': id, 'documento': documento, 'nombreEspecialista': nombreEspecialista, 'telefono': telefono, 'correo': correo}
    let request = sendRequest('doctores/',id ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = 'doctores.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios')
    }
}

function deleteDoctor(ide){
    let request = sendRequest('especialista/'+ide,'DELETE','')
    request.onload = function(){
        window.location = 'doctores.html';
    }
}

function loadDoctor(ide){
    let request = sendRequest('especialista/list/'+ide, 'GET', '')
    let documento = document.getElementById('doctor-document');
    let nombreEspecialista = document.getElementById('doctor-name');
    let telefono = document.getElementById('doctor-phone');
    let correo = document.getElementById('doctor-email');
    let id = document.getElementById('doctor-id');
    request.onload = function(){
        let data = request.response
        id.value = data.ide
        documento.value = data.documento
        nombreEspecialista.value = data.nombreEspecialista
        telefono.value = data.telefono
        correo.value = data.correo
    }
    request.onerror = function(){
        alert('Error al recuperar los datos');
    }
}