package org.example.hexlet.dto.users;

import java.util.List;

import org.example.hexlet.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPage {
    private List<User> users;
    private String header;
}
