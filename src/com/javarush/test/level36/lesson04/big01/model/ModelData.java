package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.List;

/**
 * Created by stas on 10/15/16.
 */
//ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.

public class ModelData
{
    //список юзеров для отображения.
    private List<User> users;
    private boolean displayDeletedUserList;
    private User activeUser;


    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }


    public boolean isDisplayDeletedUserList()
    {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList)
    {
        this.displayDeletedUserList = displayDeletedUserList;
    }
    public User getActiveUser()
    {
        return activeUser;
    }

    public void setActiveUser(User activeUser)
    {
        this.activeUser = activeUser;
    }
}
