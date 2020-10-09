<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<br />
<br />
<div class="container">
	<form action="/post?cmd=updateProc" method="post">
	
		<input type="hidden" name="userId" value="${sessionScope.principal.id }" />
		<input type="hidden" name="postId" value="${requestScope.updatePost.id }" />
		<input type="hidden" name="readCount" value="${requestScope.updatePost.readCount }" />
 		조회수 : ${requestScope.updatePost.readCount }<br />
 		
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter Title" name="title"
			required="required"
			value="${updatePost.title }"
			<c:if test="${sessionScope.principal.id != requestScope.updatePost.userId}" var="result1">
				readonly="readonly"
			</c:if> 
			/>
		</div>
		<div class="form-group">
			<textarea id="summernote" name="content">${updatePost.content}</textarea>
		</div>
		<c:if test="${sessionScope.principal.id == requestScope.updatePost.userId}" var="result1">
		   <button type="submit" class="btn btn-primary">수정</button>
		</c:if>
		
	</form>
</div>
<script>
  $('#summernote').summernote({
    tabsize: 2,
    height: 300
  });
  if(${sessionScope.principal.id != requestScope.updatePost.userId}){
  	$('#summernote').summernote('disable');
  }
</script>

<%@ include file="../layout/footer.jsp" %>