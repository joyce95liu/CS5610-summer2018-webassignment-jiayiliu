(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn,$updateBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody,$role;
   
   
    var userService = new UserServiceClient();
    $(main);

    function main() {
    	$tbody=$('tbody');
    	
    	$createBtn=$('#createUser');
    	$updateBtn=$('#update1');
    	$removeBtn=$('#wbdv-remove');
    	$editBtn=$('#wbdv-edit');
    	$usernameFld=$('#usernameFld');
		$passwordFld=$('#passwordFld');
		$firstNameFld=$('#firstNameFld');
		$lastNameFld=$('#lastNameFld');
		$role=$('#roleFld');
    	 	
    	$updateBtn.click(updateUser);
    	$createBtn.click(createUser);
    	
    	
    }
       
    
})();
