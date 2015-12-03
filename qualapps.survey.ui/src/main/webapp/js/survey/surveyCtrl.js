var questions = [];
var question = {
	"question" : "",
	"questionTypeId" : 1,
	"answers" : []
};

app.controller('mainnController','$scope','$location','$http','mainService',
		function($scope, $location, $http, mainService) {
			$scope.question = question;			
			$scope.addQuestions = function() {
				var question = {
										"question" : "",
										"questionTypeId" : 1,
										"answers" : []
								};
								console.log(JSON.stringify($scope.questions));
								questions.push(question);
								$scope.questions = questions;

							};

							$scope.addAnswers = function(question) {
								var answer = {
									answer : ''
								};
								// answers.push(answer);
								question.answers.push(answer);
							};
							$scope.save = function(survey, questions) {
								console.log(survey, "survey");
								console.log(questions, "questions");
								console.log(questions[0].answers, "answers");
								var getsurveyID = mainService
										.getsurveyID(survey);
								getsurveyID
										.then(function(response) {
											var surveyId = response.data.vo.surveyId;
											console.log(surveyId, "surveyId");
											if (response.data.status == true) {
												for (var i = 0; i <= questions.length; i++) {
													var q=questions[i];
													var answerlist=questions[i].answers;
													console.log(answerlist);
													var getquestionID = mainService
															.getquestionID(
																	q,
																	surveyId);
													getquestionID
															.then(function(
																	response) {
																if (response.data.status == true) {
																	
																	var questionId = response.data.vo.questionId;
																	for (var j = 0; j < answerlist.length; j++) {
																		var answerId = mainService
																				.getanswerID(
																						answerlist[j],
																						questionId);
																		answerId
																				.then(function(
																						response) {
																					console
																							.log(response);
																				});
																	}
																}
															});
												}

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
								var v = s;
								$scope.survey = v;

								var questionlist = mainService
										.getquestionList(s.surveyId);
								questionlist
										.then(function(response) {
											if (response.data.vo != null) {
												var qlist = response.data.vo;
												var size = response.data.vo.length;

												for (var i = 0; i < size; i++) {
													var q = qlist[i];
													var id = q.questionId;

													var answerlist = mainService
															.getanswerlist(id);
													answerlist
															.then(function(
																	response) {
																var answerlist = response.data.vo;
																q.answers = answerlist;
															});
													questions.push(q);
													$scope.questions = questions;
												}
											}
										});
							};
							$scope.deletequestion = function(questionId) {
								var deleteanswer = mainService
										.deleteanswer(questionId);
								deleteanswer.then(function(response) {
									console.log(response);
									var deletequestion = mainService
											.deletequestion(questionId);
									deletequestion.then(function(response) {
										console.log(response);
									});

								});
							};
							$scope.updatequestion = function(question,
									questionId) {
								var update = mainService.updatequestion(
										question, questionId);
								update.then(function(response) {
									console.log(response.data.message);

								});

							};
						} ]);
