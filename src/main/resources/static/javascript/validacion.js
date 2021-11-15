/* global datos */
function scrollb() {
    window.status = "Sistema de Gestión y Control de Abastecimiento de Combustible";
}
//FUNCION PARA VALIDAR LA AUTORIZACION DEL USUSARIO
function fn_validaAutorizacion(autorizacion) {
    if (!autorizacion) {
        alert("USUARIO NO AUTORIZADO PARA ESTE TIPO DE OPERACIÓN");
        location.reload();
    }
}
//FUNCION PARA FINALIZAR LA SESSION DEL USUARIO
function fn_FinalizaSession() {
    window.location = "../login?logout";
}
//FUNCION PARA REGRESAR AL MENU PRINCIPAL
function fn_MenuPrincipal() {
    location.reload();
}
//FUNCION PARA CARGAR LAS OPCIONES DEL MENU
function fn_CargarMenu(servlet, mode) {
    $("#div_Titulo").remove();
    $("#div_GrillaPrincipal").remove();
    $("#div_VentanaPrincipal").remove();
    $("#div_VentanaDetalle").remove();
    $("#div_RegistroDetalle").remove();
    $("#div_ContextMenu").remove();
    $("#div_VentanaAseguradora").remove();
    $("#div_VentanaTipoCombustible").remove();
    $("#div_ContextMenu").remove();
    /*/
     
     $("#div_ContextMenu").remove();
     $("#div_Reporte").remove();*/
    var $contenidoAjax = $('#div_Contenido').html('<div style="text-align: center"><img src="/images/Fondos/cargando.gif" th:src="@{/images/Fondos/cargando.gif}"/></div>');
    $.ajax({
        type: "GET",
        url: "/" + servlet,
        data: {mode: mode},
        success: function (data) {
            $contenidoAjax.html(data);
        },
        error: function (e) {
            alert(e);
            console.log("ERROR: ", e);
        },
        done: function (e) {
            console.log("DONE");
            alert(e);
            enableSearchButton(true);
        }
    });
}
//FUNCION PARA VALIDAR UN CAMPO
function fn_validaCampo(campo, msg) {
    if (campo === null || campo === "" || $.trim(campo).length === 0) {
        return msg + "<br>";
    }
    return "";
}
//FUNCION PARA VALIDAR QUE SE HAYAN SELECCIONADO DATOS DEL COMBO
function fn_validaCombos(obj, msg) {
    var val = $(obj).val();
    if (val === "0" || val === "" || val === null) {
        return msg + "<br>";
    }
    return "";
}
//FUNCION PARA CARGAR UN COMBO CON AJAX
function fn_cargarComboAjax(obj, datos) {
    var source = {
        datatype: "json",
        datafields: [
            {name: 'descripcion', type: 'string'},
            {name: 'codigo', type: 'string'}
        ],
        id: 'codigo',
        url: "../CombosAjax",
        data: datos,
        async: true
    };
    var dataAdapter = new $.jqx.dataAdapter(source);
    $(obj).jqxDropDownList({source: dataAdapter, placeHolder: "Seleccione", displayMember: "descripcion", valueMember: "codigo"});
}
//FUNCION PARA CARGAR UN COMBO DE CABECERA CON AJAX
function fn_cargarComboxCabecera(obj, datos) {
    var source = {
        datatype: "json",
        datafields: [
            {name: 'descripcion', type: 'string'},
            {name: 'codigo', type: 'string'}
        ],
        id: 'codigo',
        url: "../CombosAjax",
        data: datos,
        async: true
    };
    var dataAdapter = new $.jqx.dataAdapter(source);
    $(obj).jqxComboBox({source: dataAdapter, placeHolder: "Seleccione", displayMember: "descripcion", valueMember: "codigo"});
}
//FUNCION PARA CARGAR UN TEXTO CON AJAX
function fn_cargarTextoAjax(obj, mode, codigo) {
    $.ajax({
        type: "GET",
        url: "../TextoAjax",
        data: {mode: mode, codigo: codigo},
        success: function (data) {
            $(obj).val(data);
        }
    });
}
//FUNCION PARA EXTRAER DATOS DE UN TEXTO 
function fn_extraerDatos(text, simbolo) {
    return text.substring(0, text.indexOf(simbolo));
}
//FUNCTION PARA REEMPLAZAR TODO 
function fn_reemplazarTodo(text, busca, reemplaza) {
    while (text.toString().indexOf(busca) !== - 1)
        text = text.toString().replace(busca, reemplaza);
    return text;
}
//FUNCION PARA VALIDAR SOLO NUMEROS ENTEROS
function validarSiNumero(numero) {
    if (!/^([0-9])*$/.test(numero)) {
        return "El valor " + numero + " no es un número valido.";
    }
    return "";
}
//FUNCION PARA VALIDAR SOLO NUMEROS ENTEROS
function validarBoolean(valor) {
    if (valor === '1') {
        return true;
    }
    return false;
}