<?php
$res=array();
$s="localhost"; $u="root"; $p=""; $db="a3";
$con=new mysqli($s,$u,$p,$db);
$MaSP=$_POST['MaSP'];
$TenSP=$_POST['TenSP'];
$MoTa=$_POST['MoTa'];
$sql="INSERT into SanPham (MaSP,TenSP,MoTa) VALUES ('$MaSP','$TenSP','$MaSP')";
if($con->query($sql)===TRUE){
    $res['success']=1;
    $res['message']="insert thanh cong";
    echo json_encode($res);
}
else{
    $res['success']=0;
    $res['message']="insert that bai";
    echo json_encode($res);
}
$con->close();
//http://localhost/000/20240720/insert2.php?MaSP=SPP3&TenSP=Sản phẩm đc thêm&MoTa=congtay24zz