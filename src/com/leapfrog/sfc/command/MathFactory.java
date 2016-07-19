/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sfc.command;

/**
 *
 * @author Raghav
 */
public class MathFactory {
    public static MathCommand get(String key){
        if (key.equalsIgnoreCase("+")){
            return new AddCommand();
        }
        
        else if (key.equalsIgnoreCase("-")){
            return new SubCommand();
        }
        
        else if (key.equalsIgnoreCase("*")){
            return new MulCommand();
        }
        
        else if (key.equalsIgnoreCase("/")){
            return new DivCommand();
        }
        return null;
        }
    }

