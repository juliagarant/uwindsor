//JavaScript :)

function checkName(){
  var name = event.target.value;

  if (name.length < 4) {
    alert("Name must be longer than Bob or Joe (4 char min)");
  }
  else if (name.length >= 4) {
    for (var i = 0, l = name.length; i < l ; i++) {
      n = name.charCodeAt(i);
      if (!(n > 64 && n < 91) && !(n > 96 && n < 123)){ //(A-Z) (a-z)
        alert("There are no numbers in names!");
        break;
      }
    }
  }

}

function checkPhone(){
  var phone = event.target.value;
  var reggie = /^([\d][\d][\d]-[\d][\d][\d]-[\d][\d][\d][\d])$/
  if (!reggie.test(phone)) {
    alert("Invalid phone number");
  }
}

function checkEmail(){
  var email = event.target.value;

  if (email.length < 7) {
    alert("Too short");
  }
  else if (email.length >= 7) {
    if (email.includes("@")) {
      if (".com" != email.substring(email.length-4, email.length)) {
        alert("Email must end in .com");
      }
    }
  }
}

function checkPass(){
  var pass = event.target.value;
  var low = 0, up = 0, num = 0, char = 0;
  if (pass.length < 8) {  // must have 8 char
    alert("Must be at least 8 characters");
  }
  else if (pass.length >= 8) {
    for (var i = 0, l = pass.length; i < l ; i++) {
      n = pass.charCodeAt(i);

      if (n > 96 && n < 123) { // (a-z)
        low++;
      }
      else if (n > 64 && n < 91) { // (A-Z)
        up++;
      }
      else if(n > 47 && n < 58) { // (0-9)
        num++;
      }
      else if (n > 32 && n < 65) { //(!...)
        char++;
      }
    }

    if (low<1) {
      alert("No lowercase present")
    }
    else if (up<1) {
      alert("No uppercase present")
    }
    else if (num<1) {
      alert("No number present")
    }
    else if (char<1) {
      alert("No special character present")
    }
  }
}

function confirm(){
  var pass = document.getElementById("pass").value;
  var confirm = event.target.value;

  if (pass != confirm) {
    alert("Passwords do not match")
  }
}
