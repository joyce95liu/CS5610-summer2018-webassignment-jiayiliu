function UserServiceClient() {
	this.url = 'https://webdev-summer-assignment.herokuapp.com/api/user';
	this.registerurl='https://webdev-summer-assignment.herokuapp.com/api/register';
	this.loginurl='https://webdev-summer-assignment.herokuapp.com/api/login';
	this.profileurl='https://webdev-summer-assignment.herokuapp.com/api/profile';
	this.logouturl='https://webdev-summer-assignment.herokuapp.com/api/logout';
	this.createUser = createUser;
	this.findAllUsers = findAllUsers;
	this.deleteUser = deleteUser;
	this.findUserById=findUserById;
	this.updateUser=updateUser;
	this.login=login;
	this.register=register;
	this.loadprofile=loadprofile;
	this.updateprofile=updateprofile;
	this.logout=logout;
		
	var self=this;
		
	function findAllUsers(){
		return fetch(self.url)
		.then(function(response) {
			return response.json();
		});
	}
 
	function createUser(user){
		return fetch(self.url,{
			method:'post',
			body:JSON.stringify(user),
			headers:{
				'content-type':'application/json'
			}
		});
	}
	
	function findUserById(userId){
		return fetch(self.url+'/'+userId)
		.then(function(response) {
			return response.json();
		});
	}
	
	
	function deleteUser(userId) {
		return fetch(self.url + '/' + userId, {
			method: 'delete'
		})	
	}
	
	function updateUser(userId,user){
		return fetch(self.url+'/'+userId,{
			method:'put',	
			body:JSON.stringify(user),
			headers:{
				'content-type':'application/json'
			}
		})
	}
		
	function login(user){
		return fetch(self.loginurl,{
		method:'post',
		credentials:'same-origin',
		body:JSON.stringify(user),
		headers:{
			'content-type':'application/json'
		}
	})
	
	.then(response => response.json())
	.then(function(response){
		return response;
	})
	.catch(function(error) {
		return null;
	});

}
	
	function register(user){
		return fetch(self.registerurl,{
			method:'post',
			credentials:'same-origin',
			body:JSON.stringify(user),
			headers:{
				'content-type':'application/json'
			}
		})
		
		.then(response => response.json())
		.then(function(response){
			return response;
		})
		.catch(function(error) {
			return null;
		});
	}
	
	
	function loadprofile(){  
		return fetch(self.profileurl,{
			credentials:'same-origin',
		})
		
		.then(response => response.json())
		.then(function(response){
			return response;
		})
		.catch(function(error) {
			return null;
		});
	}
	
		
	function updateprofile(user){
		return fetch(self.profileurl,{
			method:'put',
			credentials:'same-origin',
			body:JSON.stringify(user),
			headers:{
				'content-type':'application/json'
			}
		});
	}

	function logout(){
		return fetch(self.logouturl,{
			method:'post',
			credentials:'same-origin'
		})
	}
	
		
	
}