package org.example.hexlet.dto.users;

import java.util.List;

import org.example.hexlet.model.User;
import org.example.hexlet.dto.main.BasePage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPage extends BasePage {
    private List<User> users;
    private String header;
}
