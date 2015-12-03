package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qualapps.survey.common.data.Survey;

public class SurveyMapper implements RowMapper<Survey> {

	@Override
	public Survey mapRow(ResultSet rs, int row) throws SQLException {
		SurveyExtractor extract = new SurveyExtractor();
		return extract.extractData(rs);
	}

}
