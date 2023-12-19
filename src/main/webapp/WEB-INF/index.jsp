<!DOCTYPE html>
<html>

<head>
    <title>Employee Management System</title>
    <style>
        body {
            font-family: "Arial", sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px;
            display: inline-block;
            text-align: left;
            max-width: 500px;
            margin: 0 auto; /* Center the form on the page */
        }

        label {
            margin-right: 10px;
            display: inline-block;
            width: 120px;
        }

        input[type="text"],
        input[type="number"],
        input[type="submit"],
        button {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box; /* Ensure padding and border are included in width */
        }

        input[type="submit"],
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover,
        button:hover {
            background-color: #0056b3;
        }

        #result {
            color: green;
        }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>

<body>
    <h1>Employee Management System</h1>

    <form method="POST" action="/addEmployee" id="addEmployeeForm">
        <!-- Other fields -->
        <label for="EmployeeID">Employee ID:</label>
        <input type="text" id="EmployeeID" name="EmployeeID" required /><br /><br />

        <label for="FirstName">First Name:</label>
        <input type="text" id="FirstName" name="FirstName" required /><br /><br />

        <label for="LastName">Last Name:</label>
        <input type="text" id="LastName" name="LastName" required /><br /><br />

        <label for="Designation">Designation:</label>
        <input type="text" id="Designation" name="Designation" required /><br /><br />

        <label for="languageName1">Language Name 1:</label>
        <input type="text" id="languageName1" name="languageName1" required />
        <label for="scoreOutof1001">Score Outof100 1:</label>
        <input type="number" id="scoreOutof1001" name="scoreOutof1001" required min="0" max="100" /><br /><br />

        <!-- Language 2 -->
        <label for="languageName2">Language Name 2:</label>
        <input type="text" id="languageName2" name="languageName2" required />
        <label for="scoreOutof1002">Score Outof100 2:</label>
        <input type="number" id="scoreOutof1002" name="scoreOutof1002" required min="0" max="100" /><br /><br />

        <!-- Language 3 -->
        <label for="languageName3">Language Name 3:</label>
        <input type="text" id="languageName3" name="languageName3" required />
        <label for="scoreOutof1003">Score Outof100 3:</label>
        <input type="number" id="scoreOutof1003" name="scoreOutof1003" required min="0" max="100" /><br /><br />

        <input id="myButton" type="submit" value="Add Employee" />
    </form>
</body>

</html>
