package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

/**
 * class chung thao tác với db
 * 
 * @author hai.nv173089
 *
 * @param <T>
 */

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=newservlet12month2018;integratedSecurity=true;";
			String user = "sa";
			String password = "123";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameters
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) { // TODO: handle exception
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				}else if( parameter instanceof Integer) {
					statement.setInt(index, (Integer)parameter);
				}else if( parameter instanceof Date) {
					statement.setDate(index, (Date)parameter);
				}else if(parameter instanceof Double) {
					statement.setDouble(index, (Double)parameter);
				}//nên có thêm trường hợp parameter=null
				else if(parameter ==null) {
					statement.setNull(index, Types.NULL);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			// thêm RETURN_GENERATED_KEYS để thực hiện hàm getGeneratedKeys
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();// nếu k có commit thì sẽ không thay đổi db
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();// nếu 1 tác vụ fail thì roll back lại
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {

		PreparedStatement statement=null;
		ResultSet resultSet = null;
		Long id = null;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//thêm RETURN_GENERATED_KEYS để thực hiện hàm getGeneratedKeys
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();// getGeneratedKeys lấy giá trị key được tự tạo ra
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();// nếu k có commit thì sẽ không thay đổi db
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();// nếu 1 tác vụ fail thì roll back lại
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				return null;
			}
			
		}
	}

}
