<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>
 <h1 th:text="${message}" style="text-align: center; padding-top: 40px"></h1>
<form action="addEmployee" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="first-name"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="firstName" id="firstName" th:field="*{firstName}" required>
	<p th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}" class="alert alert-danger"></p>


    <label for="last-name"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="lastName" id="lastName" required>

  	<label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" th:field="*{password}" required>
    <p th:if="${#fields.hasErrors('password')}" th:errors="*{password}" class ="alert alert-danger"></p>

    <label for="psw-repeat"><b>Confirm Password</b></label>
    <input type="password" placeholder="Repeat Password" name="confirmPassword" id="confirmPassword" required>

	<label for="mob"><b>Mobile No</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="mobNo" id="mobNo" required>
	
	<label for="dob"><b>DOB</b></label>
    <input type="date" placeholder="Enter DOB" name="dob" id="dob" required>
    <br>

	<label for="hobbies"><b>Hobbies</b></label>
    <input type="text" placeholder="Enter Hobbies" name="hobbies" id="hobbies" required>
	
	<br>
	<label for="email"><b>Email</b></label>
    <input type="email" placeholder="Enter Email" name="email" id="email" required>

	<br>
	<label for= "admin" class="admin-label" > Admin :</label>
	<input class = "radioBtn" type = "radio" id="yes" name = "isAdmin" value = "1">
	<label class = "radiobtn-Label" for = "yes">Yes</label>
	<input class = "radioBtn" type = "radio" id="no" name = "isAdmin" value = "0">
	<label class = "radiobtn-Label" for = "no">No</label>
      <hr>
      <div id="repeater">
					<!-- Repeater Heading -->
					<div class="repeater-heading">
						<input type="button" value="Add Address"
							class="pull-right repeater-add-btn" />

					</div>
					<div class="clearfix"></div>
					<!-- Repeater Items -->
					<div class="items" data-group="test">
						<!-- Repeater Content -->
						<div class="item-content">
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Street</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputStreet"
										placeholder="enter Street" data-name="street">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">City</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputCity"
										placeholder="enter city" data-name="city">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">State</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputState"
										placeholder="enter state" data-name="state">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Pin
									code</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputPinCode"
										placeholder="enter pincode" data-name="pincode">
								</div>
							</div>
						</div>
						<!-- Repeater Remove Btn -->
						<div class="pull-right repeater-remove-btn">
							<input type="button" value="Remove"
								class="btn btn-danger remove-btn" />
							</button>
						</div>
						<div class="clearfix"></div>
					</div>

				</div>
      
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="index">Sign in</a>.</p>
  </div>
</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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

</body>
</html>
