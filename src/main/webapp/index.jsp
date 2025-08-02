<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #fceabb, #f8b500);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            width: 90%;
            max-width: 1400px;
            background: #fff;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            border-radius: 20px;
            overflow: hidden;
        }

        .left-panel {
            flex: 1 1 50%;
            aspect-ratio: 1 / 1; /* Ensures 1:1 Square */
            min-width: 300px;
            background: url('images/img.png') no-repeat center center;
            background-size: cover;
        }

        .form-panel {
            flex: 1 1 50%;
            padding: 40px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            min-width: 300px;
            overflow-y: auto;
        }

        .form-panel h1 {
            font-size: 2.5rem;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        form input, form select {
            padding: 12px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 10px;
            width: 100%;
        }

        .full-width {
            grid-column: span 2;
        }

        .submit-btn {
            grid-column: span 2;
            padding: 14px;
            font-size: 1.2rem;
            background: linear-gradient(to right, #ff512f, #dd2476);
            border: none;
            color: white;
            border-radius: 10px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .submit-btn:hover {
            background: linear-gradient(to right, #dd2476, #ff512f);
        }

        @media (max-width: 900px) {
            .container {
                flex-direction: column;
                align-items: center;
            }

            .left-panel {
                width: 100%;
                aspect-ratio: auto;
                height: 300px;
            }

            .form-panel {
                width: 100%;
                padding: 20px;
            }

            form {
                grid-template-columns: 1fr;
            }

            .full-width, .submit-btn {
                grid-column: span 1;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Left Side Image Panel (Aspect Ratio 1:1 Square) -->
        <div class="left-panel"></div>

        <!-- Form Panel connected to Backend Servlet -->
        <div class="form-panel">
            <h1>Register Here</h1>
            <!-- Form connects to your backend (RegistrationServlet.java) -->
            <form action="register" method="post" enctype="multipart/form-data">

                <input type="text" name="fullName" placeholder="Full Name" required>
                <input type="email" name="email" placeholder="Email" required>

                <input type="text" name="phone" placeholder="Phone">

                <select name="gender">
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>

                <input type="date" name="dob" placeholder="Date of Birth">

                <input type="text" name="city" placeholder="City">
                <input type="text" name="state" placeholder="State">

                <input type="text" name="pinCode" placeholder="Pin Code">
                <input type="text" name="qualification" placeholder="Qualification">

                <input type="text" name="examCenter" placeholder="Exam Center">
                <input type="text" name="category" placeholder="Category">

                <input type="password" name="password" placeholder="Password">

                <label class="full-width">Upload Photo (JPG):
                    <input type="file" name="photo" accept=".jpg" required>
                </label>

                <label class="full-width">Upload Signature (JPG):
                    <input type="file" name="signature" accept=".jpg" required>
                </label>

                <button type="submit" class="submit-btn">Register</button>
            </form>
        </div>
    </div>
</body>
</html>
