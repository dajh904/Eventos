function insertarFila() {
    const table = document.getElementById('boletas');

    // Se crea una nueva fila
    const fila = table.insertRow(-1); // Insert at the end

    fila.innerHTML += `
    <td>
        <input class="form-control border border-0" type="text" placeholder="Platino" name="boleto" required>
    </td>
    <td>
        <input class="form-control border border-0" type="number" placeholder="$$$" name="precio" required>
    </td>
    <td>
        <input class="form-control border border-0" type="number" placeholder="100" name="cantidad" required>
    </td>
    <td>
        <a role="button" class="btn btn-outline-danger btn-sm d-flex align-items-center justify-content-center" onclick="eliminarFila(this)">
            <i class="bi bi-trash3"></i>
        </a>
    </td>
    `;
}

function eliminarFila(deleteButton) {
    const tableRow = deleteButton.parentElement.parentElement;

    // Remove the table row from the table
    tableRow.parentNode.removeChild(tableRow);
}

function paginaAnterior(){
    window.history.back();
}