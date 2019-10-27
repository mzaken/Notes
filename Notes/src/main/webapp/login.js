'use strict'

let button = document.getElementById("loginBtn");

button.onclick = validateUser;

async function validateUser() {
	let form = document.forms.loginForm;
	
	let user = {
		"email": form.elements.email.value,
		"password": form.elements.pass.value,
	};
	
    let response = await fetch("/Notes/webapp/login", {  
        method: 'POST',
        headers: {
        	'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)	
    });

    if (response.ok) {
        let userDetails = await response.json();
        sessionStorage.setItem('currentUser', user);
        window.location.replace("http://localhost:8081/Notes/notes.html");
    } else {
        alert("HTTP-Error" + response.status);
    }
}
    