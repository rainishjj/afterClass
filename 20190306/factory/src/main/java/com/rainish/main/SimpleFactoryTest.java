package com.rainish.main;

import com.rainish.simpleFactory.IProduct;
import com.rainish.simpleFactory.SimpleFactory;

import java.text.SimpleDateFormat;

/**
 * Hello world!
 *
 */
public class SimpleFactoryTest
{
    public static void main( String[] args )
    {
        SimpleFactory simpleFactory = new SimpleFactory();
        IProduct product = simpleFactory.createProduct("productB");
        product.producer();
    }
}
