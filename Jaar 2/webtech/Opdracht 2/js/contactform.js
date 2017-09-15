function checkIfInputIsCorrect() {
    var inputName = document.getElementById("name");
    if (inputName.value == "") {
        inputName.style.backgroundColor = "#ff9180";
    }
    else{
        inputName.style.backgroundColor = "#009900";
    }

    var inputEmail = document.getElementById("email");
    if (inputEmail.value == "") {
        inputEmail.style.backgroundColor = "#ff9180";
    }
    else{
        inputEmail.style.backgroundColor = "#009900";
    }

    var inputMessage = document.getElementById("message");
    if (inputMessage.value == "") {
        inputMessage.style.backgroundColor = "#ff9180";
    }
    else{
        inputMessage.style.backgroundColor = "#009900";
    }
}