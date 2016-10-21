var app = angular.module('myApp', ['ngResource']);
app.factory('User', ['$resource', function ($resource) {
    return $resource('http://localhost:8070/Qeep/user/:id', {id: '@id'},
	{
		updateUser: {method: 'PUT'}
	}
    );
}]);
app.controller('UserController', ['$scope', 'User', function($scope, User) {
    var ob = this;
    ob.users=[];
    ob.user = new User(); 
    ob.fetchAllUsers = function(){
        ob.users = User.query();
    };
    ob.fetchAllUsers();
    ob.addUser = function(){
	console.log('Inside save');
	if($scope.userForm.$valid) {
	  ob.user.$save(function(user){
	     console.log(user); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllUsers();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editUser = function(id){
	    console.log('Inside edit');
            ob.user = User.get({ UserId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateUserDetail = function(){
	console.log('Inside update');
	if($scope.userForm.$valid) {
    	   ob.user.$updateUser(function(user){
    		console.log(user); 
		ob.updatedId = user.id;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllUsers();
           });
	}
    };	
    ob.deleteUser = function(id){
	    console.log('Inside delete');
	    ob.person = User.deleteUser({ userId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllUsers(); 
	    });
    };		
    ob.reset = function(){
    	ob.user = new User();
        $scope.userForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.user = new User();
	    ob.flag= '';	
   	    ob.fetchAllUsers();
    };    
}]);     