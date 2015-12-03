<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script type="text/javascript">
function myFunction() {
	alert("hello");
	$.ajax({
		  url: 'surveycreate.htm',
		  type: "POST",
		  contentType:"application/json",
		  dataType : "json",
		  data:JSON.stringify({
			  surveyId:"136",
			  name:"NALINA",
			  desc:"HGJHGF Modi Survey",
			  startDate:"08/01/2015",
			  endDate:"08/05/2015",
			  createdBy:"a",
			  updatedBy:"abc"}),
		  
			success : function (response) {
                alert('success ' + response);
            },
            error : function (response) {
            	
                alert('error ' + response);
            }, 
		});
		}
		
// List of Surveys
function allSurveys() {
	alert("all surveys list ");
	$.ajax({
		url: 'getsurveylist.htm',
		type: "GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}

function updateSurvey() {
	$.ajax({
		url:'surveyupdate.htm',
		type:"POST",
		 contentType:"application/json",
		  dataType : "json",
		  data:JSON.stringify({
			  surveyId:"155",
			  name:"sAVITHA",
			  desc:"frjk fjhfj",
			  startDate:"08/01/2015",
			  endDate:"08/05/2015",
			  createdBy:"a",
			  updatedBy:"abc"
			  }),
		success : function(response) {
			alert('success '+response);
		},
	error : function(response) {
		alert('error '+response);
	},
	});
}
function deleteSurvey() {
	alert("hello");
	$.ajax({
		url: 'surveydelete.htm?surveyId=101',
		type:"GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}

function allQuestions() {
	alert("all surveys list ");
	$.ajax({
		url: 'questionlist.htm?surveyId=155',
		type: "GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}
function addQuestion() {
	alert("hello");
	$.ajax({
		  url: 'addquestion.htm?surveyId=155',
		  type: "POST",
		  contentType:"application/json",
		  dataType : "json",
		  data:JSON.stringify({
			  	questionId:"301",
				
				questionTypeId:"2",
				question:"where are you?",
				createdDate:"09/05/2015",
				updatedDate:"09/10/2015"
			  }),
		  
			success : function (response) {
                alert('success ' + response);
            },
            error : function (response) {
            	
                alert('error ' + response);
            }, 
		});
		}
function updateQuestion() {
	$.ajax({
		url:'updatequestion.htm?questionId=222',
		type:"POST",
		 contentType:"application/json",
		  dataType : "json",
		  data:JSON.stringify({
			  questionId:"301",
			  surveyId:"155",
				questionTypeId:"2",
				question:"where are you?",
				createdDate:"09/05/2015",
				updatedDate:"09/10/2015"
				}),
		success : function(response) {
			alert('success '+response);
		},
	error : function(response) {
		alert('error '+response);
	},
	});
}
function deleteQuestion() {
	alert("hello");
	$.ajax({
		url: 'deletequestion.htm?questionId=24',
		type:"GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}
function allAnswers() {
	alert("all surveys list ");
	$.ajax({
		url: 'answerlist.htm?questionId=301',
		type: "GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}
	
function addAnswer() {
	alert("hello");
	$.ajax({
		  url: 'addanswer.htm?questionId=301',
		  type: "POST",
		  contentType:"application/json",
		  dataType : "json",
		  data:JSON.stringify({
			 answerId:"111",
				answer: "am fine",
				weightage:"**"
			  }),
		  
			success : function (response) {
                alert('success ' + response);
            },
            error : function (response) {
            	
                alert('error ' + response);
            }, 
		});
		}
function updateAnswer() {
	$.ajax({
		url:'updateanswer.htm?answerId=111',
		type:"POST",
		 contentType:"application/json",
		  dataType : "json",
		  data:JSON.stringify({
			  answerId:"102",
			  questionId:"301",
				answer: "am fine",
				weightage:"**"
				}),
		success : function(response) {
			alert('success '+response);
		},
	error : function(response) {
		alert('error '+response);
	},
	});
}
function deleteAnswer() {
	alert("hello");
	$.ajax({
		url: 'deleteanswer.htm?answerId=102',
		type:"GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}
function allQuestionType() {
	alert("all surveys list ");
	$.ajax({
		url: 'questiontypee.htm',
		type: "GET",
		success : function (response) {
			alert('success ' + response);
		},
		error : function (response) {
		    alert('error ' + response);
		}, 
	});
}
</script>
</head>
<body>
<h1>Survey</h1><br>
<button onclick="javascript:allSurveys()">All Surveys</button>
<button onclick="javascript:myFunction()">Create Survey</button>
<button onclick="javascript:updateSurvey()">Update Survey</button>
<button onclick="javascript:deleteSurvey()">Delete Survey</button>

<h1>Question</h1><br>
<button onclick="javascript:allQuestions()">All Questions</button>
<button onclick="javascript:addQuestion()">Add Question</button>
<button onclick="javascript:updateQuestion()">Update Question</button>
<button onclick="javascript:deleteQuestion()">Delete Question</button>

<h1>Answer</h1><br>
<button onclick="javascript:allAnswers()">All Answers</button>
<button onclick="javascript:addAnswer()">Add Answer</button>
<button onclick="javascript:updateAnswer()">Update Answer</button>
<button onclick="javascript:deleteAnswer()">Delete Answer</button>

<h1> Question type</h1><br>
<button onclick="javascript:allQuestionType()">All Question Types</button>

</body>
</html>