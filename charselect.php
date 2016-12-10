<?php
    $con = mysqli_connect("localhost", "id188811_user", "teiser2016", "id188811_teiser2016");
    
   
   
    $char_id = $_POST["char_id"];
    

    $statement = mysqli_prepare($con, "INSERT INTO users (char_id) VALUES (?)");
    mysqli_stmt_bind_param($statement, "s", $char_id);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>