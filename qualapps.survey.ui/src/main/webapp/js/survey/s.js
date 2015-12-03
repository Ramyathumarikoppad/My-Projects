app.controller('mainController', [
		'$scope',
		'$location',
		'$http',
		'mainService',
		function($scope, $location, $http, mainService) {
			
			$scope.qa = function(s) {
				console.log(s);
				$scope.survey=s;
				
				
				
				
				/*$scope.survey = {"name":s.name,"desc":s.desc,"startDate":s.startDate,"endDate":s.endDate};
				var questions = [];
				var questionlist = mainService.getquestionList(s.surveyId);
				questionlist.then(function(response) {
					if (response.data.vo != null) {
						var qlist = response.data.vo;
						var size = response.data.vo.length;

						for (var i = 0; i < size; i++) {
							var q = qlist[i];
							var id = q.questionId;
							questions.push(q);
							var answerlist = mainService.getanswerlist(id);
							answerlist.then(function(response) {
								var answerlist = response.data.vo;
								if (response.data.vo != null) {
									var size = answerlist.length;
									for (var j = 0; j < size; j++) {
										var answer = answerlist[j];

									}
								}
								console.log("answer list", answerlist);
							});
							console.log("question list", qlist);
						}
					}
				});
				$scope.questions = questions;
				console.log($scope.survey, "question list", $scope.questions,
						"answer list", $scope.answers);*/	
		};
		} ]);
