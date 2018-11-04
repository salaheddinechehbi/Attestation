
$(document).ready(function () {
   
   $("#updateA").on('click',function(){
       //console.log(""+id+" "+nom+" "+prenom+" "+email+" "+pass);
        var nom = $("#nomA").val();
        var id = $("#idA").val();
        var prenom = $("#prenomA").val();
        var email = $("#emailA").val();
        var pass = $("#passA").val();
       $.ajax({
            url:'../../UpdateProfil',
            type:'POST',
            cache:false,
            data:{nom:nom,prenom:prenom,email:email,pass:pass,id:id},
            success:function(response){
                $("#nomA").val(response.nom);
                $("#prenomA").val(response.prenom);
                $("#emailA").val(response.email);
                $("#passA").val(response.password);
                $("#userName").html(response.nom+" "+response.prenom);
                swal("Bien Modifier!", "", "success");
            }
        });
       
   });
   
    
});

