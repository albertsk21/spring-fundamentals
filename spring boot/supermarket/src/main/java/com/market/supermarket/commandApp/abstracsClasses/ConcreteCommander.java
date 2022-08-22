package com.market.supermarket.commandApp.abstracsClasses;

import com.market.supermarket.commandApp.interfaces.Commander;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public abstract class ConcreteCommander implements Commander {


    private BufferedReader reader;
    public ConcreteCommander() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    protected BufferedReader getReader() {
        return reader;
    }


    protected String getPrefixNameClassDto(Class<?> entityClass){

        String name = entityClass.getSimpleName().split("Dto")[0];
        name = String.valueOf(name.charAt(0)).toLowerCase() + name.substring(1);
       return name;
    }


}
