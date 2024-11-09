// File: src/main/webapp/js/script.js

document.addEventListener("DOMContentLoaded", function () {
    // Form validation for required fields
    const loginForm = document.querySelector("form[action='login']");
    const registerForm = document.querySelector("form[action='user']");

    if (loginForm) {
        loginForm.addEventListener("submit", function (event) {
            if (!validateLoginForm()) {
                event.preventDefault(); // Prevent form submission if validation fails
            }
        });
    }

    if (registerForm) {
        registerForm.addEventListener("submit", function (event) {
            if (!validateRegisterForm()) {
                event.preventDefault(); // Prevent form submission if validation fails
            }
        });
    }

    function validateLoginForm() {
        const username = document.getElementById("username").value.trim();
        const password = document.getElementById("password").value.trim();

        if (username === "" || password === "") {
            alert("Please enter both username and password.");
            return false;
        }
        return true;
    }

    function validateRegisterForm() {
        const firstName = document.getElementById("firstName").value.trim();
        const lastName = document.getElementById("lastName").value.trim();
        const phone = document.getElementById("phone").value.trim();
        const password = document.getElementById("password").value.trim();

        if (firstName === "" || lastName === "" || phone === "" || password === "") {
            alert("Please fill in all required fields.");
            return false;
        }
        return true;
    }
});
