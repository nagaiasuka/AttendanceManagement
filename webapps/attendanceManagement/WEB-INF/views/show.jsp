<%@include file="./template/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ page import="java.util.*" %>
<main>
  <div style="height: 10vh;"></div>

  <div class="d-flex align-items-center justify-content-center p-1" style="height: 85vh;">
    <div class="border col-7 p-3">
      <br>
      <h2>登録・更新</h2>
      <br>
      <div class="row">
        <%
        String dating = (String) request.getAttribute("dating");
        String calendar_id = (String) request.getAttribute("calendar_id");
        Long startTime = (Long) request.getAttribute("startTime");
        Long endTime = (Long) request.getAttribute("endTime");
        %>
        <form action="/attendanceManagement/workingTimeResist" method="post">
          <div class="form-group p-2">
            <label>日付</label>
            <input type="text" class="form-control" value="<%= dating %>" disabled>
            <input type="hidden" name="dating" class="form-control" value="<%= dating %>">
            <input type="hidden" name="calendar_id" class="form-control" value="<%= calendar_id %>">
          </div>
          <div class="form-group p-2">
            <label>出勤時間</label>
            <%
            String formatStartTime ="";
            if(startTime != null){
               formatStartTime = String.format("%02d:%02d", startTime / 100, startTime % 100);
            }
            %>
            <input name="startTime" type="time" class="form-control" <% if(formatStartTime != ""){ %> value="<%=formatStartTime%>"<%}%>>
          </div>
          <div class="form-group p-2">
            <label>退勤時間</label>
            <%
            String formatEndTime ="";
            if(endTime != null){
              formatEndTime = String.format("%02d:%02d", endTime / 100, endTime % 100);
            }
            %>
            <input name="endTime" type="time" class="form-control" <% if(formatEndTime != ""){ %> value="<%=formatEndTime%>"<%}%>>
          </div>
          <div class="form-group p-2">
            <label>備考</label>
            <input type="text" class="form-control">
          </div>
          <div class="row justify-content-center">
           
            <div class="col-3">
              <a href="/attendanceManagement/calendar">
                <button type="button" class="btn btn-outline-secondary btn-block">戻る</button>
              </a>
            </div>
            <div class="col-3">
              <a href="/attendanceManagement/workingTimeDelete?calendar_id=<%= calendar_id %>&dating=<%= dating %>">
                <button type="button" class="btn btn-danger">削除</button>
              </a>
            </div>
            <div class="col-3">
              <button type="submit" class="btn btn-outline-primary btn-block">登録・更新</button>
            </div>
          </div>
        </form>
      </div>
      <br>
    </div>


  </div>

</main>
<%@include file="./template/footer.jsp"%>