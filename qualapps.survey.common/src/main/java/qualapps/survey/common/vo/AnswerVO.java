package qualapps.survey.common.vo;

import java.io.Serializable;






public class AnswerVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int answerId;
	
	private int questionId;
	private String answer;
	private String weightage;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionTypeId) {
		this.questionId = questionTypeId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getWeightage() {
		return weightage;
	}
	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}
	

}
