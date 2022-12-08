function loadAllTeachers() {
    let url = 'http://localhost:8080/teachers';
    loadTeachersWithUrl(url);
}

function loadTeachersWithUrl(url) {
    fetch(url, {
        method: 'GET',
        headers: {
            Accept: 'application/json',
        }
    }).then(response => {
        if (response.ok) {
            response.json().then(json => {
                showTeachers(json);
            });
        }
    });
}

function showTeachers(teachers) {
    let id = "teachersTable";
    clearIfExists(id);

    const table = document.createElement('table');
    table.id = id;
    table.className = "table";

    const tableHead = document.createElement('thead');
    appendHeaderToTable(tableHead, 'Фамилия');
    appendHeaderToTable(tableHead, 'Имя');
    appendHeaderToTable(tableHead, 'Отчество');

    const tableBody = document.createElement('tbody');
    teachers.forEach(teacher => {
        const row = document.createElement('tr');
        appendCellToRow(row, teacher.lastname);
        appendCellToRow(row, teacher.firstname);
        appendCellToRow(row, teacher.patronymic);
        tableBody.appendChild(row);
    });

    table.appendChild(tableHead);
    table.appendChild(tableBody);
    table.style.marginTop = '50px';
    document.getElementById('main-container').appendChild(table);
}

function clearIfExists(id) {
    let elem = document.getElementById(id);
    if (elem != undefined) {
        elem.remove();
    }
}

function appendHeaderToTable(tableHead, headerText) {
    const header = document.createElement('th');
    header.appendChild(document.createTextNode(headerText));
    tableHead.appendChild(header);
}

function appendCellToRow(row, cellText) {
    const cell = row.insertCell();
    cell.appendChild(document.createTextNode(cellText));
}

function addTeacher() {
    const lastname = readStringValueFromInput("lastname");
    const firstname = readStringValueFromInput("firstname");
    const patronymic = readStringValueFromInput("patronymic");

    const data = {
        "firstname": firstname,
        "lastname": lastname,
        "patronymic": patronymic,
    };

    fetch('http://localhost:8080/teachers', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}

function readStringValueFromInput(inputId) {
    let elem = document.getElementById(inputId);
    let value = elem.value;
    elem.value = "";
    return value;
}