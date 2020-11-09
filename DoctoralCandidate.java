package cn.syhg.tax;
//学生管理接口
interface StudentManagement {
	void payTuition(double pt);//缴纳学费
	void inquireTuition(double it);//查学费
}
//老师管理接口
interface TeacherManagement {
	void paySalary(double ps);//发放工资
	void inquireSalary(double is);//查询工资
}
//税收接口
interface Tax {
	int standard0= 5000;
	int standard1= 8000;
	int standard2= 17000;
	double rate1=0.03;
	double rate2=0.1;
}
//硕士研究生类实现接口StudentManagement,TeacherManagement,Tax
public class DoctoralCandidate implements StudentManagement,TeacherManagement,Tax{
	
	String name;
	String sex;
	int age;
	double tuition;//学费
	double salary;//工资
	double tax;//税
	double tuitionSum;//一年的总学费
	double salarySum;//一年的总工资
	
	//计算一年的总学费和一年的总工资
	public double calculateTuitionSum(double tuition){
		tuitionSum=tuition*2;
		return tuitionSum;
	}
	public double calculateSalarySum(double salary){
		salarySum=salary*12;
		return salarySum;
	}
	//计算税收
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
	//重写接口中的方法
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
	//构造方法
	public DoctoralCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctoralCandidate(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		
	}
	//set（），get()方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getTuition() {
		return tuition;
	}
	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTuitionSum() {
		return tuitionSum;
	}
	public void setTuitionSum(double tuitionSum) {
		this.tuitionSum = tuitionSum;
	}
	public double getSalarySum() {
		return salarySum;
	}
	public void setSalarySum(double salarySum) {
		this.salarySum = salarySum;
	}
	//toString()方法
	public String toString() {
		return "硕士研究生的姓名：" + name + "\t 性别：" + sex + "\t 年龄："+ age ;
	}
	
}
