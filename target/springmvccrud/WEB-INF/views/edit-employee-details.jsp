<%@page import="com.demo.model.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.demo.model.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.title {
	text-align: center;
}

label {
	font-weight: 600;
}

.main-container {
	width: 100%;
	display: flex;
	justify-content: center;
}

.input {
	height: 30px;
	width: 110%;
	border: 2px solid black;
	border-radius: 5px;
	margin-left: 10px;
}

.table-container {
	border: 1px solid black;
	padding: 50px;
	border-radius: 5px;
}

.submit-button {
	margin: auto;
	width: 110%;
	height: 40px;
}
</style>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Register New Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="https://bootswatch.com/3/paper/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="form-wrap">

			<form action="updateEmployee" method="post">

				<div class="form-group">
				<b>
					<label for="email">Email :</label> <input type="email"
						class="input" name="email" value="${employee.email}" readonly="readonly" />
				</b>
				</div>
				<div class="form-group">
					<label for="name">First Name :</label> <input class="input"
						type="text" name="firstName" value="${employee.firstName}"
						id="emp_name" />
				</div>
				<div class="form-group">
					<label for="name">Last Name :</label> <input class="input"
						type="text" name="lastName" value="${employee.lastName}"
						id="emp_name" />
				</div>

				<div class="form-group">
					<label for="mob">Mobile :</label> <input type="text" name="mobNo"
						value="${employee.mobNo}" class="input" />
				</div>

				<div class="form-group">
					<label for="dob">DOB : </label> <input type="date" name="dob"
						value="${employee.dob}" class="input" />
				</div>

				<div class="form-group">
					<label for="hobbies">Hobbies : </label> <input type="text"
						name="hobbies" value="${employee.hobbies}" class="input" />
				</div>
				<div class="form-group">
					<label for="password">Password : </label> <input type="password"
						name="password" value="${employee.password}" class="input" />
				</div>

				<div id="repeater">
					<div class="repeater-heading">
						<input type="button" value="Add Adresses"
							class="pull-right repeater-add-btn">
					</div>
					<c:choose>

						<c:when test="${address.size()==0}">

							<div class="clearfix"></div>
							<div class="items" data-group="test">
								<!-- Repeater Content -->
								<div class="item-content">
									<div class="form-group">
										<label for="inputEmail" class="col-lg-2 control-label">Street</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="inputStreet"
												name="street[0]" value="" data-name="street">
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail" class="col-lg-2 control-label">City</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="inputCity"
												name="city[0]" value="" data-name="city">
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail" class="col-lg-2 control-label">State</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="inputState"
												name="state[0]" value="" data-name="state">
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail" class="col-lg-2 control-label">Pin
											code</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="inputPinCode"
												name="pinCode[0]" value="" data-name="pincode">
										</div>
									</div>
								</div>
								<!-- Repeater Remove Btn -->
								<div onclick="DeleteAddressServlet class="pull-rightrepeater-remove-btn">
									<input type="submit" value="Remove"
										class="btn btn-danger remove-btn">
								</div>
								<div class="clearfix"></div>
							</div>
						</c:when>
						<c:otherwise>

							<c:forEach var="i" begin="0" end="${address.size()-1}">

								<p>
								<div class="clearfix"></div>
								<!-- Repeater Items -->
								<div class="items" data-group="test">
									<!-- Repeater Content -->
									<div class="item-content">
										<div class="form-group">
											<label for="inputEmail" class="col-lg-2 control-label">Street</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" id="inputStreet"
													name="street[${i}]" value="${address.get(i).getStreet() }"
													data-name="street" />
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-lg-2 control-label">City</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" id="inputCity"
													name="city[${i}]" value="${address.get(i).getCity() }"
													data-name="city">
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-lg-2 control-label">State</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" id="inputState"
													name="state[${i}]" value="${address.get(i).getState() }"
													data-name="state">
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-lg-2 control-label">Pin
												code</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" id="inputPinCode"
													name="pinCode[${i}]" value="${address.get(i).getPinCode()}"
													data-name="pincode">
											</div>
										</div>
									</div>
									<!-- Repeater Remove Btn -->
									<div onClick="deleteAddress?id=${address.get(i).getAddId()} %>"
										class="pull-right repeater-remove-btn">
										<input type="submit" value="Remove"
											class="btn btn-danger remove-btn">
									</div>
									<div class="clearfix"></div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>


				</div>


				<button type="Submit">Update Details</button>
			</form>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<!-- Import repeater  -->
			<script>
	jQuery.fn.extend({
	    createRepeater: function () {
	        var generateId = function (string) {
	            return string
	                .replace(/\[/g, '_')
	                .replace(/\]/g, '')
	                .toLowerCase();
	        };

	        var addItem = function (items, key, fresh = true) {
	            var newEle=items.clone();
	            var itemContent = newEle;
	            var group = itemContent.data("group");
	            var item = itemContent;
	            var input = item.find('input,select,textarea');

	            input.each(function (index, el) {
	                var attrName = $(el).data('name');
	                var skipName = $(el).data('skip-name');
	                if (skipName != true) {
	                    $(el).attr("name", group + "[" + key + "]" + "[" + attrName + "]");
	                } else {
	                    if (attrName != 'undefined') {
	                        $(el).attr("name", attrName);
	                    }
	                }
	                $(el).attr('value', '');
	                

	                $(el).attr('id', generateId($(el).attr('name')));
	                $(el).parent().find('label').attr('for', generateId($(el).attr('name')));
	            })

	            var itemClone = newEle;
	            var removeButton = itemClone.find('.remove-btn');
	            removeButton.attr("value","Remove")
	           removeButton.on("click", function() {
	                $(this).parents('.items').remove();
	                key--;
	            }); 
	            
	            var newItem = $("<div class='items'>" + itemClone.html() + "<div/>");
	            newItem.attr('data-index', key)

	            repeater.append(newItem);
	        };
	        /* find elements */
	        var repeater = this;
	        var items = $("body").find(".items");
	        var key = 0;
	        console.log(key);
	        var addButton = repeater.find('.repeater-add-btn');

	        var removeButton = repeater.find('.remove-btn');
	        
	        removeButton.on("click", function() {
	            $(this).parents('.items').remove();
	            key--;
	        });
	            


	        /* handle click and add items */
	        addButton.on("click", function () {
			if($(items[0])){			
	           addItem($(items[0]), key);
			}
	            key++;
	        }.bind(this));
	    }
	});	
	</script>
			<script>
        /* Create Repeater */
        $("#repeater").createRepeater({
            showFirstItemToDefault: true,
        });
    </script>
		</div>
	</div>
</body>
</html>
