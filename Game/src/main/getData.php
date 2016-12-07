<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $user_id  = $_GET['user_id'];
 
 require_once('dbConnect.php');
 
 $sql = "SELECT USERNAME,PASSWORD,MAIL,CHAR_ID FROM users WHERE user_id='".$user_id."'";
 
 $r = mysqli_query($con,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
 "username"=>$res['username'],
 "password"=>$res['password'],
 "mail"=>$res['mail'],
 "char_id"=>$res['char_id']
 )
 );
 
 echo json_encode(array("result"=>$result));
 
 mysqli_close($con);
 
 }
 
 ?>