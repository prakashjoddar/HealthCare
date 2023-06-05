package com.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.comparator.SortUserDetailsByFullName;
import com.comparator.SortUserDetailsById;
import com.comparator.SortUserDetailsByName;
import com.connection.ConnectionProvider;
import com.connection.JDBCBaseDAO;
import com.dao.UserDetailsDAO;
import com.model.UserDetails;

public class JDBCUserDetailsDAO extends JDBCBaseDAO implements UserDetailsDAO {

	public JDBCUserDetailsDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public ArrayList<UserDetails> getUserDetailsList() {
		ArrayList<UserDetails> userDetailsList = new ArrayList<>();
		try {
			String sqlQuery = "SELECT id, firstname, lastname, fullname, address, "
					+ "contact, gender, stateid, cityid, email, dob, reg_date, last_modified, isadmin "
					+ "FROM user_details";

			PreparedStatement statement = connection.prepareStatement(sqlQuery.toString());
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				UserDetails details = new UserDetails();
				details.setId(rs.getInt("id"));
				details.setFirstName(rs.getString("firstname"));
				details.setLastName(rs.getString("lastname"));
				details.setFullName(rs.getString("fullname"));
				details.setAddress(rs.getString("address"));
				details.setContact(rs.getString("contact"));
				details.setGender(rs.getString("gender"));
				details.setStateId(rs.getInt("stateid"));
				details.setCityId(rs.getInt("cityid"));
				details.setEmail(rs.getString("email"));
				details.setDob(rs.getString("dob"));
				details.setRegDate(rs.getString("reg_date"));
				details.setLastModified(rs.getString("last_modified"));
				details.setIsAdmin(rs.getInt("isadmin"));

				userDetailsList.add(details);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Collections.sort(userDetailsList, new SortUserDetailsByFullName());

		return userDetailsList;
	}

	@Override
	public int updateUserDetails(UserDetails userDetails) {

		int response = 0;

		// when query becomes to large use string buffer
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("update user_details set firstname=?, lastname=?, fullname=?, address=?, ");
		sqlQuery.append("contact=?, gender=?, stateid=?, cityid=?, email=?, dob=?, ");
		sqlQuery.append("last_modified=?, isadmin=? where id=?");

		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, userDetails.getFirstName());
			ps.setString(2, userDetails.getLastName());
			ps.setString(3, userDetails.getFirstName() + " " + userDetails.getLastName());
			ps.setString(4, userDetails.getAddress());
			ps.setString(5, userDetails.getContact());
			ps.setString(6, userDetails.getGender());
			ps.setInt(7, userDetails.getStateId());
			ps.setInt(8, userDetails.getCityId());
			ps.setString(9, userDetails.getEmail());
			ps.setString(10, userDetails.getDob());
			ps.setString(11, userDetails.getLastModified());
			ps.setInt(12, userDetails.getIsAdmin());
			ps.setInt(13, userDetails.getId());

			response = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public int removeUserDetails(int id) {
		int response = 0;

		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("DELETE FROM user_details ");
		sqlQuery.append("where id=?");

		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setInt(1, id);

			response = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public UserDetails findUserById(int id) {
		UserDetails userDetails = new UserDetails();

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("SELECT id, firstname, lastname, fullname, address, ");
			sqlQuery.append("contact, gender, stateid, cityid, ");
			sqlQuery.append("email, dob, reg_date, last_modified, isadmin ");
			sqlQuery.append("from user_details ");
			sqlQuery.append("where id = ?");
			// sqlQuery.append("left join apm_state on user_details.stateid=apm_state.id ");
			// sqlQuery.append("left join apm_city on user_details.cityid = apm_city.id ");

			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userDetails.setId(rs.getInt(1));
				userDetails.setFirstName(rs.getString(2));
				userDetails.setLastName(rs.getString(3));
				userDetails.setFullName(rs.getString(4));
				userDetails.setAddress(rs.getString(5));
				userDetails.setContact(rs.getString(6));
				userDetails.setGender(rs.getString(7));
				userDetails.setStateId(rs.getInt(8));
				userDetails.setCityId(rs.getInt(9));
				userDetails.setEmail(rs.getString(10));
				userDetails.setDob(rs.getString(11));
				userDetails.setRegDate(rs.getString(12));
				userDetails.setLastModified(rs.getString(13));
				userDetails.setIsAdmin(rs.getInt(14));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userDetails;
	}

	@Override
	public boolean checkUserCreds(String userId, String password) {
		boolean response = false;
		try {
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("SELECT id FROM user_creds ");
			sqlQuery.append("WHERE userid=? AND password=?");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			response = rs.next() ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int getTotalUsers() {
		int count = 0;

		try {
			String sqlQuery = "select count(*) as count from user_details";
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

	@Override
	public UserDetails findUserByName(String name) {
		UserDetails userDetails = new UserDetails();

		try {
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append("SELECT id, firstname, lastname, fullname, address, ");
			sqlQuery.append("contact, gender, stateid, cityid, ");
			sqlQuery.append("email, dob, reg_date, last_modified, isadmin ");
			sqlQuery.append("from user_details ");
			sqlQuery.append("where name = ?");

			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userDetails.setId(rs.getInt(1));
				userDetails.setFirstName(rs.getString(2));
				userDetails.setLastName(rs.getString(3));
				userDetails.setFullName(rs.getString(4));
				userDetails.setAddress(rs.getString(5));
				userDetails.setContact(rs.getString(6));
				userDetails.setGender(rs.getString(7));
				userDetails.setStateId(rs.getInt(8));
				userDetails.setCityId(rs.getInt(9));
				userDetails.setEmail(rs.getString(10));
				userDetails.setDob(rs.getString(11));
				userDetails.setRegDate(rs.getString(12));
				userDetails.setLastModified(rs.getString(13));
				userDetails.setIsAdmin(rs.getInt(14));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userDetails;
	}

	@Override
	public int saveUserDetails(UserDetails userDetails) {
		int response = 0;

		try {
			// when query becomes to large use string buffer
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("insert into user_details(firstname, lastname, fullname, address,");
			sqlQuery.append("contact, gender, stateid, cityid, email, dob, reg_date, last_modified, isadmin) values");
			sqlQuery.append("(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, userDetails.getFirstName());
			ps.setString(2, userDetails.getLastName());
			ps.setString(3, userDetails.getFullName());
			ps.setString(4, userDetails.getAddress());
			ps.setString(5, userDetails.getContact());
			ps.setString(6, userDetails.getGender());
			ps.setInt(7, userDetails.getStateId());
			ps.setInt(8, userDetails.getCityId());
			ps.setString(9, userDetails.getEmail());
			ps.setString(10, userDetails.getDob());
			ps.setString(11, userDetails.getRegDate());
			ps.setString(12, userDetails.getLastModified());
			ps.setInt(13, userDetails.getIsAdmin());

			response = ps.executeUpdate();
		} catch (SQLException e) {

		}

		return response;
	}

	@Override
	public int saveUserCreds(String userID, String password) {
		int response = 0;
		try {
			String sqlQuery = "INSERT INTO user_creds(userid, password) values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, userID);
			ps.setString(2, password);
			response = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public int deactivateUser(int id) {
		int response = 0;

		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("update user_details set isdeleted=? where id=?");

		try {
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setInt(1, id);

			response = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}

}
