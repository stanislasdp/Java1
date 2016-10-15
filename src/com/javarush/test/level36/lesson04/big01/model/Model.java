package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by stas on 10/15/16.
 */
/*используя любую модель должна быть возможность получить все необходимые данные для отображения. Поэтому
        в пакете model создай интерфейс Model, который должен содержать метод ModelData getModelData()*/
public interface Model
{
    ModelData getModelData();

    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);




}
