<!DOCTYPE html>
<html>
<head>
    <title>Home</title> <!-- Title of the webpage -->
</head>
<body>
    <h2>Welcome to Carmate!</h2> <!-- Heading for the welcome message -->

    <!-- Synchronous signup form -->
    <form action="signup" method="post"> <!-- Form submission to "signup" URL using POST method -->
        <label for="username">Username (required):</label> <!-- Label for username input -->
        <input type="text" id="username" name="username" required> <!-- Input field for username, required -->
        <br>
        <label for="email">Email (optional):</label> <!-- Label for email input -->
        <input type="email" id="email" name="email"> <!-- Input field for email, optional -->
        <br>
        <input type="submit" value="Submit"> <!-- Submit button for the form -->
    </form>

    <h2>Async Signup</h2> <!-- Heading for the asynchronous signup section -->

    <!-- Asynchronous signup form -->
    <form onsubmit="asyncSignup(); return false;"> <!-- Form submission handled by JavaScript function -->
        <label for="usernameAsync">Username (required):</label> <!-- Label for async username input -->
        <input type="text" id="usernameAsync" name="username" required> <!-- Input field for async username, required -->
        <br>
        <label for="emailAsync">Email (optional):</label> <!-- Label for async email input -->
        <input type="email" id="emailAsync" name="email"> <!-- Input field for async email, optional -->
        <br>
        <button type="button" onclick="asyncSignup()">Submit Async</button> <!-- Button to trigger asyncSignup function -->
    </form>
    <div id="asyncResult"></div> <!-- Div to display the result of the async signup -->

    <!-- JavaScript function for asynchronous form submission -->
    <script>
        function asyncSignup() {
            var username = document.getElementById('usernameAsync').value; // Get the value of the async username input
            var email = document.getElementById('emailAsync').value; // Get the value of the async email input
            var xhr = new XMLHttpRequest(); // Create a new XMLHttpRequest object
            xhr.open("POST", "asyncSignup", true); // Initialize the request with POST method and asyncSignup URL
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // Set the request header
            xhr.onreadystatechange = function() { // Define the callback function for when the request state changes
                if (xhr.readyState == 4 && xhr.status == 200) { // Check if the request is complete and successful
                    document.getElementById('asyncResult').innerHTML = xhr.responseText; // Display the response in the asyncResult div
                }
            };
            xhr.send("username=" + username + "&email=" + email); // Send the request with the form data
        }
    </script>
</body>
</html>


