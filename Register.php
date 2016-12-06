<?php
    $con = mysqli_connect("localhost", "id188811_user", "teiser2016", "id188811_teiser2016");
    
   
   
    $username = $_POST["username"];
    $password = $_POST["password"];
    $mail= $_POST["mail"];

    $statement = mysqli_prepare($con, "INSERT INTO users (username, password,mail) VALUES (?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sss", $username,  $password,$mail);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>