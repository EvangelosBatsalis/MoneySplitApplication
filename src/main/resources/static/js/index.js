document.getElementById("submitButton").addEventListener("click", function() {
    const username = document.getElementById("usernameMenu").value;
    const value = document.getElementById("valueInput").value;
    const description = document.getElementById("descriptionInput").value;

    // Example of how you could send a POST request to your Spring Boot API
    fetch('api/payment/new/'+username,{
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

    fetch(`api/get/${username}`, {
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
// Function to handle editing an item
// Function to handle editing an item
function editItem(itemId, currentValue, currentDescription) {
    // Create input fields for value and description
    const valueInput = document.createElement("input");
    valueInput.type = "number";
    valueInput.value = currentValue;

    const descriptionInput = document.createElement("input");
    descriptionInput.type = "text";
    descriptionInput.value = currentDescription;

    // Replace the text with input fields
    const listItem = document.getElementById(`item-${itemId}`);
    listItem.innerHTML = ""; // Clear the content
    listItem.appendChild(valueInput);
    listItem.appendChild(descriptionInput);

    // Create a save button
    const saveButton = document.createElement("button");
    saveButton.textContent = "Save";
    saveButton.addEventListener("click", function() {
        // Extract values from input fields
        const newValue = valueInput.value;
        const newDescription = descriptionInput.value;

        // Send a request to update the item via API
        fetch(`api/save/${itemId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ value: newValue, description: newDescription }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to update item');
                }
                return response.json();
            })
            .then(data => {
                console.log('Item updated successfully:', data);
                // Update the displayed data
                displayData(); // You need to implement this function to refresh the displayed data
            })
            .catch((error) => {
                console.error('Error updating item:', error);
                // Optionally, display an error message to the user
            });
    });

    // Append the save button
    listItem.appendChild(saveButton);

    // Create a delete button
    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", function() {
        // Send a request to delete the item via API
        fetch(`api/delete/${itemId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to delete item');
                }
                return response.json();
            })
            .then(data => {
                console.log('Item deleted successfully:', data);
                // Update the displayed data
                displayData(); // You need to implement this function to refresh the displayed data
            })
            .catch((error) => {
                console.error('Error deleting item:', error);
                // Optionally, display an error message to the user
            });
    });

    // Append the delete button
    listItem.appendChild(deleteButton);
}

// Function to display the data (assumed to be called initially and after updating)
function displayData() {
    const username = document.getElementById("usernameMenu").value;

    fetch(`api/get/${username}`, {
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
            const displayArea = document.getElementById("listDisplay");
            displayArea.innerHTML = ""; // Clear existing content

            if (!data.paymentList || !Array.isArray(data.paymentList)) {
                console.error('paymentList property is missing or not an array:', data);
                return;
            }

            let totalSum = 0;
            let listHTML = '<ul>';

            data.paymentList.forEach(item => {
                let value = parseFloat(item.value);
                totalSum += value;
                listHTML += `<li id="item-${item.id}">${value} - ${item.description} <button onclick="editItem(${item.id}, ${value}, '${item.description}')">Edit</button></li>`;
            });

            listHTML += '</ul>';
            listHTML += `<p>Sum divided by two: ${(totalSum / 2).toFixed(2)}</p>`;
            displayArea.innerHTML = listHTML;
        })
        .catch((error) => {
            console.error('Fetch error:', error);
            const displayArea = document.getElementById("listDisplay");
            displayArea.innerHTML = "<p>Error fetching data. Please check the console for more information.</p>";
        });
}

// Initial display of data
displayData();
