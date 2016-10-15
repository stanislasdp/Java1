package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 10/15/16.
 */
public class FakeModel implements Model
{
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

/*    В интерфейсе Model создай метод void loadUsers().
    Реализуй его в FakeModel: инициализируй список юзеров в modelData любыми данными. Они не влияют на тестирование.
    У меня такие данные:
    User{name='A', id=1, level=1}
    User{name='B', id=2, level=1}*/
    @Override
    public void loadUsers()
    {
        List<User> testUsers = new ArrayList<User>()
        {{

            add(new User("A",1,1));
            add(new User("B",2,1));

        }};
        modelData.setUsers(testUsers);

    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId)
    {
        throw new  UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id)
    {
       throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        throw new UnsupportedOperationException();
    }
}
