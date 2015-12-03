package qualapps.survey.common.vo;

import java.util.List;

public class AjaxResponse {

	Object vo;
	String message;
	boolean status;
	List<Object> obj;


	

	public List<Object> getObj() {
		return obj;
	}

	public void setObj(List<Object> list) {
		this.obj = list;
	}

	public Object getVo() {
		return vo;
	}

	public void setVo(Object vo) {
		this.vo = vo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
