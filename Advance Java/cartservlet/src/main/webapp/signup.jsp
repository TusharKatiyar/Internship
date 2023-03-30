<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="css/signupPage/signupCustom.css">
</head>

<body style="font-family: lato;">
    <div class="container-fluid bg-white">
        <div class="heading">
            <h2 class="heading-text text-center fw-bold pt-2">Sign up</h1>
        </div>
        <hr>
        <div class="row justify-content-center mt-md-4">
            <div class="col-md-10">
                <div class="row justify-content-center text-black">
                    <div class="col-md-8">
                        <form action="signup" method="post" id="signupForm"  enctype="multipart/form-data">
                            <div class="row">
                                <div class="col">
                                    <label for="firstName" class="form-label fs-6 mb-0">First Name:</label>
                                    <input autofocus required type="text"
                                        class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                        placeholder="First Name" id="firstName" name="firstName">
                                </div>
                                <div class="col">
                                    <label for="lastName" class="form-label fs-6 mb-0">Last Name:</label>
                                    <input required type="text"
                                        class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                        placeholder="Last Name" id="lastName" name="lastName">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="designation" class="form-label fs-6 mb-0">Designation:</label>
                                    <input required type="text"
                                        class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                        placeholder="Designation" id="designation" name="designation">
                                </div>
                                <div class="col">
                                    <label for="contactNumber" class="form-label fs-6 mb-0">Contact Number:</label>
                                    <input required type="number"
                                        class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                        placeholder="9999999999" id="contactNumber" name="contactNumber">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="employeeID" class="form-label fs-6 mb-0">Employee ID:</label>
                                    <input required type="number"
                                        class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                        placeholder="Employee ID Number" id="employeeID" name="employeeID">
                                </div>
                                <div class="col">
                                    <label for="dob" class="form-label fs-6 mb-0">Date of Birth:</label>
                                    <input required type="date"
                                        class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic" 
                                        id="dob" name="dob">
                                </div>
                            </div>

                            <label for="address" class="form-label fs-6 mb-0">Address:</label>
                            <input required type="text" class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                placeholder="1234 Main St, Apartemnt/floor, city/Village, State, Pincode" 
                                id="address" name="address">

                            <div class="row">
                                <div class="col">
                                    <label for="profilePicture" class="form-label fs-6 mb-0">Profile Picture:</label>
                                    <input type="file" class="fs-6 mb-2 fst-italic" placeholder=""
                                        id="profilePicture" name="profilePicture">
                                </div>
                                <div class="col">
                                    <label for="link" class="form-label fs-6 mb-0">Link:</label>
                                    <input required type="text" class="form-control fs-6 mb-2 fst-italic" placeholder="link.com"
                                        id="link" name="link">
                                </div>
                                <div class="col">
                                    <label for="language" class="form-label fs-6 mb-0">Language:</label>
                                    <select required class="form-select fs-6 mb-2 fst-italic" id="language" name="language">
                                        <option value="English">English</option>
                                        <option value="Hindi">Hindi</option>
                                    </select>
                                </div>
                            </div>
                            <label for="email" class="form-label fs-6 mb-0">Email:</label>
                            <input required type="email" class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                placeholder="Email" id="email" name="email">


                            <label for="password" class="form-label fs-6 mb-0">Password</label>
                            <input required type="password" class="form-control form-control-md rounded-0 fs-6 mb-2 fst-italic"
                                placeholder="Password" id="password" name="password">

                            <div class="row justify-content-center">
                                <div class="col-9 align-content-center">
                                    <input type="submit" class="btn no- w-100 btn-primary mt-3 fs-6" value="Submit">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col">
                <img id="profilePicdummy" src="src/signupPage/profiledummy.png" alt="Profile Picture" class="img-thumbnail rounded-circle border-0">
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>