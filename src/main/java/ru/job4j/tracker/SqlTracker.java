package ru.job4j.tracker;


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, timestamp);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl;
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            statement.execute();
            rsl = true;
        } catch (SQLException e) {
            rsl = false;
            throw new RuntimeException(e);
        }
        return rsl;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM items WHERE id = ? ",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM items",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getInt("id"), resultSet.getString("name"));
                    item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                    rsl.add(item);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        Item item;
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM items WHERE name like ? ",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, key);
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(resultSet.getInt("id"), resultSet.getString("name"));
                    item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                    rsl.add(item);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM items WHERE id = ? ",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(resultSet.getInt("id"), resultSet.getString("name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return item;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Store sqlTracker = new SqlTracker();
        System.out.println(sqlTracker.findByName("kek"));
    }
}