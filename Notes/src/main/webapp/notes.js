"use strict";

let myNodeList = document.getElementsByTagName("li");

loadNotes();

for (let li of myNodeList) {
    addCloseBtn(li);
}

function addCloseBtn(listItem) {
    let span = document.createElement("span");
    let txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    listItem.appendChild(span);
    span.onclick = function() {
    this.parentElement.remove();
}}

let closeBtns = document.getElementsByClassName("close");

// for (let closeBtn of closeBtns) {
//     closeBtn.onclick = function() {
//         let div = this.parentElement;
//         div.style.display = "none";
//     };
// }

let list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
    if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
    }
}, false);

function newElement() {
    let li = document.createElement("li");
    let input = document.getElementById("myInput");
    let list = document.querySelector('ul');

    let textNode = document.createTextNode(input.value);
    li.appendChild(textNode);
    addCloseBtn(li);
    list.append(li);
}

function loadNotes() {
	let user = sessionStorage.getItem('currentUser');
	
    let response = await fetch("/Notes/webapp/notes/"+ user.email, {  
        method: 'GET',
        headers: {
        	'Content-Type': 'application/json;charset=utf-8'
        },
    });

    if (response.ok) {
        let notes = await response.json();
        
    } else {
        alert("HTTP-Error" + response.status);
    }
}

function loadElement(note) {
	let li = document.createElement("li");
    let input = document.getElementById(note.title);
    let list = document.querySelector('ul');

    let textNode = document.createTextNode(input.value);
    li.appendChild(textNode);
    addCloseBtn(li);
    list.append(li);
}