$('#registrationForm').hide();

$('#btnSignup').click(function () {
    $('#logingForm').hide();
    $('#registrationForm').show();
});

$('#btnSigninReg').click(function () {
    $('#logingForm').show();
    $('#registrationForm').hide();
});


function signIn() {
let role = $('#role').val();
let userName = $('#userNameLoginForm').val();
let userPassword = $('#userPasswordLoginForm').val();

    //
    // let myUrl;
    // switch(role) {
    //     case "USER":
    //         myUrl = "http://localhost:8080/api/v1/user/" + userName + "/" + userPassword;
    //         break;
    //     case "ADMIN":
    //         myUrl = "http://localhost:8080/api/v1/admin/" + userName + "/" + userPassword;
    // }

    if(role=="USER"){
        $('#btnSignin').click(function () {
            $.ajax({
                method: "get",
                url: "http://localhost:8080/api/v1/user/" + userName + "/" + userPassword,
                success:function (resp) {
                    if (resp.message=="Success"){
                        alert("Username and Password Matched");

                        //show Form
                    }else{
                        alert(resp.data);
                    }


                }
            });
        });
    }
    else{
        $('#btnSignin').click(function () {
            $.ajax({
                method: "get",
                url: "http://localhost:8080/api/v1/admin/" + userName + "/" + userPassword,
                success:function (resp) {
                    if (resp.message=="Success"){
                        alert("Username and Password Matched");

                        //show Form
                    }else{
                        alert(resp.data);
                    }


                }
            });
        });

    }
}

function registrationUser() {

}

