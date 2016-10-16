package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

import java.util.List;

/*Чтобы понимать, в правильном ли направлении ты движешся, тебе надо видеть данные. Поэтому
        1. В пакете view создай класс UsersView, реализующий View. Он будет отображать список юзеров в консоль.*/

/**
 * Created by stas on 10/15/16.
 */
public class UsersView implements View
{

    private Controller controller;


    @Override
    public void refresh(ModelData modelData)
    {
        if (modelData.isDisplayDeletedUserList())
        {
            System.out.println("All deleted users:");
        }
        else
        {
            System.out.println("All users:");
        }

        List<User> users = modelData.getUsers();

        for (User user: users)
        {
            System.out.println("\t"+ user);
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

   // Добавь в UsersView публичный метод void fireEventShowAllUsers(), который сэмулирует событие клиента.
   public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers()
    {
        controller.onShowAllDeletedUsers();

    }


    public void fireEventOpenUserEditForm(long id)
    {
        controller.onOpenUserEditForm(id);
    }


}
