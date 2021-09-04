package loader;

public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器 -> 根加载器（引导类加载器）
        ClassLoader root = parent.getParent();
        System.out.println(root);

        ClassLoader classLoader = Class.forName("reflection.User").getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader2);

        //如何获取系统类加载器可以加载的路径
        System.getProperty("java.class.path");

        //双亲委派机制
        //自定义Java.lang.String不可用
    }
}


