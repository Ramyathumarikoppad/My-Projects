package qualapps.survey.common.vo;

import java.io.Serializable;


public class QuestionTypeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int questionTypeId;
	private String name;
	private String desc;
	
	public int getQuestionTypeId() {
		return questionTypeId;
	}
	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
