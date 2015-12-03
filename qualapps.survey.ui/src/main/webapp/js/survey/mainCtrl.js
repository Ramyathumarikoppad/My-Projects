app.controller('mainController', [
		'$scope',
		'$location',
		'$http',
		function($scope, $location, $http) {

			$scope.ShowHide = function() {

				$scope.IsHidden = true;
			};

			$scope.Show = function() {
				$scope.Hidden = true;
			};
			$scope.cancel = function() {
				$scope.IsHidden = false;
			};
			$scope.close = function() {
				$scope.Hidden = false;
			};
			$scope.save = function(survey, question, answer) {

				var res = $http.post('surveycreate.htm?', survey);
				res.then(function(response) {
					console.log(response);
					$scope.id = response.data.vo.surveyId;

					var res = $http.post('addquestion.htm?surveyId='
							+ $scope.id, question);
					res.then(function(response) {
						$scope.question = response.data.vo.questionId;
						var res = $http.post('addanswer.htm?questionId='
								+ $scope.question, answer);
						res.success(function(data, status, headers, config) {
							$scope.answer = data.vo;
						});
					});
					
				});

				/*
				 * var res =
				 * $http.post('addquestion.htm?surveyId='+$scope.id,question );
				 */
				/*res.success(function(data, status, headers, config) {
					$scope.question = data.vo.questionId;
				});
				res.error(function(data, status, headers, config) {
					alert("failure message: " + JSON.stringify({
						data : data
					}));
				});*/
				/* var qid=$scope.question.questionId; */
				/*var res = $http.post('addanswer.htm?questionId='
						+ $scope.question, answer);
				res.success(function(data, status, headers, config) {
					$scope.answer = data.vo;
				});
				res.error(function(data, status, headers, config) {
					alert("failure message: " + JSON.stringify({
						data : data
					}));
				});*/
				$location.path("/welcome");
			};
			var list = function() {
				var surveyList = $http.get('getsurveylist.htm');
				surveyList.then(function(response) {
					//$scope.surveys = response.data.vo;
					console.log(response.data.vo);

				});
			};

			list();

		} ]);
