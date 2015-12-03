package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import qualapps.survey.common.data.QuestionType;
import qualapps.survey.common.data.Survey;

public class QuestionTypeExtractor implements ResultSetExtractor<QuestionType>  {

	@Override
	public QuestionType extractData(ResultSet rs) throws SQLException, DataAccessException {
		if(rs!=null) {
			QuestionType questionType=new QuestionType();
			questionType.setQuestionTypeId(rs.getInt("qtype_id"));
			questionType.setName(rs.getString("name"));
			questionType.setDesc(rs.getString("description"));
			return questionType;
		}
		return null;
	}

}
