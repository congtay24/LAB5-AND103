<?php
$s="localhost"; $u="root"; $p=""; $db="a3";
$con = new mysqli($s, $u, $p, $db);
$MaSP=$_GET['MaSP'];
$TenSP=$_GET['TenSP'];
$MoTa=$_GET['MoTa'];
$sql = "INSERT into SanPham(MaSP,TenSP,MoTa) VALUES ('$MaSP','$TenSP','$MoTa')";
if($con->query($sql)===true){
    echo "Them thanh cong";
}
else{  
    echo "Loi".$con->error;
}

$con->close();

//http://localhost/000/20240720/insert1.php?MaSP=SP22aaaa22&TenSP=san pham 22â22&MoTa=mo ta san pham33â33
