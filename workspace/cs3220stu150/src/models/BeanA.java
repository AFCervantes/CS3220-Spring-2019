package models;

import java.util.ArrayList;
import java.util.List;

public class BeanA {

    int id = 0;

    String name = "cs3220";

    String[] weekdays = { "mon", "tue", "wed", "thr", "fri" };

    List<Integer> numbers;

    public BeanA()
    {
        numbers = new ArrayList<Integer>();
        for( int i = 0; i < 10; ++i )
            numbers.add( 100 + i );
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String[] getWeekdays()
    {
        return weekdays;
    }

    public void setWeekdays( String[] weekdays )
    {
        this.weekdays = weekdays;
    }

    public List<Integer> getNumbers()
    {
        return numbers;
    }

    public void setNumbers( List<Integer> numbers )
    {
        this.numbers = numbers;
    }

}