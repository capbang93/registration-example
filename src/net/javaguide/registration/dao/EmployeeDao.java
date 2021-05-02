package net.javaguide.registration.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguide.registration.model.Employee;

public class EmployeeDao {

	public int registerEmployee(Employee employee) throws ClassNotFoundException, UnsupportedEncodingException {
		String INSERT_USERS_SQL = "INSERT INTO employee"
				+ " (id,first_name, last_name, username, password, address, contact) VALUES " + " (?,?,?,?,?,?,?);";

		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useUnicode=true&characterEncoding=UTF-8",
				"root", "1111");

			PreparedStatement preparedStatement = connection.prepareCall(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getUserName());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
