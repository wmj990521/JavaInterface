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
       学生管理接口StudentManagement包括缴纳学费、查学费的方法；
       教师管理接口TeacherManagement包括发放薪水和查询薪水的方法；
       税收接口包括计算税率的数据。
2. 创建硕士研究生类DoctoralCandidate实现接口StudentManagement,TeacherManagement,Tax
   重写StudentManagement接口，TeacherManagement接口和Tax接口中的所有方法；
   硕士研究生有属性：编号，姓名，性别，年龄，学费，工资，一年的总学费，一年的总工资，一年的总收入;   
   要求setNum(int num)方法将参数num的值赋值给num，要求getNum()返回num的值；
   要求setName(String name)方法将参数name的值赋值给name，要求getName()返回name的值；
   要求setSex(String sex)方法将参数sex的值赋值给sex，要求getSex()返回sex的值；
   要求setAge(int age)方法将参数age的值赋值给age，要求getAge()返回age的值；
   要求setTuition(double tuition)方法将参数tuition的值赋值给tuition，要求getTuition()返回tuition的值；
   要求setSalary(double salary)方法将参数salary的值赋值给salary，要求getSalary()返回salary的值；
   创建DoctoralCandidate类的构造方法，实例化对象;  
   创建toString()方法，返回DoctoralCandidate的信息;
   创建calculateTax（）方法，计算税收；
   创建calculateTuitionSum（），calculateSalarySum（），calculateIncome（）计算一年的总学费和一年的总工资和一年总收入。
 3. 创建主类Test类
  * main方法中创建DoctoralCandidate对象doctoralfirst将自己的属性：编号，姓名，性别，年龄,设置为(1,"Karry","男",21)；
  * 使用if-else语句判断是否有此人的信息，如果有输出；
  * 使用Scanner类实现运行时交互式输入学费，工资；  
  * doctoralfirst调用calculateTuitionSum（）方法，调用时实参是输入的tuition；doctoralfirst调用calculateSalarySum（）方法，调用时实参是输入的salary；
  * doctoralfirst调用calculateIncome（）方法，计算一年的总收入；doctoralfirst调用calculateTax（）方法，计算税收；
  * 自定义异常，如果输入的学费或工资为负数，抛出异常。
## 四、核心方法
1. 方法1:定义接口
```
interface StudentManagement {
	void payTuition(double pt);//缴纳学费
	void inquireTuition(double it);//查学费
}
 ```
2. 方法2:实现接口并重写接口中的全部方法
```
public class DoctoralCandidate implements StudentManagement,TeacherManagement,Tax{
	public void paySalary(double ps) {
		// TODO Auto-generated method stub
		salary=ps;
	}
	public void inquireSalary(double is) {
		// TODO Auto-generated method stub
		
	}
	public void payTuition(double pt) {
		// TODO Auto-generated method stub
		tuition=pt;
	}
	public void inquireTuition(double it) {
		// TODO Auto-generated method stub
		
	}
}
 ```
3. 方法3:计算税收
```
public double calculateTax(double tuitionSum, double salarySum) {
	double sum = salarySum - tuitionSum;
	if (sum<=standard0*12) {
		tax = 0;
	} else if (sum >= standard0*12 && sum <= standard1*12) {
		tax = sum * rate1;
	} else if (sum >= standard1*12 && sum <= standard2*12) {
		tax = sum * rate2;
	}
	return tax;
}
 ```
4. 方法4:计算一年的总学费和一年的总工资和一年总收入
```
public double calculateTuitionSum(double tuition){
		tuitionSum=tuition*2;
		return tuitionSum;
	}
	public double calculateSalarySum(double salary){
		salarySum=salary*12;
		return salarySum;
	}
	public double calculateIncome(double tuitionSum,double salarySum){
		income=salarySum - tuitionSum;
		return income;
	}
 ```
5. 方法5:自定义异常
```
class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public MyException(int m) {
		message = "输入的学费或工资" + m + "为负数，不符合规定";
	}

	public String warnness() {
		return message;
	}
}
public static void checkTuition(double tuition) throws MyException {
		if (tuition <= 0) {
			throw new MyException((int) tuition);
		}
	}	
	public static void checkSalary(double salary) throws MyException {
		if (salary <= 0) {
			throw new MyException((int) salary);
		}
	}
 ```
6. 方法6:scanner类
```
Scanner scanner=new Scanner(System.in);
double tuition=scanner.nextDouble();
 ```
7. 方法7：try-catch块
``` 
try{
	System.out.println("请输入你的学费：");
	double tuition=scanner.nextDouble();
	doctoralfirst.payTuition(tuition);
	checkSalary(tuition);
	System.out.println("请输入你的月工资：");
	double salary=scanner.nextDouble();
	doctoralfirst.paySalary(salary);
	checkSalary(salary);		
}
catch(MyException e){
	System.out.println(e.warnness());
}
```
## 五、实验结果
  运行成功，输出结果：  
  ![img](https://p.qlogo.cn/qqmail_head/gWicbXPiajJn9xvkjMtjhZX8Z8MlIPx6oOUBn0uxIOn7uqBDOoaQmnyGkJe494I5t709iaJhjiblwPI/0)
  异常：
  ![img](https://p.qlogo.cn/qqmail_head/gWicbXPiajJn9xvkjMtjhZX8Z8MlIPx6oOUBn0uxIOn7tvx0ib3NKTR6YicCl2dwqtV6xTia3wVEpA0c/0)
## 六、实验感想
  学习了Java中抽象类和抽象方法的定义及实现，掌握了Java中接口的定义及接口的实现方法，学会了自定义异常的使用方法，学习使用了scanner类。

