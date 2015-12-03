(function(){
	
	var surveyList=function($http) {
		var getSurvey=function() {
			return $http.get("getsurveylist.htm");
			/*.then(function(response) {

				return response.data;
			});*/
		};
	
	return {
		getSurvey:getSurvey
	};
	};
	
	var app=angular.module("survey");
	
	app.factory("surveyList",surveyList);
}());

