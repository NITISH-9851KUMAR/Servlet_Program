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
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body style="background: url(image/img.png); background-size: cover; background-attachment: fixed">


<div class="container">

    <div class="row">

        <div class="col 6 offset-m2">

            <div class="card">

                <div class="card-content">
                    <h3 style="margin-top: 10px;" class="center-align">Register here</h3>
                    <h3 id="msg" class= "center-align"></h3>

                    <div class="form center-align">

                        <form action="Form" method="post" id="myform">
                            <input type="text" name="user_name" placeholder="Enter User Name">
                            <input type="email" name="email" placeholder="Enter email">
                            <input type="password" name="password" placeholder="Enter Password">

                            <div class="file-field input-field"> <!-- Taking file input -->
                                <div class="btn">
                                    <span>File</span>
                                    <input name= "image" type="file">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text">
                                </div>
                            </div>

                            <button type="submit" class="btn">Submit</button>
                            <button type="reset" class="btn">Reset</button>
                        </form>


                    </div>

                    <div class="loader center-align" style="margin-top: 10px; display: none">
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
                        <h5>Please wait...</h5>
                    </div>


                </div>

            </div>

        </div>

    </div>

</div>

<script
        src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous">

</script>

<script>
    $(document).ready(function() {
        console.log("Page is ready....");

        $("#myform").on('submit', function(event){
            event.preventDefault();

            // var f = $(this).serialize();

            let f= new FormData(this);

            console.log(f);
            $(".loader").show();
            $(".form").hide();

            $.ajax({
                url: "Form",
                data: f,
                type: 'post',
                success: function (data, textStatus, jqXHR){
                    console.log(data);
                    console.log("success.......");
                    $(".loader").hide();
                    $(".form").show();
                    if(data.trim()==='done') {
                        $("#msg").html("Successfully Registered");
                        $("#msg").addClass("green-text");
                    }

                    else {
                        $("#msg").html("Something went wrong");
                        $("#msg").addClass("red-text");
                    }
                },
                error: function(jqXHR, textStatus, errorThrown){
                    console.log(jqXHR.responseText); // logs error message from server
                    console.log("error.......");
                    $(".loader").hide();
                    $(".form").show();
                    $("#msg").html("Something went wrong");
                },
                processData: false,
                contentType: false
            })
        })
    })

</script>

</body>
</html>
