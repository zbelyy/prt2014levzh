/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.unideb.inf.prt.levzh;

/**
 *
 * @author zbocskay
 */
public class ReflectionException extends RuntimeException{  
    
    public ReflectionException(Exception e){
        super(e);      
    }
    
    public ReflectionException(String message){
        super(message);      
    }
    
    public ReflectionException(String message, Exception e){
        super(message,e);      
    }
}
