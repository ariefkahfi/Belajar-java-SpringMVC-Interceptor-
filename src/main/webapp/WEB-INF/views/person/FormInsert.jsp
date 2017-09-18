<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Insert Person</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>

    <style>

    </style>

<body>


    <springForm:form modelAttribute="person">
        <table>
            <tr>
                <td>Nama</td>
                <td><springForm:input path="nama" id="nama"/></td>
                <td id="err-nama" class="error"></td>
            </tr>
            <tr>
                <td>Alamat</td>
                <td><springForm:input path="alamat" id="alamat"/></td>
                <td id="err-alamat" class="error"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Insert Data Person"/></td>
            </tr>
        </table>
    </springForm:form>


</body>
    <script>
        $(document).ready(function () {
            $('form').submit(function () {


                var nama = $('#nama').val();
                var alamat = $('#alamat').val();


                if(nama==='' || alamat===''){

                    if(nama===''){
                      $('#err-nama').text('Field Nama Masih Kosong');
                    }else{
                      $('#err-nama').text('');
                    }

                    if(alamat===''){
                      $('#err-alamat').text('Field Alamat masih kosong');
                    }else{
                      $('#err-alamat').text('');
                    }

                    return false;
                }else{
                   $('form').attr('method','POST');
                   $('form').attr('action','insert');
                }

            });
        });
    </script>

</html>
