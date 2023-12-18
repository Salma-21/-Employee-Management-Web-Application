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
        padding: 40px; /* زيادة الحشو */
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-bottom: 30px;
        display: inline-block;
        text-align: left;
        width: 500px; /* تعيين عرض ثابت للنموذج */
      }

      label {
        margin-right: 10px;
        display: inline-block;
        width: 120px; /* زيادة عرض النص */
      }

      input[type="text"],
      input[type="submit"],
      button {
        padding: 15px; /* زيادة حشو العناصر الداخلية */
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        width: 80%; /* جعل العناصر أوسع داخل النموذج */
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

    <script>
      $(document).ready(function () {
        $("#addEmployeeForm").submit(function (event) {
          event.preventDefault();

          // Collect form data
          var formData = {
            EmployeeID: $("#EmployeeID").val(),
            FirstName: $("#FirstName").val(),
            LastName: $("#LastName").val(),
            Designation: $("#Designation").val(),
            knownLanguages: getLanguagesData(), // Call a function to get languages data
          };
          // Send AJAX request
          $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addEmployee",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function (response) {
              console.log("Employee added successfully");
              window.location.href = "/index";
            },
            error: function (xhr, status, error) {
              console.log("Error: ");
              alert(xhr.responseText);
            },
          });
        });

        function getLanguagesData() {
          var languagesData = [];

          // Collect data from dynamically generated language fields
          $(".language").each(function (index) {
            var languageObject = {
              LanguageName: $(this)
                .find(`[name="languages[${index}].languageName"]`)
                .val(),
              ScoreOutof100: parseInt(
                $(this).find(`[name="languages[${index}].scoreOutof100"]`).val()
              ),
            };

            // Check if both languageName and scoreOutof100 are present before adding to the array
            if (
              languageObject.languageName &&
              !isNaN(languageObject.scoreOutof100)
            ) {
              languagesData.push(languageObject);
            }
          });

          return languagesData;
        }
      });
    </script>
  </head>
  <body>
    <h1>Employee Management System</h1>

    <form method="POST" action="/addEmployee" id="addEmployeeForm">
      <!-- Other fields -->
      <label for="employeeId">Employee ID:</label>
      <input
        type="text"
        id="EmployeeID"
        name="employeeId"
        required
      /><br /><br />
      <br /><br />

      <label for="firstName">First Name:</label>
      <input type="text" id="FirstName" name="firstName" required /><br /><br />

      <label for="lastName">Last Name:</label>
      <input type="text" id="LastName" name="lastName" required /><br /><br />

      <label for="designation">Designation:</label>
      <input
        type="text"
        id="Designation"
        name="designation"
        required
      /><br /><br />

      <label for="numberOfLanguages">Number of Languages:</label>
      <input
        type="number"
        id="numberOfLanguages"
        name="numberOfLanguages"
        required
        min="1"
      /><br /><br />

      <!-- Container for dynamic language inputs -->
      <div id="dynamicLanguages"></div>

      <button type="button" onclick="generateLanguageFields()">
        Generate Language Fields</button
      ><br /><br />

      <input type="submit" value="Add Employee" />
    </form>

    <script>
      function generateLanguageFields() {
        var numberOfLanguages = $("#numberOfLanguages").val();
        var dynamicLanguagesDiv = $("#dynamicLanguages");
        dynamicLanguagesDiv.empty(); // Clear existing fields

        for (var i = 1; i <= numberOfLanguages; i++) {
          dynamicLanguagesDiv.append(
            `<div class="language">
                      <label for="languages[${
                        i - 1
                      }].languageName">Language Name ${i}:</label>
                      <input type="text" name="languages[${
                        i - 1
                      }].languageName" required /><br /><br />
  
                      <label for="languages[${
                        i - 1
                      }].scoreOutof100">Score Outof 100 ${i}:</label>
                      <input type="number" name="languages[${
                        i - 1
                      }].scoreOutof100" required min="0" max="100" /><br /><br />
                  </div>`
          );
        }
      }
    </script>
  </body>
</html>
