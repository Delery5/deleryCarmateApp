<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Signup Page</h2>
    <form action="signup" method="post">
        <label for="username">Username (required):</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="email">Email (optional):</label>
        <input type="email" id="email" name="email">
        <br>
        <input type="submit" value="Submit">
    </form>

    <h2>Async Signup</h2>
    <form onsubmit="asyncSignup(); return false;">
        <label for="usernameAsync">Username (required):</label>
        <input type="text" id="usernameAsync" name="username" required>
        <br>
        <label for="emailAsync">Email (optional):</label>
        <input type="email" id="emailAsync" name="email">
        <br>
        <button type="button" onclick="asyncSignup()">Submit Async</button>
    </form>
    <div id="asyncResult"></div>

    <script>
        function asyncSignup() {
            var username = document.getElementById('usernameAsync').value;
            var email = document.getElementById('emailAsync').value;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "asyncSignup", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById('asyncResult').innerHTML = xhr.responseText;
                }
            };
            xhr.send("username=" + username + "&email=" + email);
        }
    </script>
</body>
</html>

