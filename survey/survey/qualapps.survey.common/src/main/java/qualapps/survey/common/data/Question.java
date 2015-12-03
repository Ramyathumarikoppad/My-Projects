package qualapps.survey.common.data;

import java.util.Date;

public class Question {
	
	private int questionId;
	private int surveyId;
	private int questionTypeId;
	private String question;
	private Date createdDate;
	private Date updatedDate;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int i) {
		this.surveyId = i;
	}
	public int getQuestionTypeId() {
		return questionTypeId;
	}
	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
