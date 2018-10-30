
$(document).ready(function () {
    $("#regTable").dataTable();    
});

function updateRegion(id,nom){
    $("#nom").val(nom);
    $("#saveReg").val("Modifier");
}
function addRegion(){
    var nom = $("#nom").val();
    var btn = $("#saveReg").val();
    var id = $("#region").val();
    $.ajax({
       url:'../../AddRegion',
       data:{nom:nom,id:id,btn:btn},
       type:'POST',
       success: function(response){
           display(response);
           if(btn == "Ajouter"){swal("Bien Ajouté!", "", "success");}else{swal("Bien Modifier!", "", "success");}
            init();
       }
    });
}
function deleteRegion(id) {
    swal({
        title: "Voulez-vous vraiment le supprimer?", text: "Une fois supprimer,vous pouvez pas le recuperer!",
        icon: "warning", buttons: true, dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: '../../DeleteRegion',
                type: 'post',
                dataType: 'json',
                data: {'id': id},
                success: function (response) {
                    display(response);
                }
            });
        }
    });
}

function display(response){
    let tbody = $("#ttable");
    var row = ""; 
    row += '<table class="table mb-0" id="regTable"><thead class="bg-light"><tr><th>Nom</th><th>Modifier</th><th>Supprimer</th></tr></thead><tbody>';
    for(var i=0;i<response.length;i++){
        row += '<tr>'
        row += '<td>'+response[i].nom+'</td>'+'<td><Button onclick="updateRegion('+response[i].id+',"'+response[i].nom+'")" class="btn btn-info updateR" >Modifier</Button></td>'
        row += '<td><Button onclick="deleteRegion('+response[i].id+')" class="btn btn-danger deleteR" >Supprimer</Button></td>'
        row += '</tr>'
    }
    row += '</tbody></table>';
    tbody.empty();
    tbody.html(row);
    $("#regTable").dataTable();
    init();
}

function init(){
    $("#nom").val("");
    $("#saveReg").val("Ajouter");
}
