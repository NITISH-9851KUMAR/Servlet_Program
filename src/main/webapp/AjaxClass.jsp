<%--
  Created by IntelliJ IDEA.
  User: nitis
  Date: 15-05-2025
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{
            background-color: #3c3636;
        }
    </style>
    <title>Registration Form</title>
    <!-- Compiled and minified CSS -->
    <!-- through this link all related materialize css include in my jsp  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <!-- Through this src file all related to materialize JavaScript file include -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>


<div class="container">

    <div class="row">

        <div class="col m7 offset-m2">
            <div class="card">

                <div class="card-content" >

                    <!-- Now form will Start, write all function such as form, loader class etc-->
                    <h5 style="margin-top: 8px" class="center-align">Register here</h5>
                    <h5 id="msg" class="center-align"></h5>

                   <div class="form-container "> <!-- Form Container -->

                        <form action="Form2" method="post" id="myForm"> <!-- From Start from there -->

                            <input type="text" placeholder="Username" name="user-name">
                            <input type="email" placeholder="Email ID" name="email">
                            <input type="password" placeholder="Password" name="pass">
                            <button type="submit" class="btn" style="margin-left: 100px;">Submit</button>
                            <button type="reset" class="btn">Reset</button>

                        </form>
                   </div> <!-- Under the card-content -->

                    <!-- Loader class -->

                    <div class="loader center-align" style="margin-top: 10px; display: none"> <!-- under the card content -->


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
            </div>
        </div>

    </div>

</div> <!-- Container class -->


<script
        src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous">
</script> <!-- Standard Library for JavaScript -->

<!-- JavaScript Program -->

<script>
    $(document).ready(function(){ // Its initialize the Script code

        $("#myForm").on('submit', function(event){
            event.preventDefault(); // Its prevent the form to go on next server

            let f= new FormData(this); // f store all data
            $(".loader").show();
            $(".form-container").hide();

            $.ajax({
                url: "Form2",
                data: f,
                type: 'post',
                processData: false,
                contentType: false,

                success: function(data, textStatus, jqXHR){ // form will successfully submit it will execute
                    if(data.trim()==="success"){
                        $(".form-container").show();
                        $(".loader").hide();
                        $("#msg").text("Registered Successfully");
                        $("#msg").addClass("green-text");
                    }
                    else {
                        $(".form-container").show();
                        $(".loader").hide();
                        $("#msg").text("Something went Wrong");
                        $("#msg").addClass("red-text");
                    }
                },
                error: function(data){ // others wise it will execute
                    $(".form-container").show();
                    $(".loader").hide();
                    $("#msg").text("Something went Wrong").addClass("red-text");
                }

            })
        })
    })
</script>


</body>
</html>
