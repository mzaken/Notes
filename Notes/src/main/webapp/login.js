'use strict'

let button = document.getElementById("loginBtn");

button.onclick = fetchNotesList;

async function fetchNotesList() {
	let form = document.forms.loginForm;
	
	let user = {
		"email": form.elements.email.value,
		"password": form.elements.pass.value,
	};
	
    let response = await fetch("/Notes/login", {  
        method: 'POST',
        headers: {
        	'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)	
    });

    if (response.ok) {
        let userDetails = await response.json();
        alert(userDetails);
    } else {
        alert("HTTP-Error" + response.status);
    }
}
    