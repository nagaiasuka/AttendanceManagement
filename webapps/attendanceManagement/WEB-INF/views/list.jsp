<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
    <div style="height: 10vh;"></div>

    <div class="d-flex align-items-center justify-content-center p-1" style="height: 85vh;">
        <div class="border col-7 p-3">
            <br>
            <h2>従業員一覧</h2>
            <br>
            <div class="row">
                <div class="col-md">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">氏名</th>
                                <th scope="col">部署</th>
                                <th scope="col">メールアドレス</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Mark</td>
                                <td>Otto</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Jacob</td>
                                <td>Thornton</td>
                            </tr>

                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Mark</td>
                                <td>Otto</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Jacob</td>
                                <td>Thornton</td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row center-block text-center p-3">
                <div class="col-1">
                </div>
                <div class="col-5">
                    <button type="button" class="btn btn-outline-secondary btn-block">閉じる</button>
                </div>
                <div class="col-5">
                    <button type="button" class="btn btn-outline-primary btn-block">新規登録</button>
                </div>
            </div>
            <br>
        </div>


    </div>

</main>
<%@include file="./template/footer.jsp"%>