document.getElementById("submitButton").addEventListener("click", function() {
    const username = document.getElementById("usernameMenu").value;
    const value = document.getElementById("valueInput").value;
    const description = document.getElementById("descriptionInput").value;

    // Example of how you could send a POST request to your Spring Boot API
    fetch('http://localhost:8080/api/payment/new/'+username,{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ value, description }),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});

document.getElementById("displayButton").addEventListener("click", function() {
    // Dummy function to display imports and sum division by two
    // Replace with actual API call or logic to fetch and display data
    const displayArea = document.getElementById("listDisplay");
    displayArea.innerHTML = "<p>Imported data and sum division by two would be displayed here.</p>";
    // Add logic to edit values next to each list item
});

document.getElementById("eraseButton").addEventListener("click", function() {
    // Clear all inputs and the display area
    document.getElementById("valueInput").value = '';
    document.getElementById("descriptionInput").value = '';
    document.getElementById("listDisplay").innerHTML = '';
});
