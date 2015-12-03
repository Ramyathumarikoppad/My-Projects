package qualapps.survey.common.vo;

import java.io.Serializable;

import java.util.Date;

public class SurveyVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int surveyId;
	private String name;
	private String desc;
	private String startDate;
	private String endDate;
	private String createdBy;
	private String updatedBy;
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreated_by(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdated_by(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
