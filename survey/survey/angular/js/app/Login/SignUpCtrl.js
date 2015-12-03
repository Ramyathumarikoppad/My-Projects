'use strict';
app.controller('signupController',['$scope','$location', 'signupservice',function($scope,$location,signupservice){
	$scope.sign = function(signup) {
		var signupuser = signupservice.signup(signup);
		signupuser.then(function(msg){
			console.log(msg);
		
			if (msg.data.success == true) {
				$location.path('/employee');
				
			} else {
				$location.path('/');
				$scope.loggedin = true;
			}
	})
			}
	
	$scope.cancel = function(){
	$location.path('/');
}
}])
