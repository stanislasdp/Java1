package com.javarush.test.level23.lesson04.home01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T>
    {
        void refreshAllData(Map criteria);
    }

    private class TaskDataProvider implements DbDataProvider<Task>
    {


        @Override
        public void refreshAllData(Map criteria)
        {
            List tempTasksList = DbMock.getFakeTasks(criteria);

            if (tempTasksList!=null)
            {
                tasks = new ArrayList<Task>();
                tasks.addAll(tempTasksList);
            }
        }
    }


    private class NameDataProvider implements DbDataProvider<String>
    {

        @Override
        public void refreshAllData(Map criteria)
        {
            List tempNamesList = DbMock.getFakeNames(criteria);
            if (tempNamesList!=null)
            {
                names = new ArrayList<String>();
                names.addAll(tempNamesList);
            }
        }
    }

    class Task
    {
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();


        TaskDataProvider taskDataProvider = solution.new TaskDataProvider();
        System.out.println(solution.tasks);
        taskDataProvider.refreshAllData(new HashMap());
        System.out.println(solution.tasks);
        //taskDataProvider.refreshAllData(solution.nameDataProvider);
    }
}
