[toc]
# Java基础
## 一. Java概述
### 1.基本概念
- Java介于编译型语言和解释型语言之间
- 编译型语言如C、C++，代码是直接编译成机器码执行，但是不同的平台（x86、ARM等）CPU的指令集不同，因此，需要编译出每一种平台的对应机器码
- 解释型语言如Python、Ruby没有这个问题，可以由解释器直接加载源码然后运行，代价是运行效率太低
- Java是将代码编译成一种“字节码”，它类似于抽象的CPU指令，然后，针对不同平台编写虚拟机，不同平台的虚拟机负责加载字节码并执行，这样就实现了“一次编写，到处运行”的效果。当然，这是针对Java开发者而言。对于虚拟机，需要为每个平台分别开发。为了保证不同平台、不同公司开发的虚拟机都能正确执行Java字节码，SUN公司制定了一系列的Java虚拟机规范。从实践的角度看，JVM的兼容性做得非常好，低版本的Java字节码完全可以正常运行在高版本的JVM上。
随着Java的发展，SUN给Java又分出了三个不同版本：
  - JAVAEE：Java Platform Enterprise Edition，开发企业环境下的应用程序，主要针对web程序开发
  - JAVASE：Java Platform Standard Edition，完成桌面应用程序的开发，是其它两者的基础
  - JAVAME：Java Platform Micro Edition，开发电子消费产品和嵌入式设备，如手机中的程序

### 2.名词解释
- JDK：Java Development Kit（Java开发工具包）
- JRE：Java Runtime Environment（Java运行环境）
- JVM：Java Virtual Machine（Java虚拟机啊）


*JDK是整个JAVA的核心，包括了Java运行环境JRE（Java Runtime Envirnment）、一堆Java工具（javac/java/jdb等）和Java基础的类库（即Java API 包括rt.jar）。JDK中包含JRE，在JDK的安装目录下有一个名为jre的目录，里面有两个文件夹bin和lib，在这里可以认为bin里的就是jvm，lib中则是jvm工作所需要的类库，而jvm和 lib和起来就称为jre。*

*JRE中包含了Java virtual machine（JVM），runtime class libraries和Java application launcher，这些是运行Java程序的必要组件。与JDK不同，JRE是Java运行环境，并不是一个开发环境，所以没有包含任何开发工具（如编译器和调试器），只是针对于使用Java程序的用户。*

*JVM是整个java实现跨平台的最核心的部分，所有的java程序会首先被编译为.class的类文件，这种类文件可以在虚拟机上执行。也就是说class并不直接与机器的操作系统相对应，而是经过虚拟机间接与操作系统交互，由虚拟机将程序解释给本地系统执行。只有JVM还不能完成class的执行，因为在解释class的时候JVM需要调用解释所需要的类库lib，而jre包含lib类库。JVM屏蔽了与具体操作系统平台相关的信息，使得Java程序只需生成在Java虚拟机上运行的目标代码（字节码），就可以在多种平台上不加修改地运行。*

**简单来说就是JDK包含JRE,JRE又包含JVM的关系**

## 二. Java语法基础

