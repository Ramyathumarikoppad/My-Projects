package qualapps.survey.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import qualapps.survey.common.data.Answer;
import qualapps.survey.common.data.Question;
import qualapps.survey.common.data.QuestionType;
import qualapps.survey.common.data.Survey;
import qualapps.survey.common.vo.AjaxResponse;
import qualapps.survey.common.vo.AnswerVO;
import qualapps.survey.common.vo.QuestionVO;
import qualapps.survey.common.vo.SurveyVO;
import qualapps.survey.service.QuestionAnswerSerc;

@Controller
public class BaseController {

	@Autowired
	private QuestionAnswerSerc questionAservice;


	@RequestMapping("/getsurveylist.htm")
	@ResponseBody
	public AjaxResponse getSurveyList() {

		AjaxResponse response = new AjaxResponse();
		System.out.println("in survey list");
		List<Survey> surveylist = null;
		int surveyId = 8;
		try {
			surveylist = questionAservice.getSurveyList(surveyId);
			
			response.setStatus(true);
			response.setVo(surveylist);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error getting the survey list");
		}
		return response;
	}

	@RequestMapping(value = "/surveycreate.htm", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public AjaxResponse addSurvey(@RequestBody SurveyVO s) {
		System.out.println("in survey list ");
		AjaxResponse response = new AjaxResponse();

		try {
			Survey survey= questionAservice.addSurvey(s, "email");
			response.setVo(survey);
			//response.setMessage(survey.getSurveyId());
			System.out.println("suvey id in survey create"+survey.getSurveyId());
			response.setStatus(true);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error adding the survey ");
		}
		return response;
	}

	@RequestMapping("/surveyupdate.htm")
	@ResponseBody
	public AjaxResponse updateSurvey(@RequestBody SurveyVO s) {
		System.out.println("in updateSurvey list");
		AjaxResponse response = new AjaxResponse();
		int surveyId = 8;
		try {
			SurveyVO s1 = questionAservice.updateSurvey(s, surveyId);
			response.setStatus(true);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error updating the survey ");
		}
		return response;
	}

	@RequestMapping("/surveydelete.htm")
	@ResponseBody
	public AjaxResponse deleteSurvey(@RequestParam(value = "surveyId") int surveyId) {
		System.out.println("in delete survey");
		AjaxResponse response = new AjaxResponse();
		try {
			int s1 = questionAservice.deleteSurvey(surveyId);
			System.out.println(s1);
			if (s1 > 0) { 
				response.setStatus(true);
			} else {
				response.setStatus(false);
				response.setMessage("No record found to delete");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error deleting the survey ");
		}
		return response;
	}

	@RequestMapping("/addquestion.htm")
	@ResponseBody
	public AjaxResponse addQuestion(@RequestBody QuestionVO questionVO,  @RequestParam int surveyId ) {

		AjaxResponse response = new AjaxResponse();
		try {
			questionVO.setCreatedDate("2015-02-02");
			questionVO.setUpdatedDate("2015-02-02");
			Question q=questionAservice.addQuestion(questionVO, surveyId);
			response.setVo(q);
			response.setStatus(true);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error adding the question ");
		}
		return response;
	}

	@RequestMapping("/updatequestion.htm")
	@ResponseBody
	public AjaxResponse updateQuestion(@RequestParam(value = "questionId") int questionId,@RequestBody QuestionVO questionVO) {
		System.out.println("in updateQuestion method");
		
		AjaxResponse response = new AjaxResponse();
		try {
			QuestionVO s1 = questionAservice.updateQuestion(questionVO, questionId);
			response.setStatus(true);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error updating the question ");
		}
		return response;
	}

	@RequestMapping("/deletequestion.htm")
	@ResponseBody
	public AjaxResponse deleteQuestion(@RequestParam(value = "questionId") int questionId) {
		System.out.println("in deleteQuestion method");
		AjaxResponse response = new AjaxResponse();
		
		try {
			int s1 = questionAservice.deleteQuestion(questionId);
			System.out.println(s1);
			if (s1 > 0) { 
				response.setStatus(true);
			} else {
				response.setStatus(false);
				response.setMessage("No record found to delete");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error deleting the question ");
		}
		return response;
	}

	@RequestMapping("/questionlist.htm")
	@ResponseBody
	public AjaxResponse questionList(@RequestParam int surveyId) {
		System.out.println("in questionList list");
		AjaxResponse response = new AjaxResponse();
		try {
			List<Question> list = questionAservice.getQuestionList(surveyId);
			System.out.println(list+"questionn list");
			response.setStatus(true);
			response.setVo(list);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error gettting the list of questions ");
		}
		return response;
	}

	@RequestMapping("/addanswer.htm")
	@ResponseBody
	public AjaxResponse addAnswer(@RequestBody AnswerVO answerVO, @RequestParam(value = "questionId") int questionId) {
		System.out.println("in addAnswer ");
		AjaxResponse response = new AjaxResponse();
		try {
			Answer s1 = questionAservice.addAnswer(answerVO, questionId);
			response.setStatus(true);
			response.setVo(s1);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error adding the answer ");
		}
		return response;
	}

	@RequestMapping("/updateanswer.htm")
	@ResponseBody
	public AjaxResponse updateAnswer(@RequestBody AnswerVO answerVO, @RequestParam(value = "answerId") int answerId) {
		System.out.println("in updateAnswer ");
		AjaxResponse response = new AjaxResponse();
		
		try {
			questionAservice.updateAnswer(answerVO, answerId);
			response.setStatus(true);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error updating the answer ");
		}
		return response;
	}

	@RequestMapping("/deleteanswer.htm")
	@ResponseBody
	public AjaxResponse deleteAnswer(@RequestParam(value = "answerId") int answerId) {
		System.out.println("in deleteAnswer ");
		AjaxResponse response = new AjaxResponse();
		try {
			int s1 = questionAservice.deleteAnswer(answerId);
			if (s1 > 0) { 
				response.setStatus(true);
			} else {
				response.setStatus(false);
				response.setMessage("No record found to delete");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error deleting the answer ");
		}
		return response;
	}
	@RequestMapping("/deleteans.htm")
	@ResponseBody
	public AjaxResponse deleteAns(@RequestParam(value = "questionId") int questionId) {
		System.out.println("in deleteAnswer ");
		AjaxResponse response = new AjaxResponse();
		try {
			int s1 = questionAservice.deleteAns(questionId);
			System.out.println(s1);
			if (s1 > 0) { 
				response.setStatus(true);
			} else {
				response.setStatus(false);
				response.setMessage("No record found to delete");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error deleting the answer ");
		}
		return response;
	}
	@RequestMapping("/answerlist.htm")
	@ResponseBody
	public AjaxResponse answerList(@RequestParam(value = "questionId") int questionId) {
		
		System.out.println("in answerList");
		AjaxResponse response = new AjaxResponse();
		try {
			System.out.println(questionId);
			List<Answer> list = questionAservice.getAnswerList(questionId);
			System.out.println(list
					+"answer list");
			response.setStatus(true);
			response.setVo(list);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error getting the answer list");
		}
		return response;
	}
	

	@RequestMapping("/questiontypee.htm")
	@ResponseBody
	public AjaxResponse questionTypeList() {
		System.out.println("in questionTypeList list");
		AjaxResponse response = new AjaxResponse();
		try {
			List<QuestionType> list = questionAservice.getQuestionTypeList();
			response.setStatus(true);
			response.setVo(list);
		} catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(false);
			response.setMessage(" Error getting the question types");
		}
		return response;
	}
}
