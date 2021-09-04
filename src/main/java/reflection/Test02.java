package reflection;

public class Test02 {

    //通过反射获取类的Class对象
    public static void main(String[] args) throws ClassNotFoundException {

        //一个类在内存中只有一个对象
        Class clz1 = Class.forName("reflection.User");
        System.out.println(clz1);

        User user = new Employee();
        System.out.println("这是雇员："+user.getName());

        //方式一：通过对象获得类
        Class<? extends User> aClass1 = user.getClass();

        //方式二：forName
        Class<?> aClass2 = Class.forName("reflection.Employee");

        //方式三：通过类名.class
        Class<Employee> aClass3 = Employee.class;

        System.out.println(aClass1.hashCode() + aClass2.hashCode() + aClass3.hashCode());

        //Class 方法
        //1. 获得父类类型
        Class<?> superclass = aClass1.getSuperclass();


    }

}

//pojo,entity
class User {
    public String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Employee extends User{
    public Employee() {
        this.name = "zhangsan";
    }
}

class Employer extends User{
    public Employer() {
        this.name = "lisi";
    }
}