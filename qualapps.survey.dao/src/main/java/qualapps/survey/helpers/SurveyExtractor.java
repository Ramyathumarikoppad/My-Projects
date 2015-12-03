package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import qualapps.survey.common.data.Survey;


public class SurveyExtractor implements ResultSetExtractor<Survey> {

	@Override
	public Survey extractData(ResultSet rs) throws SQLException, DataAccessException {

		if (rs != null) {
			Survey survey = new Survey();
			survey.setSurveyId(rs.getInt("survey_id"));
			survey.setName(rs.getString("name"));
			survey.setDesc(rs.getString("description"));
			survey.setStartDate(rs.getDate("start_date"));
			survey.setEndDate(rs.getDate("end_date"));
			survey.setCreated_by(rs.getString("created_by"));
			survey.setUpdated_by(rs.getString("updated_by"));
			return survey;
		}
		return null;
	}

}
