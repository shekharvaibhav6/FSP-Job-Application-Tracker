const apiUrl = 'http://localhost:8080/api/jobs';

// Fetch all job applications
const fetchApplications = async () => {
  const response = await fetch(apiUrl);
  const applications = await response.json();
  const table = document.getElementById('applicationsTable');
  table.innerHTML = '';

  applications.forEach(app => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${app.companyName}</td>
      <td>${app.role}</td>
      <td>${app.applicationDate}</td>
      <td>${app.status}</td>
      <td>${app.notes}</td>
      <td>
        <button onclick="deleteApplication(${app.id})">Delete</button>
      </td>
    `;
    table.appendChild(row);
  });
};

// Add a new job application
document.getElementById('jobForm').addEventListener('submit', async e => {
  e.preventDefault();
  const application = {
    companyName: document.getElementById('companyName').value,
    role: document.getElementById('role').value,
    applicationDate: document.getElementById('applicationDate').value,
    status: document.getElementById('status').value,
    notes: document.getElementById('notes').value
  };

  await fetch(apiUrl, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(application)
  });
  fetchApplications();
});

// Delete a job application
const deleteApplication = async id => {
  await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
  fetchApplications();
};

// Initial fetch
fetchApplications();
