package com.ctel;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO userdetailsnew (username, password, firstname, lastname, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone());
    }

    @Override
    public User getUserByPhone(String phone) {
        String sql = "SELECT * FROM userdetailsnew WHERE phone = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{phone}, new UserRowMapper());
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE userdetailsnew SET username = ?, password = ?, firstname = ?, lastname = ?, email = ?, address = ? WHERE phone = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone());
    }

    @Override
    public void deleteUser(String phone) {
        String sql = "DELETE FROM userdetailsnew WHERE phone = ?";
        jdbcTemplate.update(sql, phone);
    }
    
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM userdetailsnew";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}
