'use strict';
var app = angular.module('surveymodule', ['ngRoute']);
app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {templateUrl: 'partials/main.html', controller: 'mainnController'}),
	$routeProvider.when('/list', {templateUrl: 'partials/list.html',controller: 'mainController'}),
	$routeProvider.otherwise({redirectTo: '/'});
}]);
