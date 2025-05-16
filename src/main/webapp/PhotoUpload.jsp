<%--
  Created by IntelliJ IDEA.
  User: nitis
  Date: 13-05-2025
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>

</head>

<body>

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<div class="container">

    <div class="row">

        <div class="col m7 offset-m2 ">

            <div class="card">

                <div class="card-content">
                    <!-- start writing code from there  -->

                    <div class="form-container" >
                        <h5 class="center-align" style="margin-top: 5px;">Registered Here</h5>
                        <h5 id="msg" class="center-align"></h5>

                        <form action="photo-upload" method="post" id="myForm">
                            <input type="text" name="name" placeholder="user">
                            <input type="email" name="email" placeholder="Email ID">
                            <input type="password" name="pass" placeholder="Password">
                            <div class="file-field input-field"> <%-- File Input --%>
                                <div class="btn">
                                    <span>File</span>
                                    <input type="file" name="fileInput">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text">
                                </div>
                            </div>

                            <button type="submit" class="btn" style="margin-left: 100px;">Sign UP</button>
                            <button type="reset" class="btn">Reset</button>
                        </form>
                    </div> <!-- form container -->

                    <div class="loader-container center-align" style="margin-top: 5px; display: none"> <!-- Loader class -->

                            <div class="preloader-wrapper big active">
                                <div class="spinner-layer spinner-blue">
                                    <div class="circle-clipper left">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="gap-patch">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="circle-clipper right">
                                        <div class="circle"></div>
                                    </div>
                                </div>

                                <div class="spinner-layer spinner-red">
                                    <div class="circle-clipper left">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="gap-patch">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="circle-clipper right">
                                        <div class="circle"></div>
                                    </div>
                                </div>

                                <div class="spinner-layer spinner-yellow">
                                    <div class="circle-clipper left">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="gap-patch">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="circle-clipper right">
                                        <div class="circle"></div>
                                    </div>
                                </div>

                                <div class="spinner-layer spinner-green">
                                    <div class="circle-clipper left">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="gap-patch">
                                        <div class="circle"></div>
                                    </div>
                                    <div class="circle-clipper right">
                                        <div class="circle"></div>
                                    </div>
                                </div>
                            </div>

                            <h5>Please Wait...</h5>
                        </div> <!-- Loader class -->

                </div> <!-- card-content class -->

            </div> <!--  card class -->

        </div> <!-- col decide class -->

    </div> <!-- row under container -->
</div> <!-- Container Class -->

<script
        src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous">

</script>

<script>
$(document).ready(function(){

    $("#myForm").on('submit', function(event){
        event.preventDefault();

        let f= new FormData(this);
        $(".form-container").hide();
        $(".loader-container").show();

        $.ajax({
            url: "photo-upload",
            data: f,
            method: 'post',
            processData: false,
            contentType: false,

            success: function(data, textStatus, jqXHR){
                if(data.trim()==="success"){
                    $("#msg").text("Successfully Registered").addClass("green-text");
                    $(".form-container").show();
                    $(".loader-container").hide();
                }
                else{
                    $("#msg").text("Something went wring").addClass("red-text");
                    $(".form-container").show();
                    $(".loader-container").hide();
                }
            },
            error: function(data){
                $("#msg").text("Something went wring").addClass("red-text");
                $(".form-container").show();
                $(".loader-container").hide();
            }
        })<%-- Ajax --%>

    }) <%-- Form --%>
})<%-- Documnet --%>
</script>

</body>
</html>
