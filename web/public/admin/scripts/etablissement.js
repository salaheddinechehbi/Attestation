

$(document).ready(function () {
    $("#etabTable").dataTable();

    $("#saveEtab").on('click', function () {
        let nom = $("#nom").val();
        let btn = $("#saveEtab").val();
        let type = $("#type").val();
        let reg = $("#region").val();
        let etab = $("#etablissement").val();
        //console.log(nom+" "+etab+" "+type+" "+reg+" "+btn);
        $.ajax({
            url: '../../AddEtablissement',
            type: 'post',
            cache:false,
            data: {nom: nom, type: type, region: reg,btn:btn,etab:etab},
            success: function (response) {
                display(response);
                if(btn=="Ajouter"){
                    swal("Bien Ajouté!", "", "success");
                }else if(btn=="Modifier"){
                    swal("Bien Modifier!", "", "success");
                }
            }
        });
    });
    
});

function updateEtab(id){
    //alert("ok");
    $.ajax({
       url:'../../FetchEtablissement',
       type:'POST',
       cache:false,
       data:{id:id},
       success:function(response){
           console.log(response);
           $("#nom").val(response.nom);
           $("#type").val(response.type);
           $("#region").val(response.region.id); 
           $("#saveEtab").val("Modifier");
           $("#etablissement").val(""+id);
       }
    });
}

function deleteEtab(id) {
    swal({
        title: "Voulez-vous vraiment le supprimer?", text: "Une fois supprimer,vous pouvez pas le recuperer!",
        icon: "warning", buttons: true, dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: "../../DeleteEtablissement",
                type: 'POST',
                data: {id: id},
                success: function (response) {
                    display(response);
                },
                error: function (errorThrown) {
                    console.log("erreur");
                }
            });
        }
    });
}

function display(response) {
    let row = "";
    row += '<table class="table mb-0" id="etabTable"><thead class="bg-light"><tr><th>Nom</th><th>Type</th><th>Région</th><th>Modifier</th><th>Supprimer</th></tr></thead><tbody id="tbody">';
    for (var i = 0; i < response.length; i++) {
        row += '<tr><td>' + response[i][0].nom + '</td>'
        row += '<td>' + response[i][0].type + '</td>'
        row += '<td>' + response[i][1].nom + '</td>'
        row += '<td><Button  class="btn btn-info updateE" id="updateE" onclick="updateEtab('+ response[i][0].id +')" v="' + response[i][0].id + '">Modifier</Button></td>'
        row += '<td><Button  class="btn btn-danger deleteE" onclick="deleteEtab(' + response[i][0].id + ')" id="deleteE" v="' + response[i][0].id + '">Supprimer</Button></td></tr>'
    }
    row += '</tbody></table>';
    $("#divtable").empty();
    $("#divtable").html(row);
    $("#etabTable").dataTable();
    init();
}

function init() {
    $("#nom").val("");
    $("#saveEtab").val("Ajouter");
}





