package qualapps.survey.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import qualapps.survey.common.data.Answer;
import qualapps.survey.common.data.Question;
import qualapps.survey.common.data.QuestionType;
import qualapps.survey.common.data.Survey;
import qualapps.survey.helpers.AnswerMapper;
import qualapps.survey.helpers.QuestionMapper;
import qualapps.survey.helpers.QuestionTypeMapper;
import qualapps.survey.helpers.SurveyMapper;

@Repository
public class QuestionAnswerDAO extends BaseDao {

	
	public Survey addSurvey(Survey survey, String email) {
		
		String query="INSERT INTO survey (name,description,start_date,end_date,created_by,updated_by) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(query,survey.getName(),survey.getDesc(),survey.getStartDate(),survey.getEndDate(),survey.getCreatedBy(),survey.getUpdatedBy());
		
		Survey s=getSurvey(survey.getName());
		return s;
		
		
	}
	public Survey getSurvey(String name) {
		List<Survey> s=getSurveyList(5);
		Survey sur = null;
		for(Survey s1:s) {
			if(name.equals(s1.getName())) {
				sur=s1;
				
			}
		}
		return sur;
	}
	public Survey updateSurvey(Survey survey, int surveyId) {
		String query="UPDATE survey set survey_id=?,name=?,description=?,start_date=?,end_date=?,created_by=?,updated_by=? where survey_id=?";
		System.out.println(query);
		jdbcTemplate.update(query,survey.getSurveyId(),survey.getName(),survey.getDesc(),survey.getStartDate(),survey.getEndDate(),survey.getCreatedBy(),survey.getUpdatedBy(),surveyId);
		return survey;
	}
	public int deleteSurvey(int surveyId) {
		String query="delete from survey where survey_id=? ";
		System.out.println(query);
		System.out.println(surveyId);
		int i=jdbcTemplate.update(query,surveyId);
		return i;
	}
	
	public List<Survey> getSurveyList(int surveyId ) {
		return jdbcTemplate.query("select * from survey ", new SurveyMapper());
	}
	public Question addQuestion(Question question, int surveyId) {
		String query="INSERT INTO question (survey_id,qtype_id,question,created_date,updated_date) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(query,question.getSurveyId(),question.getQuestionTypeId(),question.getQuestion(),question.getCreatedDate(),question.getUpdatedDate());
		Question q=getQuestion(question.getQuestion(),surveyId);
		return q;
	}
	
	public Question getQuestion(String q,int surveyId) {
		List<Question> li=getQuestionList(surveyId);
		Question qus=null;
		for(Question q1:li) {
			if(q1.getQuestion().equals(q)) {
				qus=q1;
			}
		}
		return qus;
	}
	
	
	
	public Question updateQuestion(Question question, int questionId) {
		String query="UPDATE question set q_id=?,survey_id=?,qtype_id=?,question=?,created_date=?,updated_date=? where q_id=?";
		System.out.println(query);
		jdbcTemplate.update(query,question.getQuestionId(),question.getSurveyId(),question.getQuestionTypeId(),question.getQuestion(),question.getCreatedDate(),question.getUpdatedDate(),questionId);
		return question;
	}
	public int deleteQuestion(int questionId) {
		String query="delete from question where q_id=? ";
		int i=jdbcTemplate.update(query,questionId);
		return i;
	}
	public List<Question> getQuestionList(int surveyId ) {
		return jdbcTemplate.query("select * from question where survey_id=?", new QuestionMapper(),surveyId);
	}
	public Answer addAnswer(Answer answer, int questionId) {
		
		String query="INSERT INTO answer (q_id,answer,weightage) VALUES (?,?,?) ";
		jdbcTemplate.update(query,questionId,answer.getAnswer(),answer.getWeightage());
		return answer;
		
	}
	public Answer updateAnswer(Answer answer, int answerId) {
	String query="UPDATE answer set answer_id=?,q_id=?,answer=?,weightage=? where answer_id=?";
	System.out.println(query);
	jdbcTemplate.update(query,answer.getAnswerId(),answer.getQuestionId(),answer.getAnswer(),answer.getWeightage(),answerId);
	return answer;
	}
	
	public int deleteAnswer(int answerId) {
		String query="delete from answer where answer_id=?";
		int i=jdbcTemplate.update(query,answerId);
		return i;
	}
	public int deleteAns(int questionId) {
		String query="delete from answer where q_id=?";
		int i=jdbcTemplate.update(query,questionId);
		return i;
	}
	public List<Answer> getAnswerList(int questionId ) {
		System.out.println(questionId+"question id");
		return jdbcTemplate.query("select * from answer where q_id=?", new AnswerMapper(),questionId);
		
	}
	public QuestionType addQuestionType(QuestionType questionType) {
		
		String query="INSERT INTO question_type (qtype_id,name,description) VALUES (?,?,?) ";
		jdbcTemplate.update(query,questionType.getQuestionTypeId(),questionType.getName(),questionType.getDesc());
		return questionType;
		
	}
	public List<QuestionType> getQuestionTypeList( ) {
	return jdbcTemplate.query("select * from question_type", new QuestionTypeMapper());
	}
}
