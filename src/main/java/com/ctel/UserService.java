package com.ctel;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUserByPhone(String phone);
    void updateUser(User user);
    void deleteUser(String phone);
    List<User> getAllUsers();
}
