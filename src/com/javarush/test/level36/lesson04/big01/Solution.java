package com.javarush.test.level36.lesson04.big01;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.MainModel;
import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

//Класс Solution будет эмулятором пользователя

public class Solution {
    public static void main(String[] args)
    {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView usersActiveView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        usersActiveView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(usersActiveView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventShowDeletedUsers();
        usersView.fireEventOpenUserEditForm(126);
        usersActiveView.fireEventUserDeleted(126);
        usersView.fireEventShowAllUsers();


        /////////////////////////////
        usersView.fireEventOpenUserEditForm(123);
        usersActiveView.fireEventUserChanged("Stas",123,5);




    }
}
