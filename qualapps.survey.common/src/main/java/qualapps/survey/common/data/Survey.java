package qualapps.survey.common.data;

import java.util.Date;

public class Survey {

	private int surveyId;
	private String name;
	private String desc;
	private Date startDate;
	private Date endDate;
	private String createdBy;
	private String updatedBy;
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int i) {
		this.surveyId = i;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
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
