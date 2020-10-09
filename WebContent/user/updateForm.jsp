<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br />
<br />
<div class="container">
	<form action="/user?cmd=updateProc" method="post">
	
		<!-- 데이터는 한번에 보내는게 좋다는 강사의 조언  
		updateProc에서 세션에 접속하여 가져 올수도 있지만 여기서 한번에 보내는게 좋다고 한다.-->
		<input type="hidden" value="${sessionScope.principal.id }" name="id">
		
 		<!-- 패스워드 빼고 원래 세션에 값이 다 있기때문에 세션에서 가져와도 되지만(학원에선 세션에서 가져옴)
 		학원 가기전 먼저 만든거라서 일단 그냥 둔다. -->
		<div class="form-group">
			<label >유저 이름:</label> 
			<input type="text" class="form-control" placeholder="Enter User Name" name="username" 
			value="${requestScope.userData.username }"
			readonly="readonly"  
			required="required"/> <!-- readonly = 변경을 못하게 막음 -->
		</div>
		<div class="form-group">
			<label >패스워드:</label><!-- 패스워드는 안가져오는걸로 --> 
			<input type="password" class="form-control" placeholder="Enter password" name="password" 
			value=""
			required="required"/> <!-- required 비어있으면 안됨 -->
		</div>

		<div class="form-group">
			<label >이메일:</label> 
			<input type="email" class="form-control" placeholder="Enter email" name="email" 
			value="${requestScope.userData.email }"
			required="required" />
		</div>

		<div class="form-group">
			<label >주소:</label> 
			<button type="button" class="btn btn-warning float-right" >주소검색</button>
			<input type="text" class="form-control" placeholder="Enter 주소" name="address" 
			value="${requestScope.userData.address }"
			required="required"/>
		</div>

		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>