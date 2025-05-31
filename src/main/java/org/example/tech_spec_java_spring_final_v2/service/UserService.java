package org.example.tech_spec_java_spring_final_v2.service;

import org.example.tech_spec_java_spring_final_v2.model.User;

public interface UserService {
    User create(User user);

    User getInfo(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
