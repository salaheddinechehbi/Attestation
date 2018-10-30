$(document).ready(function () {


    $('#container').on('click', '.updateR', function () {
        var id = $(this).attr("v");
        $.ajax({
            url: "../../LoadEmploye",
            type: 'GET',
            data: {id: id},
            success: function (data) {
                $("#nom").val(data.nom);
                $("#prenom").val(data.prenom);
                $("#email").val(data.email);
                $('#fonction').val(data.fonction);
                $('#password').val(data.password);
   
                $("#save").html("Modifier");
                $("#operation").val("update");
                $("#operation").attr("v", id);
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });


    $('#container').on('click', '.deleteR', function () {

        var id = $(this).attr("v");

        swal({
            title: "Voulez-vous vraiment le supprimer?", text: "Une fois supprimer,vous pouvez pas le recuperer!",
            icon: "warning", buttons: true, dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                $.ajax({
                    url: "../../DeleteEmploye",
                    type: 'GET',
                    cache: false,
                    data: {id: id},
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
        var operation = $("#operation").val();
        var id = $("#operation").attr("v");
        $.ajax({
            url: "../../AddEmploye",
            type: 'GET',
            data: {nom: nom, prenom: prenom, email: email, fonction: fonction, password: password, operation: operation, id: id},
            success: function (data) {
                init(); //vider les champs 
                $("#container").empty(); //vider le tableau
                $("#container").html(remplir(data)); // remplir le tableau
                $("#save").html("Ajouter");
                $("#operation").val("add");
                $("#operation").attr("v");
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

    function init() {
        $("#nom").val("");
        $("#prenom").val("");
        $("#fonction").val("");
        $("#email").val("");
        $('#password').val("");

    }

    function remplir(data) {
        var ligne = "";
        for (i = 0; i < data.length; i++) {
            ligne += '<tr><td>' + data[i].nom + '</td><td>' + data[i].prenom + '</td><td>' + data[i].email + '</td><td>' + data[i].fonction + '</td><td>' + data[i].password + '</td><td><button class="btn btn-danger deleteR" v="' + data[i].id + '">Supprimer</button></td><td><button class="btn btn-info updateR" v="' + data[i].id + '">Modifier</button></td></tr>';
        }
        return ligne;
    }

});
