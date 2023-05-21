<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIUrl" value="/api/admin/v1/books"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sách</title>
</head>
<body>
	<div id="content">
		<form id="formAddBook">
			<h2 class="text-center mb-3">Thêm sách của bạn</h2>
			
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Thể loại</label>
				<div class="col-sm-10">
					<select id="category" name="categoryId" class="form-select">
						 <option value="">Chọn loại sách</option>
						 <c:forEach var="item" items="${categories}">
						 	<option value="${item.id}">${item.name}</option>
						 </c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label">Tên sách</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Tên sách">
				</div>
			</div>
			<div class="form-group row">
				<label for="author" class="col-sm-2 col-form-label">Tác giả</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="author" name="author"
						placeholder="Tác giả">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="images" class="col-sm-2 col-form-label">Hình ảnh</label>
				<div class="col-sm-10">
					<input class="form-control" type="file" id="images" multiple="multiple">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="price" class="col-sm-2 col-form-label">Giá</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" name="price" id="price" required="required"
						placeholder="Gía">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="description" class="col-sm-2 col-form-label">Mô tả</label>
				<div class="col-sm-10">
					<textarea name="description" class="w-100" rows="6"></textarea>
				</div>
			</div>
		</form>
		
		<button type="button" class="btn btn-primary mb-2" id="btnAddBook">Gửi</button>
		
	</div>
	
	<script type="text/javascript">
		const btnAddBook = document.getElementById('btnAddBook')
		
		btnAddBook.onclick = function(e) {
			const formData = new FormData()
			
			const formAddBook = document.getElementById('formAddBook');

			// convert formAddBook data to a json object
			const values = {}
			for(const pair of new FormData(formAddBook)) {
				values[pair[0]] = pair[1]
			}
			const json = JSON.stringify(values)

			
			// add the json data to the FormData object
			formData.append("data", json)
			
			
			// add the files to the FormData object
			const files = document.getElementById("images").files
			for (const file of files) {
				formData.append("images", file);
			}

			// call api
			addBook(formData)
		}

		function addBook(formData) {
			$.ajax({
				type: 'POST',
				url: '${APIUrl}',
				data: formData,
				contentType: false,
				processData: false,
				dataType: 'json',
				success: function(result) {
					console.log(result)
				},
				error: function(error) {
					console.log(error)
				}
			});
		}
		
	</script>
</body>
</html>