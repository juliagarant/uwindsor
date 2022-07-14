<!--
COMP 3340 A4
July 14 2021
Julia Garant
 -->

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="author" content="Julia Garant">

    <title>A4 COMP3340</title>
    <link rel="stylesheet" href="style.css">

  </head>
  <body>

    <?php $users = $_POST["users"];

        // After form has been submitted with valid entries
          if (!empty($_POST["fname"])){
            $fname = $_POST["fname"];
            $age = $_POST["age"];
            $usercount = $_POST["usercount"];

            if(!empty($_POST["age"])){
              if($age < 14){
                // To continue the age array w/o this underage value
                if (!empty($_POST["users"])){
                  $users = explode(",",$_POST["users"]);
                }else{
                  $users = array($age);
                }
                // To continue the lang array w/o this underage opinion
                if (!empty($_POST["langList"])){
                  $langList = explode(",",$_POST["langList"]);
                }else{
                  $langList = array();
                }
              ?>
                <script type="text/javascript">
                    alert("You do not qualify for this form.\nPlease exit this window.");
                </script>
              <?php
              } // close if age <14

              else{ // over 14
                $usercount++;
                // --------------------------------------------------------------
                // Tracking the ages of users between submits
                if (!empty($_POST["users"])){
                  $users = explode(",",$_POST["users"]);
                  array_push($users, $age);
                }
                else{
                  $users = array($age);
                }
                // --------------------------------------------------------------
                // Grabbing the languages from the user
                $lang = $_POST["lang"];
                $arrayLang = array();
                $tok = strtok($lang, ",");

                while ($tok !== false) {
                    array_push($arrayLang, trim(strtolower($tok))); // auto lowercase, no whitespace
                    $tok = strtok(",");
                }
                $arrayUnique = array_unique($arrayLang);  // no duplicates

                // To get count of langs
                if (!empty($_POST["langList"])){
                  $langList = explode(",",$_POST["langList"]);
                  foreach ($arrayUnique as $key) {
                    array_push($langList, $key);
                  }
                }
                else{
                  $langList = array();
                  foreach ($arrayUnique as $key) {
                    array_push($langList, $key);
                  }
                }
                // --------------------------------------------------------------

              } // MAIN ELSE

            } // if age !Empty
            else{
              ?>
              <script type="text/javascript">
              alert("Age must be filled out.");
              </script>
              <?php
            } // if age is empty

          }// if first name is NOT empty

        ?>

        <!-- Display form -->
            <form id="mainForm" action="index.php" method="post">
              <!-- Adding 'required' means there must be input in these sections -->
              <div class = "form" ><label>First Name: </label><input type="text" name="fname" required></div>
              <div class = "form" ><label>Last Name: </label><input type="text" name="lname" required></div>

              <!-- Added in php for red astrix to appear -->
              <div class = "form" ><label><?php if (!empty($_POST["age"])) { if($_POST["age"] < 14){ echo "<label style='color: red'>*</label>"; } } ?>Age: </label><input type="number" name="age" min="1" max="119" ></div>

              <div class = "form" ><label><textarea name="lang" rows="8" cols="80"></textarea></label></div>

              <!-- Enabled for user count -->
              <div><input type="hidden" name="users" value="<?php echo (empty($users))?"":implode(",", $users); ?>"></div>
              <div><input type="hidden" name="usercount" value="<?php echo (empty($users))?"0":count($users); ?>"></div>

              <!-- Enabled for languages count -->
              <div><input type="hidden" name="langList" value="<?php echo (empty($langList))?"":implode(",", $langList); ?>"></div>

              <input type="submit" value="Submit Form">
            </form>

            <?php
            // Results
            // Number of participants:
            echo "<div id='results'>Number of participants: $usercount";
            // Average age of participants:
            foreach ($users as $key) {
              $avg += $key;

              if($key < 18){
                $minor++;
              }
              if($key >= 65){
                $elder++;
              }
            }
            $avg = round($avg/$usercount,2);
            echo "<br><br>Average age of participants: $avg";

            // Number of participants under 18:
            echo "<br><br>Number of participants under 18: $minor";

            // Number of participants 65 and over: ___
            echo "<br><br>Number of participants 65 and over: $elder";

            // Histogram of languages
            echo "<br>";
            $histList = array_unique($langList);
            $histCount = array();
            foreach($histList as $hist){
              array_push($histCount, count(array_keys($langList, $hist)));
            }
            $i = 0;
            foreach ($histList as $key) {
              echo "<br>$key | ";
              for ($j=0; $j < round(($histCount[$i]/$usercount)*10, 0, PHP_ROUND_HALF_UP ) ; $j++) {
                echo "<label class ='ticks'>▉</label>";
              }
              echo " % ";
              echo round(($histCount[$i]/$usercount)*100, 0, PHP_ROUND_HALF_UP );
              $i++;
            }
            echo "</div><br>";
            ?>

  </body>
</html>
