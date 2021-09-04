package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.SplittableRandom;

/*
通过反射动态创建对象
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> aClass = Class.forName("reflection.User");

        //构造一个对象：1.一个无参构造器，2.访问权限：public
        User user = (User) aClass.newInstance();
        System.out.println(user);

        //通过构造器创建一个对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        User user2 = (User) declaredConstructor.newInstance("sandy Hao");
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) aClass.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"Monica Li");
        System.out.println(user3);

        //通过反射操作属性
        User user4 = (User) aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true); //取消访问权限检测，才能操作私有属性
        name.set(user4,"coco Wu");
        System.out.println(user4);
    }
}
