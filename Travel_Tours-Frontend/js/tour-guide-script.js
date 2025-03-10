$(document).ready(function () {
    // Handle form submission to save new guide
    $("#tourGuideForm").submit(function (event) {
        event.preventDefault(); // Prevent default form submission

        let formData = {
            fullName: $("#fullName").val(),
            phoneNumber: $("#phoneNumber").val(),
            email: $("#email").val(),
            experience: $("#experience").val(),
            languagesSpoken: $("#languagesSpoken").val()
        };

        console.log("Form data to send:", formData); // Log form data for debugging

        saveTourGuide(formData); // Call saveTourGuide with formData
    });

    // Function to save tour guide
    function saveTourGuide(formData) {
        $.ajax({
            url: `http://localhost:8080/api/v1/tour-guides/save`, // Correct API endpoint for saving tour guides
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function (data) {
                alert("Tour guide saved successfully!");
                console.log("Saved guide:", data); // Log the saved data to inspect the response
                addTourGuideToTable(data); // Add the saved guide to the table
                clearForm(); // Clear the form after saving
            },
            error: function (xhr, status, error) {
                console.error("Error:", xhr.responseText); // Log any errors
                alert("Error saving tour guide!");
            }
        });
    }

    // Add the newly saved tour guide to the table
    function addTourGuideToTable(guide) {
        let tableBody = $("#tourGuideTableBody");

        // Check if guide object contains the necessary data
        if (guide && guide.guideID) {
            // Create a new table row with the saved guide's data
            let row = `<tr data-guide-id="${guide.guideID}">
                <td>${guide.guideID || 'N/A'}</td>
                <td>${guide.fullName}</td>
                <td>${guide.phoneNumber}</td>
                <td>${guide.email}</td>
                <td>${guide.experience}</td>
                <td>${guide.languagesSpoken}</td>
                <td>
                    <button class="btn btn-sm btn-warning" onclick="editTourGuide(${guide.guideID})">Edit</button>
                    <button class="btn btn-sm btn-danger" onclick="deleteTourGuide(${guide.guideID})">Delete</button>
                </td>
            </tr>`;

            // Append the new row to the table body
            tableBody.append(row);
        } else {
            console.error("Invalid guide data:", guide); // Log invalid data
        }
    }

    // Clear the form fields after saving
    function clearForm() {
        $("#guideId").val('');
        $("#fullName").val('');
        $("#phoneNumber").val('');
        $("#email").val('');
        $("#experience").val('');
        $("#languagesSpoken").val('');
    }

    // Edit tour guide function (fetch guide by guideID and populate the form)
    window.editTourGuide = function (guideID) {
        // Ensure guideID is passed correctly
        console.log("Editing guide with ID:", guideID); // Add a log for debugging

        $.ajax({
            type: "GET",
            url: `http://localhost:8080/api/v1/tour-guides/get/${guideID}`, // Correct endpoint to fetch one guide by guideID
            success: function (data) {
                console.log("Guide data:", data); // Add a log to check what data is being returned

                // Ensure data is not empty or null
                if (data && data.guideID) {
                    $("#guideId").val(data.guideID); // Set the guide ID field for updating
                    $("#fullName").val(data.fullName); // Set the Full Name
                    $("#phoneNumber").val(data.phoneNumber); // Set the phone number
                    $("#email").val(data.email); // Set the email
                    $("#experience").val(data.experience); // Set the experience
                    $("#languagesSpoken").val(data.languagesSpoken); // Set languages spoken

                    // Show the update and delete buttons, hide the save button
                    $("#saveButton").hide();
                    $("#updateButton").show();
                    $("#deleteButton").show();
                } else {
                    alert("Guide data is not valid or not found.");
                }
            },
            error: function () {
                alert("Failed to load guide data.");
            }
        });
    };

    // Update tour guide function
    window.updateTourGuide = function () {
        let formData = {
            guideID: $("#guideId").val(),
            fullName: $("#fullName").val(),
            phoneNumber: $("#phoneNumber").val(),
            email: $("#email").val(),
            experience: $("#experience").val(),
            languagesSpoken: $("#languagesSpoken").val()
        };

        $.ajax({
            type: "PUT",
            url: `http://localhost:8080/api/v1/tour-guides/update/${formData.guideID}`, // Update the guide by guideID
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function (response) {
                alert("Tour guide updated successfully!");
                loadTourGuides(); // Refresh table with updated data
                $("#tourGuideForm")[0].reset(); // Clear form after success
                $("#saveButton").show();
                $("#updateButton").hide();
                $("#deleteButton").hide();
            },
            error: function (xhr, status, error) {
                console.error("Error:", xhr.responseText); // Log any errors
                alert("Failed to update tour guide.");
            }
        });
    };

    // Delete tour guide function
    window.deleteTourGuide = function (guideID) {
        if (confirm("Are you sure you want to delete this tour guide?")) {
            $.ajax({
                type: "DELETE",
                url: `http://localhost:8080/api/v1/tour-guides/delete/${guideID}`, // Delete the guide by guideID
                success: function (response) {
                    alert("Tour guide deleted successfully!");
                    loadTourGuides(); // Refresh table after deletion
                },
                error: function (xhr, status, error) {
                    console.error("Error:", xhr.responseText); // Log any errors
                    alert("Failed to delete tour guide.");
                }
            });
        }
    };

    // Load existing tour guides when the page is ready
    function loadTourGuides() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/v1/tour-guides/getAll", // Correct URL for fetching all guides
            success: function (data) {
                let tableBody = $("#tourGuideTableBody");
                tableBody.empty(); // Clear any existing data in the table
                data.forEach(guide => {
                    let row = `<tr data-guide-id="${guide.guideID}">
                        <td>${guide.guideID || 'N/A'}</td>
                        <td>${guide.fullName}</td>
                        <td>${guide.phoneNumber}</td>
                        <td>${guide.email}</td>
                        <td>${guide.experience}</td>
                        <td>${guide.languagesSpoken}</td>
                        <td>
                            <button class="btn btn-sm btn-warning" onclick="editTourGuide(${guide.guideID})">Edit</button>
                            <button class="btn btn-sm btn-danger" onclick="deleteTourGuide(${guide.guideID})">Delete</button>
                        </td>
                    </tr>`;
                    tableBody.append(row); // Add the new row to the table
                });
            },
            error: function () {
                alert("Failed to fetch tour guides.");
            }
        });
    }

    // Load existing tour guides when the page is ready
    loadTourGuides();
});
