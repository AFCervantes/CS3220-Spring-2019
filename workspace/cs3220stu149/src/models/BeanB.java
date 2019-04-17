package models;

import java.util.ArrayList;
import java.util.List;

public class BeanB {

    BeanA bean0;

    List<BeanA> beans;

    public BeanB()
    {
        bean0 = new BeanA();

        beans = new ArrayList<BeanA>();
        for( int i = 0; i < 10; ++i )
        {
            BeanA bean = new BeanA();
            bean.setId( i + 1 );
            beans.add( bean );
        }
    }

    public BeanA getBean0()
    {
        return bean0;
    }

    public void setBean0( BeanA bean0 )
    {
        this.bean0 = bean0;
    }

    public List<BeanA> getBeans()
    {
        return beans;
    }

    public void setBeans( List<BeanA> beans )
    {
        this.beans = beans;
    }

}