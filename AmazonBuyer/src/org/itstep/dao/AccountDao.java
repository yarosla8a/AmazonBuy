package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.model.AmazonAcc;

public class AccountDao {

	public void save(AmazonAcc account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO accounts(first_name, second_name, login, password) VALUES(?, ?, ?, ?)";
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getFirstName());
			statement.setString(2, account.getSecondName());
			statement.setString(3, account.getLogin());
			statement.setString(4, account.getPassword());
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

	 public AmazonAcc get(String login) {
		  AmazonAcc account = new AmazonAcc();
		  Connection connection = null;
		  PreparedStatement statement = null;
		  ResultSet resultSet = null;
		  String sql = "SELECT * FROM accounts WHERE login=?";

		  try {
		   connection = ConnectionToDB.getConnection();
		   statement = connection.prepareStatement(sql);
		   statement.setString(1, login);
		   resultSet = statement.executeQuery();
		   while (resultSet.next()) {
		    account.setFirstName(resultSet.getString("first_name"));
		    account.setSecondName(resultSet.getString("second_name"));
		    account.setLogin(resultSet.getString("login"));
		    account.setPassword(resultSet.getString("password"));
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
		return account;
	}

	public void update(String firstName, String secondName, AmazonAcc newAccount) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE accounts SET first_name=?, second_name=?, login=?, password=? WHERE first_name=? AND second_name=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, secondName);

			 statement.setString(1, newAccount.getFirstName());
			statement.setString(2, newAccount.getSecondName());
			statement.setString(3, newAccount.getLogin());
			statement.setString(4, newAccount.getPassword());

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

	public void delete(String firstName, String secondName) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM accounts WHERE first_name=? AND second_name=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, secondName);
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
