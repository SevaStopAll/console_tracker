package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
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
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("insert into items(name, created) values (?, ?)")) {
            ps.setString(1, item.getName());
            long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            ps.setTimestamp(2, timestamp);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        if (findById(id) != null) {
            try (PreparedStatement ps = cn.prepareStatement("update items set name = ? where id = ?")) {
                ps.setString(1, item.getName());
                ps.setInt(2, id);
                result = ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
            try (PreparedStatement ps = cn.prepareStatement("delete from items where id = ?")) {
                ps.setInt(1, id);
                 result = ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Statement statement = cn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from items;");
            while (resultSet.next()) {
                items.add(new Item(resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("created").toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(new Item(resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("created").toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement statement = cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Item(resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("created").toLocalDateTime());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

