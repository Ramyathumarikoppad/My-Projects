package qualapps.survey.common.data;

public class Answer {
	
	private int answerId;
	private int questionId;
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
	private String answer;
	private String weightage;

}
