package qualapps.survey.service;

import java.util.List;

import org.json.JSONArray;

import qualapps.survey.common.data.Answer;
import qualapps.survey.common.data.Question;
import qualapps.survey.common.data.QuestionType;
import qualapps.survey.common.data.Survey;
import qualapps.survey.common.vo.AnswerVO;
import qualapps.survey.common.vo.QuestionTypeVO;
import qualapps.survey.common.vo.QuestionVO;
import qualapps.survey.common.vo.SurveyVO;

public interface QuestionAnswerSerc {

	public Survey addSurvey(SurveyVO survey, String email);

	public SurveyVO updateSurvey(SurveyVO survey, int surveyId);

	public int deleteSurvey(int surveyId);

	public List<Survey> getSurveyList(int surveyId);
	
	/*public JSONArray surveyList(String surveyId);*/

	public Question addQuestion(QuestionVO questionVO, int surveyId);

	public QuestionVO updateQuestion(QuestionVO questionVO, int questionId);

	public int deleteQuestion(int questionId);

	public JSONArray questionList(int surveyId);
	
	public List<Question> getQuestionList(int surveyId);

	public Answer addAnswer(AnswerVO answerVO, int questionId);

	public AnswerVO updateAnswer(AnswerVO answerVO, int answerId);

	public int deleteAnswer(int answerId);
	
	public int deleteAns(int questionId);

	public JSONArray answerList(int questionId);
	
	public List<Answer> getAnswerList(int questionId);

	public QuestionTypeVO addQuestionType(QuestionTypeVO questiontypeVO);

	public JSONArray questionTypeList();
	
	public List<QuestionType> getQuestionTypeList();

}
