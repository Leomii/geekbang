javap -classpath /Users/ronglei/Dev/source/geekbang/lesson01.bytecode/target/classes/ -verbose -p com.geekbang.Main
+ javap -p 为查看 class 文件字节码
+ -classpath 指定 class path 目录
+ -verbose 可选选项。输出包含：常量池等更为详细的信息。
---

当 javap 指令执行完成后，控制台会输出如下信息
```Shell
Classfile /Users/ronglei/Dev/source/geekbang/lesson01.bytecode/target/classes/com/geekbang/Main.class
  Last modified 2021-11-7; size 414 bytes
  MD5 checksum a0e696701568ceb56cc9fe7ab2f29155
  Compiled from "Main.java"
public class com.geekbang.Main
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#19         // java/lang/Object."<init>":()V
   #2 = Class              #20            // com/geekbang/Main
   #3 = Methodref          #2.#19         // com/geekbang/Main."<init>":()V
   #4 = Class              #21            // java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               LocalVariableTable
  #10 = Utf8               this
  #11 = Utf8               Lcom/geekbang/Main;
  #12 = Utf8               main
  #13 = Utf8               ([Ljava/lang/String;)V
  #14 = Utf8               args
  #15 = Utf8               [Ljava/lang/String;
  #16 = Utf8               obj
  #17 = Utf8               SourceFile
  #18 = Utf8               Main.java
  #19 = NameAndType        #5:#6          // "<init>":()V
  #20 = Utf8               com/geekbang/Main
  #21 = Utf8               java/lang/Object
{
  public com.geekbang.Main();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 10: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/geekbang/Main;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class com/geekbang/Main
         3: dup
         4: invokespecial #3                  // Method "<init>":()V
         7: astore_1
         8: return
      LineNumberTable:
        line 12: 0
        line 13: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  args   [Ljava/lang/String;
            8       1     1   obj   Lcom/geekbang/Main;
}
SourceFile: "Main.java"
```