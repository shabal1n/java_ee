const name = document.getElementById("form3Name");
const email = document.getElementById("form3Email");
const phone = document.getElementById("form4Phone");
const password1 = document.getElementById("form3Password");
const password2 = document.getElementById("form3Password2");

function validation() {
    name_valid();
    email_valid();
    phone_valid();
    passwords_valid();
}

function name_valid() {
    if (name.value === "") {
        name.classList.remove("is-valid");
        name.classList.add("is-invalid");
        return false;
    } else {
        name.classList.remove("is-invalid");
        name.classList.add("is-valid");
        return true;
    }
}

function email_valid() {
    if (email.value === "") {
        email.classList.remove("is-valid");
        email.classList.add("is-invalid");
        return false;
    } else {
        email.classList.remove("is-invalid");
        email.classList.add("is-valid");
        return true;
    }
}

function phone_valid() {
    if (phone.value === "") {
        phone.classList.remove("is-valid");
        phone.classList.add("is-invalid");
        return false;
    } else {
        phone.classList.remove("is-invalid");
        phone.classList.add("is-valid");
        return true;
    }
}

function passwords_valid() {
    if(password1.value !== "" && password2.value !== "") {
        if(password1.value === password2.value) {
            password1.classList.remove("is-invalid");
            password2.classList.remove("is-invalid");
            password1.classList.add("is-valid");
            password2.classList.add("is-valid");
            return true;
        } else {
            password1.classList.remove("is-invalid");
            password1.classList.add("is-valid");
            password1.classList.remove("is-valid");
            password2.classList.add("is-invalid");
        }
    }
    if(password1.value === "") {
        password1.classList.remove("is-valid");
        password1.classList.add("is-invalid");
    }
    if(password2.value === "") {
        password1.classList.remove("is-valid");
        password2.classList.add("is-invalid");
    }
    return false;
}

