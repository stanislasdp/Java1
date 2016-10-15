package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by stas on 10/15/16.
 */

/*Функционал отображения удаленных юзеров есть, а самих таких юзеров нет. Давай это исправим.
        Давай сделаем новую Вью, которая будет отвечать за редактирование одного конкретного юзера.
        UsersView отображает список пользователей.
        EditUserView будет отображать даннные о редактировании конкретного юзера.
        Для этого нам сначала нужен этот выбранный юзер.
        Как и любые данные его поместим в ModelData.*/

public class EditUserView implements View
{
    private Controller controller;


    @Override
    public void refresh(ModelData modelData)
    {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");


    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;

    }

   public void fireEventUserDeleted(long id)
    {
     controller.onOpenUserEditForm(id);
    }





}
