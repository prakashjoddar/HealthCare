package com.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionProvider;
import com.connection.JDBCBaseDAO;
import com.dao.StateDAO;
import com.model.State;

public class JDBCStateDAO extends JDBCBaseDAO implements StateDAO {

	public JDBCStateDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public ArrayList<State> getStateList() {
		ArrayList<State> stateList = new ArrayList<>();

		// we use try catch beacause preparedstatement came into checked statetment
		try {
			String sqlQuery = "select id, name from apm_state";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				State state = new State();
				state.setId(rs.getInt("id"));
				state.setName(rs.getString("name"));
				stateList.add(state);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stateList;
	}

	@Override
	public int saveStateDetails(State state) {
		int response = 0;
		try {
			String sqlQuery = "insert into state(id, name) values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, state.getId());
			ps.setString(2, state.getName());
			response = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public int updateStateDetails(State state) {
		int response = 0;
		try {
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("UPDATE amp_state SET ");
			sqlQuery.append("name=? WHERE id=?");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, state.getName());
			ps.setInt(2, state.getId());
			response = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public State findStateById(int id) {
		State state = new State();

		try {
			String sqlQuery = "select id,name from apm_state where id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(sqlQuery);

			if (rs.next()) {
				state.setId(rs.getInt("id"));
				state.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return state;
	}

	@Override
	public State findStateByName(String name) {
		State state = new State();

		try {
			String sqlQuery = "select id,name from apm_state where name = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(sqlQuery);

			if (rs.next()) {
				state.setId(rs.getInt("id"));
				state.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return state;
	}

	@Override
	public int getTotalStates() {
		int count = 0;

		try {
			String sqlQuery = "select count(*) as count from apm_state";
			connection = ConnectionProvider.getConnection();
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery(sqlQuery);

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
}
