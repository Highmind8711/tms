<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<title>Insert title here</title>
</head>
<body>
<table id="example" class="display" cellspacing="0" width="100%">

</table>
</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
    $('#example').dataTable( {
        "processing": true,
      	//开启服务器模式
        "serverSide": true,
        "ajax": "./menusbypage",
       	columns: [
               { data: 'id' },
               { data: 'name' }
           ]
    } );
} );
</script>
</html>