package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import qualapps.survey.common.data.Question;

public class QuestionMapper implements RowMapper<Question>{

	@Override
	public Question mapRow(ResultSet rs, int row) throws SQLException {
		QuestionExtractor extract = new QuestionExtractor();
		return extract.extractData(rs);
	}

}
