package Objects;

public class Employee {
	
	/**
	 * Properties
	 */
	int empNo, depNo, manager;
	String eName, hiredate, job;
	double salary, commission;
	
	
	public Employee(int empNo, int depNo, int manager, String eName, String hiredate, String job, double salary, double commission) {
		this.empNo = empNo;
		this.depNo = depNo;
		this.manager = manager;
		this.eName = eName;
		this.hiredate = hiredate;
		this.job = job;
		this.salary = salary;
		this.commission = commission;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public int getDepNo() {
		return depNo;
	}


	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}


	public int getManager() {
		return manager;
	}


	public void setManager(int manager) {
		this.manager = manager;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public double getCommission() {
		return commission;
	}


	public void setCommission(double commission) {
		this.commission = commission;
	}


	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", depNo=" + depNo + ", manager=" + manager + ", eName=" + eName
				+ ", hiredate=" + hiredate + ", job=" + job + ", salary=" + salary + ", commission=" + commission + "]";
	}
	
	
	
	
	
}
