<?php
    $con = mysqli_connect("localhost", "id188811_user", "teiser2016", "id188811_teiser2016");
    
    $char_id = $_POST["char_name"];
  
    $statement = mysqli_prepare($con, "SELECT * FROM charoption  WHERE char_name = ?");
    mysqli_stmt_bind_param($statement, "s", $char_name);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $char_id, $char_name, $char_lastname, $profession, $age);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
	$response["char_id"] =  $char_id;  
        $response["char_name"] = $char_name;
        $response["age"] = $age;
        $response["char_lastname"] = $char_lastname;
        $response["profession"] = $profession;
    }
    
    echo json_encode($response);
?>