package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qualapps.survey.common.data.QuestionType;

public class QuestionTypeMapper implements RowMapper<QuestionType> {

	@Override
	public QuestionType mapRow(ResultSet rs, int row) throws SQLException {
		QuestionTypeExtractor extract = new QuestionTypeExtractor();
		return extract.extractData(rs);
	}

}
