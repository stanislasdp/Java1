package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by stas on 7/23/16.
 */
public class Snake

{
    ArrayList<SnakeSection> sections;
    boolean isAlive;
    SnakeDirection direction;

    public Snake( int x, int y)
    {
        sections  = new ArrayList<>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;

    }

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    public boolean isAlive()
    {
        return isAlive;
    }


    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public int getX()
    {
        return sections.get(0).getX();
    }

    public int getY()
    {
        return sections.get(0).getY();
    }

    public void move()
    {
        int temp_x, temp_y;
        if (sections.size()!=0 && sections!=null)
        {
            if (this.getDirection().equals(SnakeDirection.DOWN))
            {
                this.sections.remove(this.sections.size() -1);
                temp_y = this.sections.get(0).getY();
                System.out.println(sections.size());
                sections.add(0,new SnakeSection(sections.get(0).getX(),--temp_y));
            }

            if (this.getDirection().equals(SnakeDirection.UP))
            {
                this.sections.remove(this.sections.size() -1);
                temp_y = this.sections.get(0).getY();
                sections.add(0,new SnakeSection(sections.get(0).getX(),++temp_y));
            }
            if (this.getDirection().equals(SnakeDirection.LEFT))
            {
                this.sections.remove(this.sections.size() -1);
                temp_x = this.sections.get(0).getX();
                sections.add(0,new SnakeSection(++temp_x,sections.get(0).getY()));
            }
            if (this.getDirection().equals(SnakeDirection.RIGHT))
            {
                this.sections.remove(this.sections.size() -1);
                temp_x = this.sections.get(0).getX();
                sections.add(0,new SnakeSection(--temp_x,sections.get(0).getY()));
            }
        }






       /* Задание 15
        Теперь осталось допилить змею.
        Вот что я предлагаю насчет движения змеи:
    Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
        а самый последний - удалять. Тогда получится, что змея ползет.

        Добавлять кусочек нужно рядом с текущей головой (кусочком номер 0).
            С какой стороны добавлять зависит от direction (UP, DOWN, LEFT, RIGHT).
        Подсказка:
        а) Как добавить кусочек змеи в начало списка sections?
        sections.add(0, new_section);
        б) А как удалить последний?
        sections.remove(sections.size()-1);

        В методе move надо:
        а) сделать шаг в текущем направлении (определяется direction)
        б) проверить, что если змея уперлась в стену, то умереть (isAlive = false)
        в) проверить, что если змея уперлась себя, то умереть (isAlive = false)
        г) проверить, если змея встретила мышь - то съесть ее.*/

    }


}
