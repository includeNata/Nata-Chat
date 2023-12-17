
const name = document.getElementById("name");
const email = document.getElementById("email");
const password = document.getElementById("password");
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

window.onload = () => {
    registerElements.forEach((el) => el.style.display = "none")
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
