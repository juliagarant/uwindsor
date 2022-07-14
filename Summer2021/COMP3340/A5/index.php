<!-- Assignment 5 Julia Garant Summer 2021 -->
<!DOCTYPE html>
<html>
<head>
    <title> Assignment 5</title>
    <style media="screen">
      table{
        margin: auto;
        text-align:center;
      }
      #addUser, #editUser, #deleteUser, #addTime, #editTime, #deleteTime{
        border-style: solid;
        padding: 10px;
        background-color:floralwhite;
      }
      #addUser{
        padding-top: 60px;
		padding-bottom: 60px;
      }
      #deleteUser{
        padding-top: 67px;
		padding-bottom: 67px;
      }
      #input{
        padding: 5px;
      }
      th{
        background-color: peru;
        color: white;
        border-collapse: collapse;
		font-size: 18px;
        padding: 10px;

      }
    </style>
</head>
<body>

 <?php
 $servername = "localhost";
 $username = "garan119_3340A5";
 $password = "assignment5";
 $dbname = "garan119_3340A5";

      // Create connection
      $conn = new mysqli($servername, $username, $password, $dbname);
      // Check connection
      if ($conn->connect_error) {
          die("Connection failed: " . $conn->connect_error);
      }
//--------------------------------------------------------------------------------------------------
  // Add to USERS
  		$fname = $_REQUEST['fname'];
      $lname = $_REQUEST['lname'];
      $email = $_REQUEST['email'];

    if(!empty($_POST["fname"]) && !empty($_POST["lname"]) && !empty($_POST["email"])){
        $addUSER = "INSERT INTO users (firstN, lastN, email) VALUES ('$fname', '$lname', '$email')";

        if ($conn->query($addUSER) === TRUE) {
         echo "<br>New record created successfully<br>";
       } else {
         echo "<br>Error: " . $addUSER . "<br>" . $conn->error;
       }
     }
  // Edit a user
    $Edit = $_REQUEST['Edit'];
    $newfname = $_REQUEST['newfname'];
    $newlname = $_REQUEST['newlname'];

    if(!empty($_POST["Edit"])){
      $editUSER = "UPDATE users SET firstN = '$newfname', lastN='$newlname' WHERE email = '$Edit'";

      if ($conn->query($editUSER) === TRUE) {
        echo "Record updated successfully";
      } else {
        echo "Error updating record: " . $conn->error;
      }
    }

  // Delete a user
    $Delete = $_REQUEST['Delete'];

    if(!empty($_POST["Delete"])){
        $delUSER = "DELETE FROM users WHERE email='$Delete'";

        if ($conn->query($delUSER) === TRUE) {
          echo "<br>Record deleted successfully<br>";
        } else {
          echo "<br>Error deleting record: " . $conn->error ."<br>";
        }
      }
//--------------------------------------------------------------------------------------------------
    // Add time
     $sid = $_REQUEST['sid'];
     $userEmail = $_REQUEST['userEmail'];

     if(!empty($_POST['sid']) && !empty($_POST['userEmail'])){

       $q1 = "SELECT firstN, lastN FROM users WHERE email = '$userEmail'";

       $r1 = $conn->query($q1);
       $s1 = $r1->fetch_assoc();
       print_r($s1);
       echo $s1['lastN'];

       $q2 = "UPDATE schedule SET firstN = '" . $s1['firstN'] . "', lastN = '" . $s1['lastN'] . "' WHERE id = $sid";

       $r2 = $conn->query($q2);
      }

      // Edit time
      $sid1 = $_REQUEST['sid1'];
      $sid2 = $_REQUEST['sid2'];

      if(!empty($_POST['sid1']) && !empty($_POST['sid2'])){

        //  grab the first and last name for
        $editTIME = "SELECT firstN, lastN FROM schedule WHERE id = '$sid1'";

        $editr1 = $conn->query($editTIME);
        $edits1 = $editr1->fetch_assoc();

        // add the current first and last name to the new id
        $edit2 = "UPDATE schedule SET firstN = '" . $edits1['firstN'] . "', lastN = '" . $edits1['lastN'] . "' WHERE id = $sid2";

        $editr2 = $conn->query($edit2);

        // delete first and last name
        $edit3 = "UPDATE schedule SET firstN = '', lastN = '' WHERE id = '$sid1'";
        $editr3 = $conn->query($edit3);

      }

      // Delete times
      $sidd = $_REQUEST['sidd'];

      if(!empty($_POST['sidd'])){
        $delTIME = "UPDATE schedule SET firstN = '', lastN = '' WHERE id = '$sidd'";

         if ($conn->query($delTIME) === TRUE) {
           echo "<br>Record deleted successfully<br>";
         } else {
           echo "<br>Error deleting record: " . $conn->error ."<br>";
         }
      }
//--------------------------------------------------------------------------------------------------
// Display the contents of USERS
      $select = "SELECT firstN, lastN, email FROM users";

      $users = $conn->query($select);

// Display the contents of SCHEDULE
      //$schedule = "SELECT firstN, lastN, start, end FROM users";
      $schedule = "SELECT id, firstN, lastN, start, end FROM schedule";
      $result = $conn->query($schedule);

//--------------------------------------------------------------------------------------------------
?>
    <table id="usersTable">
       <tr>
         <td>
           <form id="addUser" action="index.php" method="post">
             <div id="input"><label>First Name: </label><input type="text" id="fname" name="fname"></div>
             <div id="input"><label>Last Name: </label><input type="text" id="lname" name="lname"></div>
             <div id="input"><label>Email: </label><input type="text" id="email" name="email"></div>
             <input type="submit" name="add" value="Add User">
           </form>
         </td><!-- Add user -->
         <td>
          <form id="editUser" action="index.php" method="post">
             <p>Enter the email of the user you want to edit.</p>
             <div id="input"><label>Email: </label><input type="text" id="Edit" name="Edit"></div>
             <p><b>New values:</b></p>
             <div id="input"><label>First Name: </label><input type="text" id="newfname" name="newfname"></div>
             <div id="input"><label>Last Name: </label><input type="text" id="newlname" name="newlname"></div>
             <input type="submit" name="edit" value="Edit User">
           </form>
         </td> <!-- Edit user -->
          <td>
            <form id="deleteUser" action="index.php" method="post">
              <p>Enter the email of the user you want to delete.</p>
              <div id="input"><label>Email: </label><input type="text" id="Delete" name="Delete"></div>
              <input type="submit" name="delete" value="Delete User">
            </form>
          </td> <!-- Delete user -->
       </tr>
       <tr>
         <td>
           <form id="addTime" action="index.php" method="post">
              <p>Enter the desired schedule ID:</p>
              <div id="input"><label>Schedule ID: </label><input type="text" id="sid" name="sid"></div>
              <p>Enter the email of the user you want to edit.</p>
              <div id="input"><label>Email: </label><input type="text" id="userEmail" name="userEmail"></div>
              <input type="submit" name="newTime" value="Add Time">
            </form>
         </td><!-- Add time -->
         <td>
           <form id="editTime" action="index.php" method="post">
              <p>Enter the original schedule ID:</p>
              <div id="input"><label>Schedule ID: </label><input type="text" id="sid1" name="sid1"></div>
              <p>Enter the new schedule ID:</p>
              <div id="input"><label>Schedule ID: </label><input type="text" id="sid2" name="sid2"></div>
              <input type="submit" name="editTime" value="Edit Time">
            </form>
         </td><!-- Edit time -->
         <td>
           <form id="deleteTime" action="index.php" method="post">
              <p>Enter the schedule ID to <b>delete</b>:</p>
              <div id="input"><label>Schedule ID: </label><input type="text" id="sidd" name="sidd"></div>
              <input type="submit" name="deleteTime" value="Delete Time">
            </form>
         </td><!-- Delete time -->
       </tr>
     </table>

     <table id="schedule" >
       <tr>
         <th>Monday</th>
         <th>Tuesday</th>
         <th>Wednesday</th>
         <th>Thursday</th>
         <th>Friday</th>
       </tr>
         <?php
         // Display schedule table
           for ($i=0; $i < 8; $i++) { // For each hour
             echo "<tr>";
             for ($j=0; $j < 5; $j++) {   // For each day
               $row = $result->fetch_assoc();
               if($row["firstN"] != ""){
                 echo "<td style='background-color:red;'>Schedule ID: " . $row["id"]. "<br>" . $row["firstN"]. "<br>" . $row["lastN"]. "<br>" . $row["start"] . "<br>" . $row["end"] . "</td>";
               }
               else{
                 echo "<td style='background-color:green;'>Schedule ID: " . $row["id"]. "<br>" . $row["start"] . "<br>" . $row["end"] . "</td>";
               }
             }
             echo "</tr>";
           }
          ?>
     </table>
   <?php
        $conn->close();
  ?>

</body>
</html>
