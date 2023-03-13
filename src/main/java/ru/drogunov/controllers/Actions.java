package ru.drogunov.controllers;

import ru.drogunov.view.Console;
import ru.drogunov.view.Menu;
import ru.drogunov.view.View;

public enum Actions {
    FILE(new Console()),
    MENU(new Menu()),
    DEMO(new Console());
    
    private final View view;
//    String action, String[] arg
    Actions(View view) {
        this.view = view;
    }
    
    public static View find(String action) {
        if (action.matches(".+.json")) {
            action = "FILE";
        }
        
        return Actions.valueOf(action).view;
    }
}
