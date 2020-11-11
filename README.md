# JavaInterface
Java第四次实验——接口及异常实验
# 计G201 武美娟 2020322065

# 实验四

## 一、实验目的
1. 掌握Java中抽象类和抽象方法的定义； 
2. 掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法；
3. 了解异常的使用方法，并在程序中根据输入情况做异常处理。
## 二、实验要求
1. 某学校为了给学生提供勤工俭学机会，也减轻授课教师的部分压力，准许博士研究生参与课程的助教工作。此时，该博士研究生有双重身份：学生和助教教师。  
   * 设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。
   * 设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。
   * 编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额
2. 在博士研究生类中实现各个接口定义的抽象方法;  
   对年学费和年收入进行统计，用收入减去学费，求得纳税额；  
   国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用static  final修饰定义；
   实例化研究生类时，可采用运行时通过main方法的参数args一次性赋值，也可采用Scanner类实现运行时交互式输入；
   根据输入情况，要在程序中做异常处理。
## 三、实验过程
1. 创建接口：
       学生管理接口包括缴纳学费、查学费的方法；
       教师管理接口包括发放薪水和查询薪水的方法；
       税收接口包括计算税率的数据。
2. 创建硕士研究生类DoctoralCandidate实现接口StudentManagement,TeacherManagement,Tax
   重写学生管理接口，教师管理接口和税收接口中的所有方法；
   硕士研究生有属性：编号，姓名，性别，年龄，学费，工资，一年的总学费，一年的总工资，一年的总收入;   
   要求setNumber(int number)方法将参数number的值赋值给number，要求getNumber()返回number的值；   
   创建DoctoralCandidate类的构造方法，实例化对象;  
   创建toString()方法，返回DoctoralCandidate的信息。 
 5. 创建主类Test类
  * main方法中创建两个Student对象stu1、stu2,stu1将自己的属性：编号，姓名，性别，年龄，民族,设置为(1,"Karry","男",21,"汉族"),stu2将自己的属性：编号，姓名，性别，年龄，民族设置为(2,"鹿晗","男",21,"汉族");
  * main方法中创建两个Teacher对象tea1、tea2,tea1将自己的属性：编号，姓名，性别，年龄，民族,设置为(1,"Wang","女",31,"汉族"),tea2将自己的属性：编号，姓名，性别，年龄，民族设置为(2,"Wang","女",30,"汉族");
  * main方法中创建两个Course对象cour1、cour2,cour1将自己的属性：课程编号，课程名字，授课老师，上课地点，上课时间，课程学分设置为(1,"高数","Jackson","1教102","08:00-09:30",2.0),cour2将自己的属性：课程编号，课程名字，授课老师，上课地点，上课时间，课程学分设置为( );
  * stu1调用setCourse(Course course)方法，调用时实参是cour1,stu2调用setCourse(Course course)方法，调用时实参是cour2;
  * stu1调用setTeacher(String teacher)方法，调用时实参是tea1,stu2调用setTeacher(String teacher)方法，调用时实参是tea2;
  * 创建if-else()方法判断学生所选课程是否为空，若为空，输出该学生已经退课或还没有选课，否则，输出学生的信息，该学生所选课程的信息，该学生所选课程的老师的信息。
## 四、核心方法
1. 方法1:get(),set()方法
```
public int getNumber() {
		return number;
}
public void setNumber(int number) {
		this.number = number;
}
 ```

## 五、实验结果
  运行成功，输出结果：  
  
  ![img](https://p.qlogo.cn/qqmail_head/PiajxSqBRaEKWNg0BcGz3pTg6yE2DqrvMicXDJ6Zw45uy5UjNF76ZtianA68CxVA6tczq9D4Ricjz3w/0)
  
## 六、实验感想
  

