'use strict';

app.factory('mainService', function ($http){

	return{
		getsurveyID : function(survey){
			console.log(survey);
			var json = {"name":survey.name,"desc":survey.desc,"startDate": survey.startDate,"endDate":survey.endDate};
			var promise = $http.post('surveycreate.htm?',json);
			return promise;	
		},
		
		getquestionID : function(question,surveyid){
			var json = {"question":question.question ,"questionTypeId":1};
			var promise = $http.post('addquestion.htm?surveyId='+surveyid,json);
			return promise;
		},
		getanswerID :function(answer,questionid){
		var json = {"answer":answer.answer,"questionId":questionid};
		var promise = $http.post('addanswer.htm?questionId='+questionid,json);
		return promise;
		},
		getsurveyList : function() {
			var promise = $http.post('getsurveylist.htm');
			return promise;
		},
		getquestionList:function(surveyId) {
			var promise = $http.get('questionlist.htm?surveyId='+surveyId);
			return promise;
		},
		getanswerlist : function(id) {
			console.log(id);
			var promise = $http.get('answerlist.htm?questionId='+id);
			return promise;
		},
		deleteanswer : function(qid) {
			var promise=$http.get('deleteans.htm?questionId='+qid);
			return promise;
			
		},
		deletequestion : function(qid) {
			var promise=$http.get('deletequestion.htm?questionId='+qid);
			return promise;
			
		},
		updatequestion : function(question,questionId) {
			var json={"questionId":question.questionId,"surveyId":question.surveyId,"questionTypeId":1,"question":question.question};
			var promise=$http.post('updatequestion.htm?questionId='+questionId,json);
			return promise;
			
		}
		
		
		};
});