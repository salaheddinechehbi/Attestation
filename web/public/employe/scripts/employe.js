$(document).ready(function () {
    $("#empTable").dataTable();
    
    $('#container').on('click', '.updateE', function () {
        var id = $(this).attr("v");
        var idEt = $(this).attr("idEt");
        $.ajax({
            url: "../../LoadEmploye",
            type: 'POST',
            data: {id: id},
            success: function (data) {
                $("#nom").val(data.employe.nom);
                $("#prenom").val(data.employe.prenom);
                $("#email").val(data.employe.email);
                $('#password').val(data.employe.password);
                var sd = (moment(new Date(data.id.dateDebut)).format('L')).split("/");
                var dd = sd[2] + "-" + sd[0] + "-" + sd[1];
                $('#dated').val(dd);
                if(data.dateFin != undefined){
                   var sf = (moment(new Date(data.dateFin)).format('L')).split("/");
                   var df = sf[2] + "-" + sf[0] + "-" + sf[1];
                   $("#datef").val(df);
                }else{
                   $("#datef").val(""); 
                }
                $('#datef_container').removeAttr("hidden");
                
                $("#save").html("Modifier");
                $("#operation").val("update");
                $("#operation").attr("v", id);
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });


    $('#container').on('click', '.deleteE', function () {

        var id = $(this).attr("v");
        var idEt = $(this).attr("idEt");
        swal({
            title: "Voulez-vous vraiment le supprimer?", text: "Une fois supprimer,vous pouvez pas le recuperer!",
            icon: "warning", buttons: true, dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                $.ajax({
                    url: "../../DeleteEmployeEmp",
                    type: 'POST',
                    cache: false,
                    data: {id: id,idEt:idEt},
                    success: function (data) {
                        $("#container").empty();
                        $("#container").html(remplir(data));
                    },
                    error: function (errorThrown) {
                        console.log("erreur");
                    }
                });
            }
        });

    });

    $("#save").click(function () {
        var nom = $("#nom").val();
        var prenom = $("#prenom").val();
        var email = $("#email").val();
        var password = $('#password').val();
        var fonction = $('#fonction').val();
        var etab = $('#empetab').val();
        var dated = $('#dated').val();
        var datef = $('#datef').val();
        var operation = $("#operation").val();
        var id = $("#operation").attr("v");
        $.ajax({
            url: "../../AddEmployeEmp",
            type: 'POST',
            data: {nom: nom, prenom: prenom, email: email, fonction: fonction, password: password, etab: etab, dated: dated, datef: datef, operation: operation, id: id},
            success: function (data) {
                init(); //vider les champs 
                $("#save").html("Ajouter");
                $("#operation").val("add");
                $("#operation").attr("v");
                $('#datef_container').attr("hidden",true);
                $("#container").empty();
                $("#container").html(remplir(data));
                swal("Bien Ajouté!", "", "success");
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

    function init() {
        $("#nom").val("");
        $("#prenom").val("");
        $("#email").val("");
        $('#password').val("");
        $('#dated').val("");
        $('#datef').val("");
    }

    function remplir(data) {
        var ligne = "";
        for (i = 0; i < data.length; i++) {
            var df = "---";
            var sd = (moment(new Date(data[i].id.dateDebut)).format('L')).split("/");
            var dd = sd[1] + "/" + sd[0] + "/" + sd[2];
             if(data[i].dateFin != undefined){
                var sf = (moment(new Date(data[i].dateFin)).format('L')).split("/");
                df = sf[1] + "/" + sf[0] + "/" + sf[2];
             }
            ligne += '<tr><td>' + data[i].employe.nom + '</td><td>' + data[i].employe.prenom + '</td><td>' + data[i].employe.email + '</td><td>' + data[i].employe.fonction + '</td><td>' + data[i].employe.password + '</td><td>'+data[i].etablissement.nom+'</td><td>'+dd+'</td><td>'+df+'</td><td><button class="btn btn-info updateE" idEt="' + data[i].etablissement.id + '" v="' + data[i].employe.id + '">Modifier</button></td><td><button class="btn btn-danger deleteE" idEt="' + data[i].etablissement.id + '" v="' + data[i].employe.id + '">Supprimer</button></td></tr>';
        }
        return ligne;
    }

});
