package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qualapps.survey.common.data.Answer;

public class AnswerMapper implements RowMapper<Answer>{

	@Override
	public Answer mapRow(ResultSet rs, int row) throws SQLException {
		AnswerExtractor extract = new AnswerExtractor();
		return extract.extractData(rs);
	}

}
