function insertarFila(){
    //Se agrega la fila a la tabla
    var table = document.getElementById("boletas").insertRow(-1);

    //Se agregan las columnas
    var col1 = document.createElement("td");
    var col2 = document.createElement("td");
    var col3 = document.createElement("td");
    var col4 = document.createElement("td");

    table.appendChild(col1);
    table.appendChild(col2);
    table.appendChild(col3);
    table.appendChild(col4);

    //Se añaden las clases y configuraciones a cada columna según corresponda
    //Col 1 = nombre - boleta
    var input_t = document.createElement("input");
    input_t.setAttribute("type", "text");
    input_t.classList.add("form-control", "border", "border-0");
    input_t.placeholder("Platino");
    input_t.setAttribute("th:field", "*{Id_Tipoboleto.nombre}");
    input_t.setAttribute("required");

    col1.appendChild(input_t);

    //Col 2 = precio boleto
    var input_n1 = document.createElement("input");
    input_n1.setAttribute("type", "number");
    input_n1.classList.add("form-control", "border", "border-0");
    input_n1.placeholder("$$$");
    input_n1.setAttribute("th:field", "*{precioboleto}");
    input_n1.setAttribute("required");

    col2.appendChild(input_n1);

    //Col 3 = cantidad boletos
    var input_n2 = document.createElement("input");
    input_n2.type("number");
    input_n2.classList.add("form-control", "border", "border-0");
    input_n2.placeholder("100");
    input_n2.setAttribute("th:field", "*{cantidad_disp}");
    input_n2.setAttribute("required");

    col3.appendChild(input_n2);
}

function eliminarFila(){

}