<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sınav Yönetim Sistemi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/8bbf8c5eb9.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid d-flex justify-content-between">
        <a class="navbar-brand" href="#">Sınav Yönetim Sistemi</a>
        <a class="btn btn-danger" href="/personel/cikis">Çıkış Yap</a>
    </div>
</nav>

<div class="d-flex align-items-start" style="margin-left: 50px; margin-top: 50px;">
    <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="width: 200px;  border: 1px solid darkgrey;">
        <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">Sınav Sonuçları</button>
        <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false">Sınavlar</button>

    </div>
    <div class="tab-content" id="v-pills-tabContent" style="width: 100%;">
        <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
            <a href="/personel/sonucekle" class="btn btn-success">Ekle</a>
            <table class="table" style="width: 100%;">
                <thead>
                <tr class="text-center">
                    <th scope="col">Sınav Adı</th>
                    <th scope="col">Öğrenci</th>
                    <th scope="col">Puan</th>
                    <th scope="col">İşlemler</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${sonuclar}" var="item">
                    <tr class="text-center">
                        <td>${item.exam.name}</td>
                        <td>${item.student.name} ${item.student.surname}</td>
                        <td>${item.note}</td>
                        <td>
                            <a href="/personel/sonucguncelle?id=${item.id}" class="btn btn-primary me-2"><i
                                    class="far fa-edit me-2"></i>Güncelle</a>
                            <a href="/personel/sonucsil?id=${item.id}" class="btn btn-danger"><i
                                    class="far fa-trash-alt me-2"></i>Sil</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
            <a href="/personel/sinavekle" class="btn btn-success">Ekle</a>
            <table class="table" style="width: 100%;">
                <thead>
                <tr class="text-center">
                    <th scope="col">#ID</th>
                    <th scope="col">Sınav Adı</th>
                    <th scope="col">Sınav Tarihi</th>
                    <th scope="col">İşlemler</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sinavlar}" var="item">
                    <tr class="text-center">
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.date}</td>
                        <td>
                            <a href="/personel/sinavguncelle?id=${item.id}" class="btn btn-primary me-2"><i
                                    class="far fa-edit me-2"></i>Güncelle</a>
                            <a href="/personel/sinavsil?id=${item.id}" class="btn btn-danger"><i
                                    class="far fa-trash-alt me-2"></i>Sil</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>

    </div>
</div>
</body>
</html>