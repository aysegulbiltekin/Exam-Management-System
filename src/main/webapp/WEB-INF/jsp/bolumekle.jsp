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
        <a class="btn btn-danger" href="/admin/cikis">Çıkış Yap</a>
    </div>
</nav>

<div style="width: 500px; margin-top: 50px; margin-left: 50px;">
    <form action="/admin/bolumekle" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Bölüm Adı</label>
            <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <button type="submit" class="btn btn-primary">Kaydet</button>
    </form>
</div>
</body>
</html>