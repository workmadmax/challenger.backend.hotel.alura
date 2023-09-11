const form_login = document.querySelector("form");

const input_name = document.querySelector('.input-name');
const input_email = document.querySelector('.input-email');
const input_password = document.querySelector('.input-password');
const input_login = document.querySelector('.input-login');

const data = {
    name: input_name.value,
    login: input_login.value,
    email: input_email.value,
    password: input_password.value
};

function register() {
    fetch('http://localhost:8080/hotel_alura/users_system', {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            name: input_name.value,
            login: input_login.value,
            email: input_email.value,
            password: input_password.value
        })
    })
    .then(function (resp) {
        console.log(resp);
    })
    .catch(function (resp) {
        console.log(resp);
    })
};


function clearFields() {
    input_name.value = '';
    input_login.value = '';
    input_email.value = '';
    input_password.value = '';
};

form_login.addEventListener('submit', (e) => {

    e.preventDefault();

    register(e);
    clearFields();
});