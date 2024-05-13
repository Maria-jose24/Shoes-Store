// Se almacena la URL de la API para clientes
let url = "http://localhost:8081/api/v1/cliente/";

function listarClientes() {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            console.log(result);
            let cuerpoTablaClientes = document.getElementById("clientes-table").getElementsByTagName("tbody")[0];
            cuerpoTablaClientes.innerHTML = "";
            for (let i = 0; i < result.length; i++) {
                // Se crea una etiqueta tr por cada registro
                let trRegistro = document.createElement("tr");
                // Crear celdas para cada propiedad del cliente
                let celdas = [
                    result[i]["ID Clientes"],
                    result[i]["Tipo Identificación"],
                    result[i]["N° de Documento"],
                    result[i]["Nombres"],
                    result[i]["Apellidos"],
                    result[i]["Teléfono"],
                    result[i]["Dirección"],
                    result[i]["Correo Electrónico"],
                    result[i]["Ciudad"],
                    result[i]["Estado"]
                ];
                // Iterar sobre las celdas y agregarlas a la fila
                for (let j = 0; j < celdas.length; j++) {
                    let td = document.createElement("td");
                    td.textContent = celdas[j];
                    trRegistro.appendChild(td);
                }
                // Botones de acción
                let tdAcciones = document.createElement("td");
                let btnEditar = document.createElement("button");
                btnEditar.className = "btn btn-primary";
                btnEditar.textContent = "Editar";
                // Agregar evento onclick para editar
                btnEditar.onclick = function () {
                    // Aquí deberías implementar la lógica para editar el cliente
                    // Puedes acceder a los datos del cliente a través de 'result[i]'
                    console.log("Editar cliente ID: " + result[i]["ID Clientes"]);
                };
                // Agregar botón de editar a la celda de acciones
                tdAcciones.appendChild(btnEditar);
                // Agregar la celda de acciones a la fila
                trRegistro.appendChild(tdAcciones);
                // Agregar la fila a la tabla
                cuerpoTablaClientes.appendChild(trRegistro);
            }
        },
        error: function (error) {
            console.error("Error en la petición: " + error);
            alert("Error en la petición: " + error);
        }
    });
}



function registrarCliente() {
    let tipo_documento = document.getElementById("tipo_documento").value;
    let numero_documento = document.getElementById("numero_documento").value;
    let nombre = document.getElementById("nombre").value;
    let apellido = document.getElementById("apellido").value;
    let telefono = document.getElementById("telefono").value;
    let direccion = document.getElementById("direccion").value;
    let correo_electronico = document.getElementById("correo_electronico").value;
    let ciudad = document.getElementById("ciudad").value;
    let estado = document.getElementById("estado").value;

    let formData = {
        "tipo_documento": tipo_documento,
        "numero_documento": numero_documento,
        "nombre": nombre,
        "apellido": apellido,
        "telefono": telefono,
        "direccion": direccion,
        "correo_electronico": correo_electronico,
        "ciudad": ciudad,
        "estado": estado
    };

    var jsonData = JSON.stringify(formData);

    if (validarCampos()) {
        $.ajax({
            url: url,
            type: "POST",
            data: jsonData,
            contentType: 'application/json',
            success: function (reslt) {
                Swal.fire({
                    title: "¡Excelente!",
                    text: "Su registro se guardó correctamente.",
                    icon: "success"
                });
            },
            error: function (xhr, status, error) {
                Swal.fire({
                    title: "Error",
                    text: xhr.responseText,
                    icon: "error"
                });
            }
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Complete los campos correctamente",
            icon: "error"
        });
    }
}
function validarCampos() {
    let numero_documento = document.getElementById("numero_documento");
    let nombre = document.getElementById("nombre");
    let apellido = document.getElementById("apellido");
    let telefono = document.getElementById("telefono");

    return validarNumeroDocumento(numero_documento) && validarNombre(nombre)
        && validarApellido(apellido) && validarTelefono(telefono);
}

function validarNumeroDocumento(cuadroNumero) {
    let valor = cuadroNumero.value;
    let valido = true;
    if (valor.length < 5 || valor.length > 11) {
        valido = false;
    }

    if (valido) {
        cuadroNumero.classList.add("is-valid");
        cuadroNumero.classList.remove("is-invalid");
    } else {
        cuadroNumero.classList.add("is-invalid");
        cuadroNumero.classList.remove("is-valid");
    }
    return valido;
}

function validarNombre(campo) {
    let valido = true;
    if (campo.value.length < 3 || campo.value.length > 30) {
        valido = false;
    }

    if (valido) {
        campo.classList.add("is-valid");
        campo.classList.remove("is-invalid");
    } else {
        campo.classList.add("is-invalid");
        campo.classList.remove("is-valid");
    }
    return valido;
}

function validarApellido(campo) {
    let valido = true;
    if (campo.value.length < 3 || campo.value.length > 30) {
        valido = false;
    }

    if (valido) {
        campo.classList.add("is-valid");
        campo.classList.remove("is-invalid");
    } else {
        campo.classList.add("is-invalid");
        campo.classList.remove("is-valid");
    }
    return valido;
}

function validarTelefono(Numero) {
    let valor = Numero.value;
    let valido = true;
    if (valor.length !== 10) {
        valido = false;
    }

    if (valido) {
        Numero.classList.add("is-valid");
        Numero.classList.remove("is-invalid");
    } else {
        Numero.classList.add("is-invalid");
        Numero.classList.remove("is-valid");
    }
    return valido;
}
// Función para agregar una nueva fila de cliente
function agregarNuevoCliente() {
    const tableBody = document.querySelector('#clientes-table tbody');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td>2</td>
        <td>DNI</td>
        <td>87654321</td>
        <td>Jane</td>
        <td>Doe</td>
        <td>0987654321</td>
        <td>456 Elm St</td>
        <td>jane@gmail.com</td>
        <td>City</td>
        <td>Activo</td>
        <td>
            <div class="icon-container">
                <div class="icon edit-icon"><i class="fas fa-edit" style="color: blue;"></i></div>
                <div class="icon delete-icon"><i class="fas fa-trash-alt" style="color: red;"></i></div>
                <div class="icon disable-icon"><i class="fas fa-toggle-on" style="color: blue;"></i></div>
            </div>
        </td>
    `;

    // Agregar evento a botón de edición
    newRow.querySelector('.edit-icon').addEventListener('click', function () {
        // Acciones cuando se hace clic en el botón de edición
        console.log('Editar cliente');
    });

    // Agregar evento a botón de eliminación
    newRow.querySelector('.delete-icon').addEventListener('click', function () {
        // Acciones cuando se hace clic en el botón de eliminación
        console.log('Eliminar cliente');
    });

    // Agregar evento a botón de deshabilitación
    newRow.querySelector('.disable-icon').addEventListener('click', function () {
        // Acciones cuando se hace clic en el botón de deshabilitación
        console.log('Deshabilitar cliente');
    });

    tableBody.appendChild(newRow);
}

// Llamamos a la función para agregar el nuevo cliente
agregarNuevoCliente();
