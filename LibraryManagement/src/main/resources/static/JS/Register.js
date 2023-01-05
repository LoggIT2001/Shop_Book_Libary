/**
 * 
 */
function validateForm(){
    var valid = 1;
	var username = document.getElementById('user');
    var username_validation = document.getElementById('username_validation');
    var fullname = document.getElementById('fullname');
    var fullname_validation = document.getElementById('fullname_validation');
    var email = document.getElementById('email');
    var email_validation = document.getElementById('email_validation');
    var phone = document.getElementById('phone');
    var phone_validation = document.getElementById('phone_validation');
    var pass = document.getElementById('pass');
    var pass_validation = document.getElementById('pass_validation');
    var confirmpass = document.getElementById('confirmpass');
    var confirmpass_validation = document.getElementById('confirmpass_validation');
    if(username.value === ""){
        valid = 0;
        username_validation.innerHTML="Username can not be empty!";
        username_validation.style.display = "block";
    }else{
        username_validation.style.display = "none";
    }
    if(fullname.value === ""){
        valid = 0;
        fullname_validation.innerHTML="Fullname can not be empty!";
        fullname_validation.style.display = "block";
    }else{
        fullname_validation.style.display = "none";
    }
    if(email.value === ""){
        valid = 0;
        email_validation.innerHTML="email can not be empty!";
        email_validation.style.display = "block";
    }else{
        email_validation.style.display = "none";
    }
    if(phone.value === ""){
        valid = 0;
        phone_validation.innerHTML="phone can not be empty!";
        phone_validation.style.display = "block";
    }else{
        phone_validation.style.display = "none";
    }
    if(pass.value === ""){
        valid = 0;
        pass_validation.innerHTML="pass can not be empty!";
        pass_validation.style.display = "block";
    }else{
        pass_validation.style.display = "none";
    }
    if(confirmpass.value === ""){
        valid = 0;
        confirmpass_validation.innerHTML="confirmpass can not be empty!";
        confirmpass_validation.style.display = "block";
    }else{
        confirmpass_validation.style.display = "none";
    }
    if(!valid)
        return false;
}