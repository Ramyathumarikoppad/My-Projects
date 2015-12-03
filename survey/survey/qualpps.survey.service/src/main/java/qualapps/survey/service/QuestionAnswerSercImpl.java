package qualapps.survey.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qualapps.survey.common.data.Answer;
import qualapps.survey.common.data.Question;
import qualapps.survey.common.data.QuestionType;
import qualapps.survey.common.data.Survey;
import qualapps.survey.common.vo.AnswerVO;
import qualapps.survey.common.vo.QuestionTypeVO;
import qualapps.survey.common.vo.QuestionVO;
import qualapps.survey.common.vo.SurveyVO;
import qualapps.survey.dao.QuestionAnswerDAO;

import com.google.gson.Gson;

@Service
public class QuestionAnswerSercImpl implements QuestionAnswerSerc {

	@Autowired
	private QuestionAnswerDAO questionADao;

	@Override
	public Survey addSurvey(SurveyVO survey, String userId) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Survey sur = new Survey();
		try {
			//sur.setSurveyId(survey.getSurveyId());
			sur.setName(survey.getName());
			sur.setDesc(survey.getDesc());
			String d = survey.getStartDate();
			System.out.println(d);
			date = formatter.parse(d);
			sur.setStartDate(date);
			String d1 = survey.getStartDate();
			date = formatter.parse(d1);
			sur.setEndDate(date);
			sur.setCreated_by(survey.getCreatedBy());
			sur.setUpdated_by(survey.getUpdatedBy());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Survey s = questionADao.addSurvey(sur, userId);
		return s;
	}

	public SurveyVO updateSurvey(SurveyVO survey, int surveyId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Survey sur = new Survey();
		try {
			sur.setSurveyId(survey.getSurveyId());
			sur.setName(survey.getName());
			sur.setDesc(survey.getDesc());
			String d = survey.getStartDate();
			date = formatter.parse(d);
			sur.setStartDate(date);
			String d1 = survey.getStartDate();
			date = formatter.parse(d1);
			sur.setEndDate(date);
			sur.setCreated_by(survey.getCreatedBy());
			sur.setUpdated_by(survey.getUpdatedBy());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Survey s = questionADao.updateSurvey(sur, surveyId);
		return survey;
	}

	@Override
	public int deleteSurvey(int surveyId) {
		int s = questionADao.deleteSurvey(surveyId);
		return s;
	}

	/*public JSONArray surveyList(String surveyId) {
		List<Survey> list = questionADao.getSurveyList(surveyId);
		Gson gson = new Gson();
		String json;
		JSONArray ja = new JSONArray();
		for (Survey s : list) {
			json = gson.toJson(s);
			ja.put(json);
		}
		return ja;
	}
	*/
	public List<Survey> getSurveyList(int surveyId) {
		List<Survey> list = questionADao.getSurveyList(surveyId);
		return list;
	}

	public Question addQuestion(QuestionVO questionVO, int surveyId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Question qu = new Question();
		try {
			qu.setQuestionId(questionVO.getQuestionId());
			qu.setSurveyId(surveyId);
			qu.setQuestionTypeId(questionVO.getQuestionTypeId());
			qu.setQuestion(questionVO.getQuestion());
			String d = questionVO.getCreatedDate();
			date = formatter.parse(d);
			qu.setCreatedDate(date);
			String d1 = questionVO.getUpdatedDate();
			date = formatter.parse(d1);
			qu.setUpdatedDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Question s = questionADao.addQuestion(qu, surveyId);
		return s;
	}

	public QuestionVO updateQuestion(QuestionVO questionVO, int questionId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Question qu = new Question();
		try {
			
			qu.setSurveyId(questionVO.getSurveyId());
			qu.setQuestionTypeId(questionVO.getQuestionTypeId());
			qu.setQuestion(questionVO.getQuestion());
			String d = questionVO.getCreatedDate();
			date = formatter.parse(d);
			qu.setCreatedDate(date);
			String d1 = questionVO.getUpdatedDate();
			date = formatter.parse(d1);
			qu.setUpdatedDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Question s = questionADao.updateQuestion(qu, questionId);
		return questionVO;
	}

	@Override
	public int deleteQuestion(int questionId) {
		int s = questionADao.deleteQuestion(questionId);
		return s;
	}

	public JSONArray questionList(int surveyId) {
		List<Question> list = questionADao.getQuestionList(surveyId);
		Gson gson = new Gson();
		String json;
		JSONArray ja = new JSONArray();
		for (Question s : list) {
			json = gson.toJson(s);
			ja.put(json);
		}
		return ja;
	}
	
	public List<Question> getQuestionList(int surveyId) {
		return questionADao.getQuestionList(surveyId);
		
	}

	public  Answer addAnswer(AnswerVO answerVO, int questionId) {
		Answer ans = new Answer();
		
		ans.setQuestionId(questionId);
		ans.setAnswer(answerVO.getAnswer());
		ans.setWeightage(answerVO.getWeightage());
		Answer s = questionADao.addAnswer(ans, questionId);
		return s;
	}

	public AnswerVO updateAnswer(AnswerVO answerVO, int answerId) {
		Answer ans = new Answer();
		ans.setAnswerId(answerVO.getAnswerId());
		ans.setQuestionId(answerVO.getQuestionId());
		ans.setAnswer(answerVO.getAnswer());
		ans.setWeightage(answerVO.getWeightage());
		Answer s = questionADao.updateAnswer(ans, answerId);
		return answerVO;
	}

	public int deleteAnswer(int answerId) {
		int s = questionADao.deleteAnswer(answerId);
		return s;
	}
	public int deleteAns(int questionId) {
		int s = questionADao.deleteAns(questionId);
		return s;
	}

	public JSONArray answerList(int questionId) {
		List<Answer> list = questionADao.getAnswerList(questionId);
		Gson gson = new Gson();
		String json;
		JSONArray ja = new JSONArray();
		for (Answer s : list) {
			json = gson.toJson(s);
			ja.put(json);
		}
		return ja;
	}
	
	public List<Answer> getAnswerList(int questionId) {
		return questionADao.getAnswerList(questionId);
	}

	public QuestionTypeVO addQuestionType(QuestionTypeVO questiontypeVO) {

		QuestionType ans = new QuestionType();
		ans.setQuestionTypeId(questiontypeVO.getQuestionTypeId());
		ans.setName(questiontypeVO.getName());
		ans.setDesc(questiontypeVO.getDesc());
		QuestionType s = questionADao.addQuestionType(ans);
		return questiontypeVO;
	}

	public JSONArray questionTypeList() {
		List<QuestionType> list = questionADao.getQuestionTypeList();
		Gson gson = new Gson();
		String json;
		JSONArray ja = new JSONArray();
		for (QuestionType s : list) {
			json = gson.toJson(s);
			ja.put(json);
		}
		return ja;
	}
	
	public List<QuestionType> getQuestionTypeList() {
		return questionADao.getQuestionTypeList();
	}

}
