package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.model.Goods;

public class GoodDAO {

	public void save(Goods goods) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO goods (name, asin, price, inition_price, img_url, good_url) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, goods.getName());
			statement.setString(2, goods.getAsin());
			statement.setString(3, goods.getPrice());
			statement.setString(4, goods.getInitial_price());
			statement.setString(5, goods.getImg_url());
			statement.setString(6, goods.getGood_url());
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

	public Goods get(String name, String asin) {

		Goods goods = new Goods();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM goods WHERE name=? AND asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, asin);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				goods.setName(resultSet.getString("name"));
				goods.setAsin(resultSet.getString("asin"));
				goods.setGood_url(resultSet.getString("good_url"));
				goods.setPrice(resultSet.getString("price"));
				goods.setInitial_price(resultSet.getString("initial_price"));
				goods.setImg_url(resultSet.getString("img_url"));
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
		return goods;
	}

	public void update(String name, String asin, Goods newGoods) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE goods SET name=?, asin=?, price=?, initial_price=?,  img_url=?, good_url=?    WHERE name=? AND asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, asin);

			statement.setString(1, newGoods.getName());
			statement.setString(2, newGoods.getAsin());
			statement.setString(3, newGoods.getPrice());
			statement.setString(4, newGoods.getInitial_price());
			statement.setString(5, newGoods.getImg_url());
			statement.setString(6, newGoods.getGood_url());

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

	public void delete(String name, String asin) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM goods WHERE name=? AND asin=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, asin);
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
