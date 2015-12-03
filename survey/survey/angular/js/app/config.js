'use strict';

var app=angular.module('spaceapp', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {templateUrl: 'partials/login.html', pageTitle:"Login",controller: 'LoginController'}),
	$routeProvider.when('/dashboard', {templateUrl: 'partials/dashboard.html', pageTitle:"Welcome Back",controller: 'DashBoardController'}),
	$routeProvider.when('/signup', {templateUrl: 'partials/signup.html', pageTitle:"Welcome Back",controller: 'signupController'}),
	$routeProvider.when('/employee', {templateUrl: 'partials/employee.html', pageTitle:"Welcome Back",controller: 'employeeController'}),
	$routeProvider.otherwise({redirectTo: '/'});
	
}]);
