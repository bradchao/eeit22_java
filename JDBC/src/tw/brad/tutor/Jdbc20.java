package tw.brad.tutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tw.brad.apis.Food;
import tw.brad.apis.JdbcTool;
import tw.brad.apis.Member;
import tw.brad.apis.RowMapper;

public class Jdbc20 {

	public static void main(String[] args) {
		JdbcTool jdbc = new JdbcTool();
		String sql = """
				SELECT *
				FROM food
				WHERE name LIKE ? OR addr LIKE ?
				""";
		/*
		List<Food> foods = jdbc.query(sql, new RowMapper<Food>() {
			@Override
			public Food mapRow(ResultSet rs) throws SQLException {
				Food food = new Food(rs.getLong("id"), rs.getString("name"),
						rs.getString("addr"), rs.getString("tel"),
						rs.getString("feature"),rs.getString("city"),rs.getString("town"));
				return food;
			}
		}, "%農場%", "%農場%");
		*/
		
		List<Food> foods = jdbc.query(sql, rs -> {
			Food food = new Food(rs.getLong("id"), rs.getString("name"),
					rs.getString("addr"), rs.getString("tel"),
					rs.getString("feature"),rs.getString("city"),rs.getString("town"));
			return food;			
		}, "%農場%", "%農場%");
		
		
		for (Food food : foods) {
			System.out.printf("%d:%s:%s\n", food.getId(), food.getName(), food.getAddr());
		}
	}

}
