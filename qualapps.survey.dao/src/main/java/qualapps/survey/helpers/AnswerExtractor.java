package qualapps.survey.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import qualapps.survey.common.data.Answer;

public class AnswerExtractor  implements ResultSetExtractor<Answer>{
	@Override
	public Answer extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		
		if(rs!=null) {
			Answer answer=new Answer();
			answer.setAnswerId(rs.getInt("answer_id"));
					
			answer.setQuestionId(rs.getInt("q_id"));
			answer.setAnswer(rs.getString("answer"));
			answer.setWeightage(rs.getString("weightage"));
			return answer;
		}
		return null;
	}

}