package reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/*
反射操作注解
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("reflection.Student");
        Table table = aClass.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        Field field = aClass.getField("name");
        Column column = field.getAnnotation(Column.class);
        String name = column.columnName();
        String type = column.type();
        int id = column.length();
    }
}

@Table("db_student")
class Student{
    @Column(columnName = "name",type = "varchar",length = 20)
    String name;
    @Column(columnName = "age",type = "int",length =10)
    int age;
    @Column(columnName = "id" ,type = "int",length = 10)
    int id;

    Student() { }

    Student(String name,int age,int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}


//类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column{
    String columnName();
    String type();
    int length();
}
