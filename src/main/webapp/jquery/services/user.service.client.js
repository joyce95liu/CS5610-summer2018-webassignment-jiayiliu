function UserServiceClient() {
	this.url = '/api/user';
	this.createUser = createUser;
	this.findAllUsers = findAllUsers;
	this.deleteUser = deleteUser;
	this.findUserById=findUserById;
	this.updateUser=updateUser;
	this.login=login;
	
	
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
		return fetch('http://localhost:8080/api/login',{
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
	
	
	
	
}