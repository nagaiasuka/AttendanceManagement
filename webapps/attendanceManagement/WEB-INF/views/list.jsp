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
                                <th scope="col">メールアドレス</th>
                                <th scope="col">部署</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            List<Integer> idList = (List<Integer>)request.getAttribute("idList");
                            HashMap<Integer,String> nameMap = (HashMap<Integer,String>)request.getAttribute("nameMap");
                            HashMap<Integer,String> mailMap = (HashMap<Integer,String>)request.getAttribute("mailMap");
                            Integer loginId =(Integer) request.getAttribute("loginId");
                            for(Integer id:idList){  
                            %>
                            <tr>
                                <th scope="row"><%= id %></th>
                                <% if(loginId == id){ %>
                                  <td><a href="/attendanceManagement/calendar"><%= nameMap.get(id) %></a></td>
                                  <% }else{ %>
                                    <td><%= nameMap.get(id) %></td>
                                <% } %>
                                <td><%= mailMap.get(id) %></td>
                                <td></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


    </div>

</main>
<%@include file="./template/footer.jsp"%>