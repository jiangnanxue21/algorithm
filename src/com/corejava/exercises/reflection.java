package com.corejava.exercises;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by xue on 15/8/25.
 */
public class reflection {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in) ;
        String name = scanner.next() ;
        try {
            Class cl = Class.forName(name) ;
            Class superCl = cl.getSuperclass() ;
            String modifiers = Modifier.toString(cl.getModifiers()) ;
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print("class "+name);
            if (superCl!=null&&superCl!=Object.class)
                System.out.println("extends "+superCl.getName());
            System.out.println("{");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printField(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors() ;
        for (Constructor c:constructors)
        {
            String name = c.getName() ;
            System.out.println("    ");
            String modifiers = Modifier.toString(c.getModifiers()) ;
            if (modifiers.length()>0) System.out.println(modifiers+" ");
            System.out.println(name+"(");

            Class[] paramType = c.getParameterTypes() ;
            for (int i = 0 ;i < paramType.length; i++)
            {
                if (i > 0 ) System.out.println(", ");
                System.out.println(paramType[i].getName());
            }
            System.out.printf(");");
        }

    }

    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods() ;
        for (Method m :methods)
        {
            String name = m.getName() ;
            System.out.println("    ");
            String modifiers = Modifier.toString(m.getModifiers()) ;
            System.out.println(modifiers+" "+name+"(");

            Class[] param = m.getParameterTypes() ;
            for (int i = 0 ; i< param.length ; i++)
            {
                if (i > 0 ) System.out.println(", ");
                System.out.println(param[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printField(Class cl)
    {
        Field[] fields = cl.getDeclaredFields() ;
        for (Field f : fields)
        {
            String name = f.getName() ;
            Class type = f.getType() ;
            String modifiers = Modifier.toString(f.getModifiers()) ;
            System.out.printf("    ");
            if (modifiers.length() > 0 ) System.out.println(modifiers);
            System.out.println(type.getName()+"  "+name+";");
        }
    }
}
