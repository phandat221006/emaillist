<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css">
</head>

<body>
        <img src="images/logo.jpg" alt="logo murach">
        <h1>Thanks for joining our email list</h1>

    <main>
        <p>Here is the information that you entered:</p>

        <dl class="card">
            <dt>First Name:</dt>
            <dd>${user.firstName}</dd>

            <dt>Last Name:</dt>
            <dd>${user.lastName}</dd>

            <dt>Email:</dt>
            <dd>${user.email}</dd>

            <dt>Date of Birth:</dt>
            <dd>${user.dateOfBirth}</dd>

            <dt>Heard about us:</dt>
            <dd>${survey.source}</dd>

            <dt>Announcements:</dt>
            <dd>${survey.receiveAnnouncements ? 'Yes' : 'No'}</dd>

            <dt>Special Offers:</dt>
            <dd>${survey.receiveOffers ? 'Yes' : 'No'}</dd>

            <dt>Contact method:</dt>
            <dd>${survey.contactMethod}</dd>
        </dl>

        <p class="note">To enter another email address, click on the Back
           button in your browser or the Return button shown below.</p>

        <form action="emailList" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
    </main>
</body>
</html>