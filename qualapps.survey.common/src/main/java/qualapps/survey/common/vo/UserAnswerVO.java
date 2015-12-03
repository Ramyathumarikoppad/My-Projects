package qualapps.survey.common.vo;

import java.io.Serializable;
import java.util.Date;
public class UserAnswerVO implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int userAnswerId;
	
	private int questionId;
	private int answerId;
	private String answer;
	private Date createdDate;
	public int getUserAnswerId() {
		return userAnswerId;
	}
	public void setUserAnswerId(int userAnswerId) {
		this.userAnswerId = userAnswerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
