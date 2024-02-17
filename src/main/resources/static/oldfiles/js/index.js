document.getElementById('addDataForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const formData = {
        desc: document.getElementById('desc').value,
        value: document.getElementById('value').value
    };

    fetch('http://localhost:8080/api/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            alert('Data posted successfully!');
            document.getElementById('addDataForm').reset(); // Reset form after submission
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Error posting data');
        });
});


document.getElementById('fetchData').addEventListener('click', function() {
    // Fetch the person and their payments
    fetch('http://localhost:8080/api/get')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok for getting person data');
            }
            return response.json();
        })
        .then(person => {
            const dataList = document.getElementById('dataList');
            if (person && person.paymentList && Array.isArray(person.paymentList)) {
                let content = `<h3>Payments for ${person.name}</h3><ul>`;
                person.paymentList.forEach(payment => {
                    content += `<li>Description: ${payment.desc}, Value: ${payment.value}</li>`;
                });
                content += '</ul>';
                dataList.innerHTML = content;
            } else {
                dataList.innerHTML = 'No payment data available.';
            }
            // After fetching and displaying person and payments, fetch the sum
            return fetch('http://localhost:8080/api/sum');
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok for getting sum');
            }
            return response.json();
        })
        .then(sumData => {
            // Assuming sumData is directly the sum or adjust based on your actual response structure
            const sumDisplay = document.createElement('p');
            sumDisplay.textContent = `Total Sum: ${sumData.sum}`;
            document.getElementById('dataList').appendChild(sumDisplay);
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Error fetching data');
        });
});