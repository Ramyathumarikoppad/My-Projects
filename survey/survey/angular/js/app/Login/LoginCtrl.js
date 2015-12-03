'use strict';
app.controller('LoginController', [
		'$scope',
		'$location',
		'loginService',
		function($scope, $location, loginService) {
			$scope.logoutbutton = false;
			$scope.Login = function() {
				var user = loginService.login($scope.Login.UserName,$scope.Login.Password);
				user.then(function(msg){
					if (msg.data.success == true) {
						$location.path('/employee');
						$scope.logoutbutton = true;
					} else {
						$location.path('/');
						$scope.loggedin = true;
					}
				});
			}
			
			$scope.sign = function(){
				$location.path('/signup');
			}
			$scope.logout = function(){
				var user = loginService.logout();
				user.then(function(msg){
					if (msg.data.success == true) {
						$location.path('/');
					}
				})
					}
			
		} ]);
