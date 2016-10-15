package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.Util;
import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 10/15/16.
 */
public class MainModel implements Model
{
    //Т.к. Модель обращается к сервисам, то в MainModel создай поле UserService userService, инициализируй объектом.
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
       List<User> usersBetweenTwoLevels = filter(userService.getUsersBetweenLevels(1,100));

        modelData.setUsers(usersBetweenTwoLevels);
        modelData.setDisplayDeletedUserList(false);

    }

    @Override
    public void loadDeletedUsers()
    {
        List<User> deletedUsers = userService.getAllDeletedUsers();
        modelData.setUsers(deletedUsers);
        modelData.setDisplayDeletedUserList(true);

    }

    @Override
    public void loadUserById(long userId)
    {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id)
    {
        userService.deleteUser(id);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1,100)));
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1,100)));
    }


    private List<User> filter(List<User> users)
    {
       return userService.filterOnlyActiveUsers(users);

    }


}
