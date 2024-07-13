// Obține elementele din DOM
const addInfrastructureDropdown = document.getElementById('addInfrastructureDropdown');
const addInfrastructureOptions = document.getElementById('addInfrastructureOptions');

// Atașează evenimentul de hover
addInfrastructureDropdown.addEventListener('mouseover', function() {
    addInfrastructureOptions.style.display = 'block'; // Afișează opțiunile la hover
});

// Ascunde opțiunile la ieșirea cu mouse-ul
addInfrastructureDropdown.addEventListener('mouseout', function() {
    addInfrastructureOptions.style.display = 'none'; // Ascunde opțiunile la ieșirea cu mouse-ul
});

// Obține elementele din DOM
const userDropdown = document.getElementById('userDropdown');
const userOptions = document.getElementById('userOptions');

// Atașează evenimentul de hover
userDropdown.addEventListener('mouseover', function() {
    userOptions.style.display = 'block';
});

// Ascunde opțiunile la ieșirea cu mouse-ul
userDropdown.addEventListener('mouseout', function() {
    userOptions.style.display = 'none';
});