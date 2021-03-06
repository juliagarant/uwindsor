<!-- Assignment 3
Julia Garant   July 26 2021

-->

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Sign Up</title>

    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="myScript.js" ></script>

  </head>
  <body id="task1">
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

        $fname = $_REQUEST['fname'];
        $lname = $_REQUEST['lname'];

        $day = $_REQUEST['dob:day'];
        $mon = $_REQUEST['dob:mon'];
        $year = $_REQUEST['dob:year'];
        $gender = $_REQUEST['gender'];
        $country = $_REQUEST['country'];

        $email = $_REQUEST['email'];
        $phone = $_REQUEST['phone'];
        $pass = $_REQUEST['pass'];

        $dob = $year.'-'.$mon.'-'.$day;

        // if(empty($_POST["fname"])){
        //   echo "<br>Error: Must fill in First Name<br>";
        // }
        // else{

          $newUSER = "INSERT INTO users (fname, lname, dob, gender, country, email, phone, password) VALUES ('$fname', '$lname', '$dob', '$gender', '$country', '$email', '$phone', '$pass')";

          if ($conn->query($newUSER) === TRUE) {
            echo "<br>New record created successfully<br>";
          } else {
               echo "<br>Error: " . $newUSER . "<br>" . $conn->error;
          }
      //  }

   ?>
   <nav>
    <a href="index.php" target="_blank">Complete Form</a> |
    <a href="query.php" target="_blank">Search</a>
   </nav>

    <div class="signup">

      <h3>Sign Up</h3>

      <form>
        <div class="innerForm">
          <table class="innerForm">
              <tr> <!-- First Name -->
                <td>
                  <label for="fname">First Name</label>
                </td>
                <td>
                  <input type="text" id="fname" name="fname" placeholder="Enter First Name" required onchange="checkName()" >
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- Last Name -->
                <td>
                  <label for="lname">Last Name</label>
                </td>
                <td>
                  <input type="text" id="lname" name="lname" placeholder="Enter Last Name" required onchange="checkName()" >
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- DOB -->
                <td>
                  <label for="dob"> Date of Birth</label>
                </td>
                <td>
                  <select class="first" name="dob:day" tabindex="7" required>
                    <option value="Day">Day</option>

                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                  </select>
                  <select name="dob:mon" tabindex="8" required>
                    <option value="Month">Month</option>

                    <option value="1">Jan</option>
                    <option value="2">Feb</option>
                    <option value="3">Mar</option>
                    <option value="4">Apr</option>
                    <option value="5">May</option>
                    <option value="6">Jun</option>
                    <option value="7">Jul</option>
                    <option value="8">Aug</option>
                    <option value="9">Sep</option>
                    <option value="10">Oct</option>
                    <option value="11">Nov</option>
                    <option value="12">Dec</option>
                  </select>
                  <select name="dob:year" tabindex="9" required>
                    <option value="year">Year</option>

                    <option value="1980">1980</option>
                    <option value="1981">1981</option>
                    <option value="1982">1982</option>
                    <option value="1983">1983</option>
                    <option value="1984">1984</option>
                    <option value="1985">1985</option>
                    <option value="1986">1986</option>
                    <option value="1987">1987</option>
                    <option value="1988">1988</option>
                    <option value="1989">1989</option>
                    <option value="1990">1990</option>
                    <option value="1991">1991</option>
                    <option value="1992">1992</option>
                    <option value="1993">1993</option>
                    <option value="1994">1994</option>
                    <option value="1995">1995</option>
                    <option value="1996">1996</option>
                    <option value="1997">1997</option>
                    <option value="1998">1998</option>
                    <option value="1999">1999</option>
                    <option value="2000">2000</option>
                  </select>
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- Gender -->
                <td>
                  <label for="gender">Gender Identity</label>
                </td>
                <td>
                  <input type="radio" name="gender" id="male" value="male" required>
                  <label for="male">Male</label>
                  <input type="radio" name="gender" id="fmale" value="female" required>
                  <label for="fmale">Female</label>
                  <label>*</label>
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <input type="radio" name="gender" id="nb" value="non binary" required>
                  <label for="nb">Non Binary</label>  <!-- Because its 2021, theres more than 2 genders -->

                </td>
              </tr>
              <tr> <!-- Country -->
                <td>
                  <label for="country">Country</label>
                </td>
                <td style="text-align: left" >
                  <select id="country" name="country" required>
                    <option value="CAN">Canada</option>
                    <option value="USA">USA</option>
                  </select>
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- Email -->
                <td>
                  <label for="email">Email</label>
                </td>
                <td>
                  <input type="email" id="email" name="email" placeholder="Enter E-mail" onchange="checkEmail()" required>
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- Phone -->
                <td>
                  <label for="phone">Phone</label>
                </td>
                <td>
                  <input type="text" id="phone" name="phone" placeholder="(xxx)-(xxx)-(xxxx)" onchange="checkPhone()" required>
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- Password -->
                <td>
                  <label for="pass">Password</label>
                </td>
                <td>
                  <input type="password" id="pass" name="pass" onchange="checkPass()" required>
                  <label>*</label>
                </td>
              </tr>
              <tr>
                <td>
                  <label for="cpass">Confirm Password</label>
                </td>
                <td>
                  <input type="password" id="cpass" name="cpass" onchange="confirm()" required>
                  <label>*</label>
                </td>
              </tr>
              <tr> <!-- Terms -->
                <td style="text-align: right;" colspan="2">
                  <input type="checkbox" id="check" name="check" required>
                  <label for="check">I Agree to the Terms of use</label>
                  <label>*</label>
                </td>
              </tr>
            </table>
          </div>

        <div class="buttons">
            <input id="submit" type="submit" value="Submit Query">
            <input id="cancel" type="reset" value="Cancel">
        </div>

      </form>

    </div> <!-- signup -->

    <?php
    $conn->close();
     ?>

  </body>
</html>
