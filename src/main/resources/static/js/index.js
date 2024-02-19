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
    const username = document.getElementById("usernameMenu").value;

    fetch(`http://localhost:8080/api/get/${username}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Received data:', data); // Debug log to inspect the structure of the data

            // Check if the paymentList property exists and is an array
            if (!data.paymentList || !Array.isArray(data.paymentList)) {
                console.error('paymentList property is missing or not an array:', data);
                return;
            }

            const displayArea = document.getElementById("listDisplay");
            let totalSum = 0;
            let listHTML = '<ul>';

            data.paymentList.forEach(item => {
                let value = parseFloat(item.value);
                totalSum += value;
                listHTML += `<li>${value} - ${item.description} <button onclick="editItem('${item.id}')">Edit</button></li>`;
            });

            listHTML += '</ul>';
            listHTML += `<p>Sum divided by two: ${(totalSum / 2).toFixed(2)}</p>`;
            displayArea.innerHTML = listHTML;
        })
        .catch((error) => {
            console.error('Fetch error:', error);
            document.getElementById("listDisplay").innerHTML = "<p>Error fetching data. Please check the console for more information.</p>";
        });
});

function editItem(itemId) {
    console.log(`Editing item ${itemId}`);
    // Implement your edit functionality here
}
