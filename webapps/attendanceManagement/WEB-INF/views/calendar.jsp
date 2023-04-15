<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
    <div style="height: 10vh;"></div>
    <div class="d-flex align-items-center justify-content-center p-1">
        <div class="border col-7 p-3">
            <br>
            <h5>4月の勤怠管理</h5>
                <br>
                <div class="row">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" class="text-center">年月日</th>
                                <th scope="col" class="text-center">出勤時間</th>
                                <th scope="col" class="text-center">退勤時間</th>
                                <th scope="col" class="text-center">小計</th>
                                <th scope="col" class="text-center">備考</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            List<Integer> idList = (List<Integer>)request.getAttribute("idList");
                            HashMap<Integer,Integer> daringMap = (HashMap<Integer,Integer>)request.getAttribute("daringMap");
                            HashMap<Integer,Integer> weekMap = (HashMap<Integer,Integer>)request.getAttribute("weekMap");
                            HashMap<Integer,Long> startTimeMap = (HashMap<Integer,Long>)request.getAttribute("startTimeMap");
                            HashMap<Integer,Long> endTimeMap = (HashMap<Integer,Long>)request.getAttribute("endTimeMap");
                            for(Integer id:idList){  
                            %>
                            <tr>
                                <th scope='row'><a href="/attendanceManagement/show?calendar_id=<%= id %>&dating=<%= daringMap.get(id) %>"><%=daringMap.get(id)%></a></th>
                                <%
                                String textStartTime ="";
                                if(startTimeMap.get(id) != null && startTimeMap.get(id) !=0){
                                    textStartTime = startTimeMap.get(id).toString();
                                    textStartTime = textStartTime.substring(0, textStartTime.length()-2) + ":" + textStartTime.substring(textStartTime.length()-2);
                                }
                                %>
                                <td><%= textStartTime %></td>
                                <%
                                String textEndTime ="";
                                if(endTimeMap.get(id) != null && endTimeMap.get(id)!=0){
                                    textEndTime = endTimeMap.get(id).toString();
                                    textEndTime = textEndTime.substring(0, textEndTime.length()-2) + ":" + textEndTime.substring(textEndTime.length()-2);
                                }
                                %>
                                <td><%= textEndTime %></td>
                                <%
                                String subtotal ="";
                                if(endTimeMap.get(id) != null && startTimeMap.get(id) != null && startTimeMap.get(id) !=0 && endTimeMap.get(id) !=0){
                                    Long totalTime= endTimeMap.get(id) - startTimeMap.get(id);
                                    subtotal = totalTime.toString();
                                    subtotal = subtotal.substring(0, subtotal.length()-2) + ":" + subtotal.substring(subtotal.length()-2);
                                }
                                %>
                                <td><%= subtotal %></td>
                                <td></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <br>
        </div>
    </div>
    <div style="height: 10vh;"></div>
</main>
<%@include file="./template/footer.jsp"%>