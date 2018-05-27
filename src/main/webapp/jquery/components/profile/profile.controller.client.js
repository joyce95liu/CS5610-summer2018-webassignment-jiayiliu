(function(){
$(init);

var $username;
var $role;
var $email;
var $dateOfBirth;
var $phone;

var $updateBtn;
var $logoutBtn;
var userService = new UserServiceClient();

function init(){
	
	$username=$('#username');
	$role=$('#role');
	$email=$('#email');
	$dateOfBirth=$('#dateofbirth');
	$phone=$('#phone');

	
	$updateBtn=$("#updateBtn")
	.click(updateUser);
	
	$logoutBtn=$('#logoutBtn').click(logout);
	
}

function updateUser(){
	
}

function logout(){
	
}

})();