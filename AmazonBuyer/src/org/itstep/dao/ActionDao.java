package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.model.Action;

public class ActionDao {
	public void save(Action action) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO actions( asin, action, login, action_time) VALUES(?, ?, ?, ?)";
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			// statement.setString(1, action.getId());
			statement.setString(1, action.getAsin());
			statement.setString(2, action.getAction());
			statement.setString(3, action.getLogin());
			statement.setString(4, action.getAction_time());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Action get(String asin, String action) {

		Action actions = new Action();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM actions WHERE asin=? AND action=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, asin);
			statement.setString(2, action);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				actions.setAsin(resultSet.getString("asin"));
				actions.setAction(resultSet.getString("action"));
				actions.setLogin(resultSet.getString("login"));
				actions.setAction_time(resultSet.getString("action_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return actions;
	}

	public void update(String asin, String action, Action newAction) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE actions SET asin=?, action=?, login=?, action_time=? WHERE asin=? AND action=?";///// ?

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, asin);
			statement.setString(2, action);

			statement.setString(1, newAction.getAsin());
			statement.setString(2, newAction.getAction());
			statement.setString(3, newAction.getLogin());
			statement.setString(4, newAction.getAction_time());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String Action, String Asin) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM actions WHERE action=? AND asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, Action);
			statement.setString(2, Asin);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
