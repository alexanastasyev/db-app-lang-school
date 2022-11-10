function loadAllCourses() {
    fetch('http://localhost:8080/courses' , {
        method: 'GET',
        headers: {
            Accept: 'application/json',
        }
    }).then(response => {
        if (response.ok) {
            response.json().then(json => {
                showCourses(json);
            });
        }
    });
}

function showCourses(courses) {
    const table = document.createElement('table');
    table.className = "table";

    const tableHead = document.createElement('thead');
    appendHeaderToTable(tableHead, 'Название');
    appendHeaderToTable(tableHead, 'Язык');
    appendHeaderToTable(tableHead, 'Преподаватель');
    appendHeaderToTable(tableHead, 'Описание');

    const tableBody = document.createElement('tbody');
    courses.forEach(course => {
        const row = document.createElement('tr');
        appendCellToRow(row, course.name);
        appendCellToRow(row, course.language.name);
        appendCellToRow(row, formTeacherName(course.teacher));
        appendCellToRow(row, course.description);
        tableBody.appendChild(row);
    });

    table.appendChild(tableHead);
    table.appendChild(tableBody);
    table.style.marginTop = '50px';
    document.getElementById('main-container').appendChild(table);
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

function formTeacherName(teacher) {
    return teacher.lastname + ' ' + teacher.firstname + ' ' + teacher.patronymic;
}