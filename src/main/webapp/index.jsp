<form action="register" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="fullName" required><br>
    Email: <input type="email" name="email" required><br>
    Phone: <input type="text" name="phone"><br>
    Gender: <select name="gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
    </select><br>
    DOB: <input type="date" name="dob"><br>
    Address: <textarea name="address"></textarea><br>
    City: <input type="text" name="city"><br>
    State: <input type="text" name="state"><br>
    Pin Code: <input type="text" name="pinCode"><br>
    Qualification: <input type="text" name="qualification"><br>
    Exam Center: <input type="text" name="examCenter"><br>
    Category: <input type="text" name="category"><br>
    Password: <input type="password" name="password"><br><br>

    Upload Photo (JPG): <input type="file" name="photo" accept=".jpg"><br>
    Upload Signature (JPG): <input type="file" name="signature" accept=".jpg"><br><br>

    <input type="submit" value="Register">
</form>
