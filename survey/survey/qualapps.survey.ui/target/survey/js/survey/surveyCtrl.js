app.controller('mainnController', [
		'$scope',
		'$location',
		'$http',
		'mainService',
		function($scope, $location, $http, mainService) {
			$scope.addQuestions = function() {
				var question = {
					question : ''
				};
				$scope.questions = question;
			};
			
			$scope.addAnswers = function() {
				var answer = {
					answer : ''
				};
				$scope.answers = answer;
			};
			$scope.save = function(survey, question, answer) {
				var getsurveyID = mainService.getsurveyID(survey);
				getsurveyID.then(function(msg) {
					var surveyid = msg.data.vo.surveyId;
					if (msg.data.status == true) {
						var getquestionID = mainService.getquestionID(question,
								surveyid);
						getquestionID.then(function(msg) {
							if (msg.data.status == true) {
								var questionid = msg.data.vo.questionId;

								var answerid = mainService.getanswerID(answer,
										questionid);
								answerid.then(function(msg) {
								});
							}
						});
					}
				});
			};
			$scope.surveylist = function() {
				var surveyList = mainService.getsurveyList();
				surveyList.then(function(response) {
					$scope.surveys = response.data.vo;
				});
			};
			$scope.qa = function(s) {
				console.log(s);
				var v=s;
				$scope.survey=v;
				var questions = [];
				var answers=[];
				var questionlist = mainService.getquestionList(s.surveyId);
				questionlist.then(function(response) {
					if (response.data.vo != null) {
						var qlist = response.data.vo;
						var size = response.data.vo.length;

						for (var i = 0; i < size; i++) {
							var q = qlist[i];
							var id = q.questionId;
							
							var answerlist = mainService.getanswerlist(id);
							answerlist.then(function(response) {
								var answerlist = response.data.vo;
								
								if (response.data.vo != null) {
									var size = answerlist.length;
									for (var j = 0; j < size; j++) {
										var answer = answerlist[j];
										answers.push(answer);
									}
									$scope.answers=answers;
								}
							});
							questions.push(q);
							$scope.questions=questions;
						}
					}
				});
		};
$scope.deletequestion=function(questionId) {
	var deleteanswer=mainService.deleteanswer(questionId);
	deleteanswer.then(function(response) {
		console.log(response);
		var deletequestion=mainService.deletequestion(questionId);
		deletequestion.then(function(response) {
			console.log(response);
		});
		
	});
};
		} ]);
