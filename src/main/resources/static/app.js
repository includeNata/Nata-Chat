const formLogin = document.getElementById("formLogin");
const formRegister = document.getElementById("formRegister");
const nameInput = document.getElementById("name");
const tel = document.getElementById("tel");
const toast = document.getElementById("toast");
const toastText = document.getElementById("toast-text");
const toastIcon = document.getElementById("toast-icon");
const loginElements = document.querySelectorAll("#login");
const registerElements = document.querySelectorAll("#register");
let pages = false;
let animationClass = "";

function handleTogglePages() {
    pages = !pages;
    if (pages) {
        loginElements.forEach(el => el.style.display = "none");
        registerElements.forEach(el => el.style.display = "flex");
        return;
    }

    loginElements.forEach((el) => el.style.display = "flex");
    registerElements.forEach((el) => el.style.display = "none");
}

function submitLogin(event){
    event.preventDefault();

    if(checkEmail(email) && password.value.length > 3){
        alert("Login feito com sucesso!")
    }
    else{
        alert("Email não válido")
    }
}

function checkEmail(input) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   
    if(re.test(input.value)) {
        return true;
    }  
    
    return false;
}

formLogin.addEventListener("submit", function(event){
    toastIcon.innerHTML = "";
    event.preventDefault();
    toast.style.display = "flex";

    if(checkEmail(email[0]) && password[0].value.length > 3){
        sucess("Login feito com sucesso!");
    }
    else{
        error("Email não válido ou senha inválido!");
    };

    setTimeout(() => {
        toast.style.display = "none";
    }, 5000);
})

formRegister.addEventListener("submit", function(event){
    event.preventDefault();
    toastIcon.innerHTML = "";
    toast.style.display = "flex";

    if(checkEmail(email[1]) && password[1].value.length > 3 && nameInput.value.length > 0 && checkTel(tel)){
        sucess("Cadastro feito com sucesso!");
    }
    else{
        error("Usuário já existe!");
    };

    setTimeout(() => {
        toast.style.display = "none";
    }, 5000);
})

function handleTelt(event) {
    debugger;
    let r = event.value.replace(/\D/g, "");
    r = r.replace(/^0/, "");
    if (r.length > 10) {
        r = r.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
    } else if (r.length > 5) {
        r = r.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
    } else if (r.length > 2) {
        r = r.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
    } else {
        r = r.replace(/^(\d*)/, "($1");
    }

    tel.value = r;
};

function checkEmail(input) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   
    if(re.test(input.value)) {
        return true;
    }  
    
    return false;
}

function checkTel(input) {
    var exp = /^\d{10}$/;   
    if(!exp.test(input.value)) 
        return true;

    return false;
}

function sucess(message){
    toastText.innerHTML = message;
    toastIcon.classList.add("bg-[#07bc0c]");
    if(toastIcon.innerHTML.length === 0){
        toastIcon.innerHTML += '<i class="fa-solid fa-check text-base text-white"></i>';
    }

    toast.classList.add("after:bg-[#07bc0c]");
}

function error(message){
    toastText.innerHTML = message;
    toastIcon.classList.add("bg-[#ff0000]");
    if(toastIcon.innerHTML.length === 0){
        toastIcon.innerHTML += '<i class="fa-solid fa-xmark text-base text-white"></i>';
    }

    toast.classList.add("after:bg-[#ff0000]");
}

const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', (greeting) => {
        showGreeting(JSON.parse(greeting.body).content);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.publish({
        destination: "/app/hello",
        body: JSON.stringify({'name': $("#name").val()})
    });
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendName());
});
