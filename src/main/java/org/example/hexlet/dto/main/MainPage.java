package org.example.hexlet.dto.main;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MainPage {
    private Boolean visited;

    public Boolean isVisited() {
        return visited;
    }
}
