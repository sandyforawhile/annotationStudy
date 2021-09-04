#注解与反射
##动态语言VS静态语言
动态语言：在运行时可以改变其结构的语言。主要的动态语言：Object-C，C#，JavaScript，PHP,Python
静态语言：运行时不可以改变的语言。例如：Java，C，C++

**Java是一门准动态语言,因为反射机制允许程序在执行期借助Reflection API取得任何类的内部信息。
并能直接操作任意对象的内部属性及方法。**

类加载完后，在堆内存的方法区就创建了一个Class类型的对象。可以通过这个对象得到类的结构。

+  普通方式
引入需要的"包类"名称 -> 通过New实例化 -> 取得实例化对象
+  反射方式
实例化对象 -> getClass()方法 -> 得到完整的包类名称
   
##Java反射
###Java反射提供的功能
+ 在运行时判任意一个对象所属的类
+ 在运行时构造任意个类的对象
+ 在运行时判断任意一个类所具有的成员变量和方法
+ 在运行时调用任意一个对象的成员变量和方法
+ 在运行时候获取泛型
+ **在运行时处理注解**
+ **生成动态代理**

###Class类
+ Class本身也是一个类
+ Class对象只能是JVM建立对象
+ 一个Class对象对应 的是一个加载到JVM中的一个.class文件
+ 一个加载的类在JVM中只会有一个Class实例
+ 通过Class可以万政府的得到一个类中所有被加载的结构
+ Class类是Reflection的根源

####获取Class类的方法
+ Class clz = User.class;
+ Class clz = User.getClass();
+ Class clz = Class.forName("com.xxx.xxx.User"");


###Java内存分析
+ 堆：存放对象和数据；可以被所有的线程共享；
+ 栈：存放基本类型变量（包含这个基本类型的具体数值）；引用对象的变量（存放这个引用在堆中的地址）；
+ 方法区（特殊的堆）：包含所有的类信息；静态变量和方法；常量池；可以被所有线程共享；

###类的加载过程
**类的加载 -> 类的链接 -> 类的初始化**
+ 类的加载：将.class字节码文件读入内存，将这些静态数据转换成方法区运行时数据结构，
  并在堆中创建java.lang.class对象；
+ 类的链接：将类的二进制数据合并到JRE中；并设置*类变量默认系统初始值*；
  虚拟机常量池中的符号引用（常量名）替换为直接引用；
+ 类的初始化：JVM对类进行初始化；执行类构造器方法（clinit()），类构造器方法是类中所有静态变量和静态方法合并产生的；
  当初始化一个类时，若其父类没有初始化，则先初始化其父类；

####类的初始化
**类何时会初始化：类的主动引用**
+ 虚拟机启动时，会先初始化main()方法所在的类
+ new一个类的对象
+ 调用类的静态成员（除final常量）和静态方法
+ 当初始化一个类，如果他的父类没有被初始化，则会先初始化它的父类
+ 使用java.lang.reflection包的方法对类进行反射调用

**类不会初始化：类的被动引用**
+ 当访问一个静态域时，只有真正声明这个域的类才会被初始化。例如：当通过子类引用父类的静态变量，不会导致子类的初始化。
+ 引用常量不会触发此类的初始化（常量在类的链接阶段就存入常量池）
+ 通过数组定义任意类的引用，不会触发此类的初始化

####类的装载器
作用：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后在队中
生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问入口。
+ 引导类加载器（根加载器）：用C++编写，是JVM自带的类加载器，负责**Java平台核心类库**的加载。该加载器无法直接获取。
+ 扩展加载器：负责jre/lib/ext目录下的jar包 或 -D java.ext.dirs 指定目录下的jar包装入工作库
+ 系统类加载器（App加载器）：负责 -D java.class.path所指的目录下的类与jar包装入，是最常用的类加载器

###反射操作泛型
Java采用泛型擦除的机制来引入泛型,Java中的泛型仅仅是给编译器javac使用的, 确保数据的安全性和免去强制类型转换.
一旦变异完成,所有和泛型有关的类型全部擦除。


