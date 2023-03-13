package ru.drogunov;

import ru.drogunov.controllers.Actions;
import ru.drogunov.view.View;

public class Main {
    
    public static void main(String[] args) {
        String action = null;
        String path = null;
        if (args.length == 0) {
            action = "MENU";
        } else if (args.length == 1){
            action = "FILE";
            path = args[0];
        } else if(args.length == 2){
            action = args[0];
            path = args[1];
        } else {
            System.out.println("максимальное количество агру ментов 2");
        }
        
        View view = Actions.find(action);
        view.run(path);
    }
}
