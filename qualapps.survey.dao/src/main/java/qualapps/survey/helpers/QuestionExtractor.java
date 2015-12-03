package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import qualapps.survey.common.data.Question;

public class QuestionExtractor implements ResultSetExtractor<Question>{

	@Override
	public Question extractData(ResultSet rs) throws SQLException, DataAccessException {
		if(rs!=null) {
			Question question=new Question();
			question.setQuestionId(rs.getInt("q_id"));
			question.setSurveyId(rs.getInt("survey_id"));
			question.setQuestionTypeId(rs.getInt("qtype_id"));
			question.setQuestion(rs.getString("question"));
			question.setCreatedDate(rs.getDate("created_date"));
			question.setUpdatedDate(rs.getDate("updated_date"));
			
			return question;
		}
		return null;
	}

}
