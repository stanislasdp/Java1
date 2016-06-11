package com.javarush.test.level16.lesson13.bonus01;

/**
 * Created by stas on 6/11/16.
 */

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by stas on 6/11/16.
 */
public  class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes im)
    {
        if (im==ImageTypes.JPG)
        {
            return new JpgReader();
        }
        else if (im==ImageTypes.PNG)
        {
            return  new PngReader();
        }
        else if (im==ImageTypes.BMP)
        {
            return  new BmpReader();
        }
        else
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }
}
