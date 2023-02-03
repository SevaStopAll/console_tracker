package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
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
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
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
        try (PreparedStatement ps = cn.prepareStatement("insert into users(name, data) values (?, ?)")) {
            ps.setString(1, item.getName());
            long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            ps.setTimestamp(2, timestamp);
            ps.execute();
        }  catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Item> findAll() {

        return null;
    }

    @Override
    public List<Item> findByName(String key) {
        try (PreparedStatement ps = cn.prepareStatement("insert into users(name, data) values (?, ?)")) {
            ps.setString(1, item.getName());
            long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            ps.setTimestamp(2, timestamp);
            ps.execute();
        }  catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return new Item();
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement ps = cn.prepareStatement("insert into users(name, data) values (?, ?)")) {
            ps.setString(1, item.getName());
            long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            ps.setTimestamp(2, timestamp);
            ps.execute();
        }  catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return new Item();
    }
}

