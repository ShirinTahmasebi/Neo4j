<html>
    <head>
        <link rel="stylesheet" href="css/menu_style.css">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    </head>
    <body style= "margin:0">
        <div id = "mySidenav" class = "sidenav">
            <a href="javascript:void(0)" class="closebtn menu-item-line" onclick="closeNav()">x</a>
            <a href="add_user.jsp" class="firstitem menu-item-line">افزودن&nbsp;کاربر</a>
            <a href="add_film.jsp" class="seconditem menu-item-line">افزودن&nbsp;فیلم</a>
            <a href="add_rel.jsp" class="thirditem menu-item-line">افزودن&nbsp;رابطه</a>
            <a href="relations_list.jsp" class="forthitem menu-item-line">لیست&nbsp;روابط</a>
            <a href="users_list.jsp" class="fifthitem menu-item-line">لیست&nbsp;کاربران</a>
            <a href="film_list.jsp" class="sixthitem menu-item-line">لیست&nbsp;فیلمها</a>

        </div>
        <div id="header">
            <span style="box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24); font-size:15px;cursor:pointer;position: absolute;right:10px;top:5px; border:1px solid black; margin: 5px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#ffffff;" onclick="openNav()">
                <img src="img/menu-black.png"/> 
            </span>
            <span dir="rtl" style="cursor:pointer;position: absolute;right:100px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;">

            </span>
            <span style="cursor:pointer;position: absolute;left:10px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;">
                <a href="first_page.jsp" id="logo"></a>
            </span>
            <span id="header_text" style="cursor:pointer;position: absolute;left:110px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;" onclick="openLink();">پروژه درس موضوعات پیشرفته :) </span>
        </div>
        <!-- Slidebars -->
        <script src="js/menu_functions.js"></script>
    </body>
</html>