function loadData(){
    let request = sendRequest('citas/list', 'GET', ''); //Preguntar cual es el endpoint
    let table = document.getElementById('citas-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) =>{
            table.innerHTML += `
            <tr>
                <td>${element.idc}</td>
                <td>${element.fecha}</td>
                <td>${element.nombrePaciente}</td>
                <td>${element.nombreEspecialista}</td>
                <td>${element.detalle}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick='window.location="formCitas.html?id=${element.idc}"'>Editar</button>
                    <button type="button" class="btn btn-danger" onclick='deleteCita(${element.idc})'>Eliminar</button>
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

function saveCita(){
    let fecha = document.getElementById('cita-fh').value;
    let nombrePaciente = document.getElementById('cita-nombrePaciente').value;
    let nombreEspecialista = document.getElementById('cita-nombreEspecialista').value;
    let detalle = document.getElementById('cita-detalle').value;
    let id = document.getElementById('cita-id').value;
    let data = {'idc': id, 'fecha': fecha, 'nombrePaciente': nombrePaciente, 'nombreEspecialista': nombreEspecialista, 'detalle': detalle}
    let request = sendRequest('citas/',id ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = 'citas.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios')
    }
}

function deleteCita(idc){
    let request = sendRequest('citas/'+idc,'DELETE','')
    request.onload = function(){
        window.location = 'citas.html';
    }
}

function loadCita(idc){
    let request = sendRequest('citas/list/'+idc, 'GET', '')
    let fecha = document.getElementById('cita-fh');
    let nombrePaciente = document.getElementById('cita-nombrePaciente');
    let nombreEspecialista = document.getElementById('cita-nombreEspecialista');
    let detalle = document.getElementById('cita-detalle');
    let id = document.getElementById('cita-id');
    request.onload = function(){
        let data = request.response
        id.value = data.idc
        fecha.value = data.fecha
        nombrePaciente.value = data.nombrePaciente
        nombreEspecialista.value = data.nombreEspecialista
        detalle.value = data.detalle
    }
    request.onerror = function(){
        alert('Error al recuperar los datos');
    }
}