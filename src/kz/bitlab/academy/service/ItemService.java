package kz.bitlab.academy.service;

import kz.bitlab.academy.db.DBManager;
import kz.bitlab.academy.entity.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private static final Connection connection = DBManager.getConnection();

    public static void create(Item item) {
        try {
            var sqlText = "INSERT INTO items (name, description, price) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sqlText);
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Item> findAll() {
        List<Item> items = new ArrayList<>();

        try {
            var sqlText = "SELECT * FROM items";

            PreparedStatement statement = connection.prepareStatement(sqlText);

            executeQuery(statement, items);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public static Item findById(Long id) {
        try {
            var sqlText = "SELECT * FROM items WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sqlText);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));

                statement.close();
                return item;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Item not found with id = " + id);
    }

    public static List<Item> findTop10() {
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from items order by price desc limit 10");

            executeQuery(statement, items);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    private static void executeQuery(PreparedStatement statement, List<Item> itemList) throws SQLException {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Item item = new Item();
            item.setId(resultSet.getLong("id"));
            item.setName(resultSet.getString("name"));
            item.setDescription(resultSet.getString("description"));
            item.setPrice(resultSet.getDouble("price"));

            itemList.add(item);
        }

        statement.close();
    }
}
