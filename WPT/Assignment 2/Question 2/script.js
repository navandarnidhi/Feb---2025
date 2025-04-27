const form = document.getElementById('myForm');
const outputDiv = document.getElementById('output');

form.addEventListener('submit', function(event) {
  event.preventDefault(); // Prevent form from refreshing the page

  // Get form values
  const firstName = document.getElementById('fname').value;
  const lastName = document.getElementById('lname').value;
  const contact = document.getElementById('contact').value;
  const email = document.getElementById('email').value;

  // Display values
  outputDiv.innerHTML = `
    <h2>Form Submitted Successfully!</h2>
    <p><strong>First Name:</strong> ${firstName}</p>
    <p><strong>Last Name:</strong> ${lastName}</p>
    <p><strong>Contact Number:</strong> ${contact}</p>
    <p><strong>Email ID:</strong> ${email}</p>
  `;

  // Optional: Clear the form fields after submitting
  form.reset();
});
