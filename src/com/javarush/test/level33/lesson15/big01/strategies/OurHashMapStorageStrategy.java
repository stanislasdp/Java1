package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by stas on 10/8/16.
 */
public class OurHashMapStorageStrategy implements StorageStrategy
{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k)
    {
        return  k.hashCode();
    }


    int indexFor(int hash, int length)
    {
        return hash % (length -1);
    }

    //ndexFor(int,int) method  returns the first entry in the appropriate bucket. The linked
    //list in the bucket is then iterated over - (the end is found and the element is added or
    //the key is matched and the value is returned )


    Entry getEntry(Long key)
    {
        int hash = (key == null)? 0 : hash(key);

        if (table[indexFor(hash,table.length)] != null)
        {
            for (Entry e = table[indexFor(hash,table.length)];e !=null ; e = e.next)
            {
                Long k = null;
                if (e.hash == hash && ((k = e.getKey()) == key) || (key != null && key.equals(k)))
                {
                    return e;

                }
            }
        }
        return  null;
    }

    void resize(int newCapacity)
    {
        Entry [] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * DEFAULT_LOAD_FACTOR);


    }

    void transfer(Entry[] newTable)
    {
        int newCapacity = newTable.length;

        for (Entry e: table)
        {
            while (e !=null)
            {
                Entry next = e.next;//get reference to next entry
                int j = indexFor(e.hash,newCapacity);// calculate position in new increased table
                e.next = newTable[j];//next entry element = first element in corresponding bucket
                newTable[j] = e;
                e = next;//reference to entry is reference to next entry
            }
        }


    }

    void addEntry(int hash, Long key, String value, int bucketIndex)
    {
        if (size > threshold  && table[bucketIndex]!=null)
        {
            resize(table.length * 2);
            hash = key.hashCode();
            bucketIndex = indexFor(hash,table.length);
        }
        createEntry(hash,key,value,bucketIndex);

    }

    void createEntry(int hash, Long key, String value, int bucketIndex)
    {
        Entry e = table[bucketIndex];// reference to first entry in corresponding bucket
        table[bucketIndex] = new Entry(hash,key,value,e);//first element in corresponding bucket references to new Entry object
        // reference to old first element is stored in first (new) one
        size++;
    }

    @Override
    public boolean containsKey(Long key)
    {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value)
    {
        if (value == null || size < 1)
        {
            return false;
        }

        for (Entry e: table)
        {
            for (Entry eint = e; eint != null; eint = eint.next)
            {
                if (eint.value == value || value != null && eint.value.equals(value) )
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value)
    {
        addEntry(hash(key),key,value,indexFor(hash(key),table.length));
    }

    @Override
    public Long getKey(String value)
    {
        for (Entry e: table)
        {
            for (Entry eint = e;eint !=null; eint = eint.next)
            {
                if (eint.getValue().equals(value))
                {
                    return eint.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        return getEntry(key).getValue();
    }
}
