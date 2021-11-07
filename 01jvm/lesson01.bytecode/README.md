javap -classpath /Users/ronglei/Dev/source/geekbang/lesson01.bytecode/target/classes/ -verbose -p Main
+ javap -p 为查看 class 文件字节码
+ -classpath 指定 class path 目录
+ -verbose 可选选项。输出包含：常量池等更为详细的信息。
---

当 javap 指令执行完成后，控制台会输出如下信息
```Shell
Classfile /Users/ronglei/Dev/source/geekbang/01jvm/lesson01.bytecode/target/classes/Main.class
  Last modified 2021-11-8; size 655 bytes
  MD5 checksum 9b83366ae898302665c30f3d3f064146
  Compiled from "Main.java"
public class Main
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#26         // java/lang/Object."<init>":()V
   #2 = Fieldref           #27.#28        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Methodref          #29.#30        // java/io/PrintStream.println:(I)V
   #4 = Class              #31            // Main
   #5 = Class              #32            // java/lang/Object
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               LocalVariableTable
  #11 = Utf8               this
  #12 = Utf8               LMain;
  #13 = Utf8               main
  #14 = Utf8               ([Ljava/lang/String;)V
  #15 = Utf8               i
  #16 = Utf8               I
  #17 = Utf8               args
  #18 = Utf8               [Ljava/lang/String;
  #19 = Utf8               a
  #20 = Utf8               b
  #21 = Utf8               result
  #22 = Utf8               StackMapTable
  #23 = Class              #18            // "[Ljava/lang/String;"
  #24 = Utf8               SourceFile
  #25 = Utf8               Main.java
  #26 = NameAndType        #6:#7          // "<init>":()V
  #27 = Class              #33            // java/lang/System
  #28 = NameAndType        #34:#35        // out:Ljava/io/PrintStream;
  #29 = Class              #36            // java/io/PrintStream
  #30 = NameAndType        #37:#38        // println:(I)V
  #31 = Utf8               Main
  #32 = Utf8               java/lang/Object
  #33 = Utf8               java/lang/System
  #34 = Utf8               out
  #35 = Utf8               Ljava/io/PrintStream;
  #36 = Utf8               java/io/PrintStream
  #37 = Utf8               println
  #38 = Utf8               (I)V
{
  public Main();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 8: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LMain;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=5, args_size=1
         0: iconst_1
         1: istore_1
         2: iconst_2
         3: istore_2
         4: iconst_0
         5: istore_3
         6: iconst_0
         7: istore        4
         9: iload         4
        11: iload_2
        12: if_icmpge     33
        15: iload_3
        16: iload_1
        17: iadd
        18: istore_3
        19: iload_3
        20: iconst_3
        21: if_icmple     27
        24: goto          33
        27: iinc          4, 1
        30: goto          9
        33: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        36: iload_3
        37: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        40: return
      LineNumberTable:
        line 10: 0
        line 11: 2
        line 13: 4
        line 15: 6
        line 16: 15
        line 18: 19
        line 19: 24
        line 15: 27
        line 23: 33
        line 24: 40
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            9      24     4     i   I
            0      41     0  args   [Ljava/lang/String;
            2      39     1     a   I
            4      37     2     b   I
            6      35     3 result   I
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 9
          locals = [ class "[Ljava/lang/String;", int, int, int, int ]
          stack = []
        frame_type = 17 /* same */
        frame_type = 250 /* chop */
          offset_delta = 5
}
SourceFile: "Main.java"

```

+ Classfile: 文件的基本信息，很容易理解
+ public: 包含 jdk 版本，52 代表 jdk 8. acc_public 修饰符 public,acc_super 代表有父类(这里是 java.lang.Object)
+ Constant: 执行命令的常量表，#1 操作有 #5 和 #26 两个操作构成。
+ line61: 通过 63 的 invoke special 知道调用构造函数，line 61 - 64 执行了 Main 的构造函数。构造函数代码里没有入参，但是 stack=1, locals=1, args_size=1，显示有1个参数呢，是因为构造函数里被传入 this 对象。
+ line76,77 -->int a=1
+ line78-79 --> int b=2;
+ line80,81 --> int result =0;
+ line82,83 --> int i=0; 
+ 整个for 循环被拆解为： if + cmp(compare) + goto 来达到循环控制（典型的 c语言 语法体现）
+ line86: if_icmpge --> if(integer > ?) 跳转到 33，跳转到9 。。。
+ line93 --> if_icmple --> if(integer < ?)，跳转到27，否则跳转到 33 。。。
+ for 循环 == if + cmp + goto，然后执行指令 iadd --> integer add 实现加法计算
+ line95：iinc --> integer increment，实现变量 i++
+ 0: iconst_1，7: istore        4：指令的不同表达方式。因为方法内，变量的个数是有限的，为了减少指令长度，达到减少字节码文件长度的目的，特地压缩的。当时变量超过5个后，指令恢复为：0: iconst 1
+ 遗漏项： javac -g。-g 代表编译时输出调试信息，可以更直观的理解字节码，留第二周完成！