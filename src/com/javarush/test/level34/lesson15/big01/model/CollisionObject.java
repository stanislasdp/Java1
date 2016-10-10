package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by stas on 10/10/16.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

   public boolean isCollision(GameObject gameObject, Direction direction)
    {
        boolean isCollided = false;
        switch (direction)
        {
            case UP:
                if (this.getY()- Model.FIELD_SELL_SIZE == gameObject.getY()
                        && this.getX() == gameObject.getX())
                {
                    isCollided = true;
                }
                break;
            case DOWN:
                if (this.getY() + Model.FIELD_SELL_SIZE == gameObject.getY()
                        && this.getX() == gameObject.getX())
                {
                    isCollided = true;
                }

                break;
            case LEFT:
                if (this.getX() - Model.FIELD_SELL_SIZE == gameObject.getX()
                        && this.getY() == gameObject.getY())
                {
                    isCollided = true;
                }
                break;
            case RIGHT:
                if (this.getX() + Model.FIELD_SELL_SIZE == gameObject.getX()
                        && this.getY() == gameObject.getY())
                {
                    isCollided = true;
                }
                break;
        }
        return isCollided;
    }
}
