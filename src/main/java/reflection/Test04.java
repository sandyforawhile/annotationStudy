package reflection;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
获取类的信息
 */
public class Test04 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class clz = Class.forName("reflection.User");

        //获取类名
        System.out.println(clz.getName());
        System.out.println(clz.getSimpleName());

        //获取属性
        Field[] fields;
        fields = clz.getFields(); //含本类+父类public
        fields = clz.getDeclaredFields(); //仅本类全部属性
        Field field = clz.getDeclaredField("name");//获取指定属性

        //获取方法
        Method[] methods;
        methods = clz.getMethods(); //含本类+父类public
        methods = clz.getDeclaredMethods(); //仅本类全部方法
        Method method = clz.getDeclaredMethod("setName",String.class); //获取指定方法

        //获取构造函数
        Constructor[] constructors;
        constructors = clz.getConstructors(); //含本类+父类public
        constructors = clz.getDeclaredConstructors();//仅本类全部属性
        Constructor constructor = clz.getDeclaredConstructor(String.class);//获取指定构造器
    }

}
