<?php
    $con = mysqli_connect("localhost", "id188811_user", "teiser2016", "id188811_teiser2016");
    
   
   
    $char_id= $_POST["char_id"];
    $username= $_POST["username"];

    $statement = mysqli_prepare($con, "UPDATE users SET char_id = '$char_id'   WHERE username= $username ");
    mysqli_stmt_bind_param($statement, "is", $char_id,  $username);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>