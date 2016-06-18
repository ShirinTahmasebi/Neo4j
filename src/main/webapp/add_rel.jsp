<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/create_new_project_style.css">

        <script src="js/jquery-latest.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
    </head>

    <body>
        <%@ include file="menu.jsp" %> 
        <div id="form-div">
            <form class="form" id="insertRel"  role="form" method="post" action="AddRelController">
                <div class = "container" dir="rtl">
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="userName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="نام کاربر را وارد کنید" id="userName" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">نام کاربر</div>
                    </div>
                    
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="filmName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="نا فیلم را وارد کنید" id="filmName" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">نام فیلم</div>
                    </div>
                    
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="rate" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="امتیاز را وارد کنید" id="rate" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">امتیاز</div>
                    </div>

                    <div class = "row" >
                        <div class = "col-md-4 col-sm-4 col-xs-4 lables">
                            <div class="submit" >
                                <input type="submit" value="اضافه کردن رابطه" id="button-red"/>
                                <div class="ease"></div>
                            </div>
                        </div>
                        <div class = "col-md-4 col-sm-4 col-xs-4"></div>

                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

