/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.unideb.inf.prt.levzh;
import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Czegledi
 */
public class AtLeastTenCharsServiceImpl implements AtLeastTenCharsService{

    @Override
    public List<Field> getAtLeastTenCharstMegsértőAdattagok(Object o) {
        List<Field> fieldList;
        Class<?> objClass;
        try{
            objClass = o.getClass();
            Field[] fields = objClass.getDeclaredFields();
            fieldList = new ArrayList<Field>();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(o);
                if (value instanceof String) {
                    if (((String) value).length() < 10) {
                        fieldList.add(field);
                    }
                }
            }
        }
        catch(SecurityException | IllegalAccessException | IllegalArgumentException e){
           throw new ReflectionException(e);
        }
        return fieldList;
        
    }

    @Override
    public void correctAtLeastTenCharsMegsértések(Object o)
            throws IllegalArgumentException {

        Class<?> objClass = o.getClass();
        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) {

            try {
                field.setAccessible(true);
                Object value = field.get(o);
                if (value instanceof String) {
                    String adaptedValue = (String) value;
                    while (adaptedValue.length() > 0 & adaptedValue.length() < 10) {
                        adaptedValue += value;
                    }
                    field.set(o, adaptedValue);
                   // System.out.println(adaptedValue);
                }
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AtLeastTenCharsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
}
