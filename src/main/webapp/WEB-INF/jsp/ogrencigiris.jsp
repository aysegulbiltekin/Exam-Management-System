<%@ page import="com.example.sinavyonetimsistemi.Models.Students" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sınav Yönetim Sistemi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid d-flex justify-content-between">
        <a class="navbar-brand" href="#">Sınav Yönetim Sistemi</a>
        <a href="/ogrenci/kayit" class="btn btn-success">Kayıt Ol</a>
    </div>
</nav>
<div style="width: 500px; margin-left: auto; margin-right: auto; margin-top: 100px;">
    <h3>Öğrenci Girişi</h3>
    <form action="/ogrenci/giris" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Kullanıcı Adı</label>
            <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Parola</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">Giriş Yap</button>

        <%
            String status = request.getParameter("durum");
            if(status != null && status.equals("bulunamadi")) {
        %>
        <p class="error">Kullanıcı bulunamadı !</p>
        <% }
        else if (status != null && status.equals("yanlis")) {
        %>
        <p class="error">Yanlış parola !</p>
        <% } %>
    </form>

    <a href="/personel/giris" class="btn btn-warning mt-5">Personel Girişi</a>
    <a href="/admin/giris" class="btn btn-success mt-5">Yönetici Girişi</a>
</div>
</body>
</html>