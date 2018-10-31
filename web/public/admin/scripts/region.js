
$(document).ready(function () {
    $("#regTable").dataTable();    
});

function updateRegion(id,nom){
    $("#nom").val(nom);
    $("#saveReg").val("Modifier");
    $('#region').val(id);
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
           console.log(response);
           display(response);
           if(btn == "Ajouter"){
               swal("Bien Ajouté!", "", "success");
           }else{
               swal("Bien Modifier!", "", "success");
               $("#region").val("Ajouter");
           }
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
    var row = ""; 
    row += '<table class="table mb-0" id="regTable"><thead class="bg-light"><tr><th>Nom</th><th>Modifier</th><th>Supprimer</th></tr></thead><tbody>';
    for(var i=0;i<response.length;i++){
        row += '<tr>';
        var func = "updateRegion("+response[i].id+",'"+response[i].nom+"')";
        row += '<td>'+response[i].nom+'</td><td><Button onclick="'+func+'" class="btn btn-info updateR" >Modifier</Button></td>';
        row += '<td><Button onclick="deleteRegion('+response[i].id+')" class="btn btn-danger deleteR" >Supprimer</Button></td>';
        row += '</tr>';
    }
    row += '</tbody></table>';
    $("#divtable").empty();
    $("#divtable").html(row);
    $("#regTable").dataTable();
    init();
}

function init(){
    $("#nom").val("");
    $("#saveReg").val("Ajouter");
}
