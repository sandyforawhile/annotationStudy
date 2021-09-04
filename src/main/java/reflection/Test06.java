package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/*
通过反射获取泛型
 */
public class Test06 {

    public void test0601(Map<String,User> map, List<User> list){
        System.out.println("test0601");
    }

    public Map<String,User> test0602(){
        System.out.println("test0602");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test06.class.getMethod("test0601", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for(Type genericParameterType:genericParameterTypes){
            System.out.println("参数："+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for(Type actualTypeArgument:actualTypeArguments){
                    System.out.println("真实参数："+actualTypeArgument);
                }
            }
        }

        Method method2 = Test06.class.getMethod("test0602", null);
        Type genericReturnType = method2.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for(Type actualTypeArgument:actualTypeArguments){
                System.out.println("返回值："+actualTypeArgument);
            }
        }
    }
}
