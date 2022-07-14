<!-- Assignment 3
Julia Garant   July 26 2021

-->

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Sign Up</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
      <?php
      $servername = "localhost";
      $username = "garan119_2707A3";
      $password = "assignment3";
      $dbname = "garan119_2707A3";

           // Create connection
           $conn = new mysqli($servername, $username, $password, $dbname);
           // Check connection
           if ($conn->connect_error) {
               die("Connection failed: " . $conn->connect_error);
           }

      $fname1 = $_POST['fname1'];
      $country1 = $_POST['country1'];
      $gender1 = $_POST['gender1'];
      $flag = false;
      // If first name is searched
      if(!empty($_POST['fname1'])){
        $query = "SELECT fname, lname, dob, gender, country, email, phone FROM users WHERE fname = '$fname1'";
        $flag = true;
      } elseif (!empty($_POST['country1'])) {
        $query = "SELECT fname, lname, dob, gender, country, email, phone FROM users WHERE country = '$country1'";
        $flag = true;
      } elseif (!empty($_POST['gender1'])) {
        $query = "SELECT fname, lname, dob, gender, country, email, phone FROM users WHERE gender = '$gender1'";
        $flag = true;
      }
      // else{
      //   echo "Whoops!";
      // }

       ?>
       <nav>
        <a href="index.php" target="_blank">Complete Form</a> |
        <a href="query.php" target="_blank">Search</a>
       </nav>

      <div class="container">
        <h3>Search</h3>
        <form action="query.php" method="post">
          <div class="form-group">
            <label for="fname1">First Name: </label>
            <input type="text" class="form-control" id="fname1" name="fname1" placeholder="">
          </div>

          <div class="form-group">
            <label for="country1">Country: </label>
            <input type="text" class="form-control" id="country1" name="country1" placeholder="CAN/USA">
          </div>

          <div class="form-group">
            <label for="gender1">Gender: </label>
            <input type="text" class="form-control" id="gender1" name="gender1" placeholder="male/female/non binary">
          </div>

          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="container">
      <h3>Results</h3>
          <table class="table">
            <thead>
              <tr>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">D.O.B</th>
                <th scope="col">Gender</th>
                <th scope="col">Country</th>
                <th scope="col">Email</th>
                <th scope="col">Phone</th>
              </tr>
            </thead>
            <tbody>
              <?php

              if($flag){
                $users = $conn->query($query);
                echo $conn->error;

                if ($users->num_rows > 0) {
                  // output data of each row
                  while($row = $users->fetch_assoc()) {
                    //$row = $users->fetch_assoc();
                      echo "<tr><td>" . $row["fname"]. "</td><td>" . $row["lname"]. "</td><td>" . $row["dob"]. "</td><td>" . $row["gender"] . "</td><td>" . $row["country"] . "</td><td>" . $row["email"] . "</td><td>" . $row["phone"] . "</td></tr>" ;
                    }
                  }
                }

              ?>
            </tbody>
          </table>
    </div>
    </body>
  </html>
