package cn.syhg.tax;

import java.util.Scanner;

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
public class Test {
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
	public static void main(String[] args) throws MyException {
		DoctoralCandidate doctoralfirst=new DoctoralCandidate(1,"Karry","男",21);
		Scanner scanner=new Scanner(System.in);
		try{
			System.out.println("请输入你的编号：");
			int num=scanner.nextInt();
			if(num==doctoralfirst.getNum()){
				System.out.println(doctoralfirst.toString());		
				System.out.println("请输入你的学费：");
				double tuition=scanner.nextDouble();
				doctoralfirst.payTuition(tuition);
				checkSalary(tuition);
				System.out.println("请输入你的月工资：");
				double salary=scanner.nextDouble();
				doctoralfirst.paySalary(salary);
				checkSalary(salary);		
				double calculateTuitionSum=doctoralfirst.calculateTuitionSum(tuition);
				double calculateSalarySum=doctoralfirst.calculateSalarySum(salary);
				double tax=doctoralfirst.calculateTax(calculateTuitionSum, calculateSalarySum);
				double income=doctoralfirst.calculateIncome(calculateTuitionSum, calculateSalarySum);
				System.out.println("博士研究生姓名："+doctoralfirst.name+"\t实际收入："+doctoralfirst.income+"\t年应纳税金额为："+tax);
			}else{
				System.out.println("没有此人的信息！");
			}
		}
		catch(MyException e){
			System.out.println(e.warnness());
		}
		
	}

}
