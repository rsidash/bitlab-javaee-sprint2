package kz.bitlab.academy.service;

import kz.bitlab.academy.db.DBManager;
import kz.bitlab.academy.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
    private static final Connection connection = DBManager.getConnection();

    public static User findByEmailAndPassword(String email, String password) {
        try {
            var sqlText = "SELECT * FROM users WHERE email = ? AND password = ?";

            PreparedStatement statement = connection.prepareStatement(sqlText);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));

                statement.close();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
