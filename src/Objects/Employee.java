package Objects;

public class Employee {
	
	/**
	 * Properties
	 */
	int empNo, depNo, manager;
	String eName, hiredate, job;
	double salary, commission;
	
	
	public Employee(int empNo, String eName, String job, int manager, String hiredate, double salary, double commission, int depNo) {
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
		return "<tr><td>" + empNo + " - " + depNo + " - " + manager + " - " + eName
				+ " - " + hiredate + " - " + job + " - " + salary + " - " + commission
				+ "    " + "<a href='ServletApp?delete="+empNo+"'> <img src='./img/delete.png'> </a>"
				+ "    " + "<a href='ServletApp?mod="+empNo+"'> <img src='./img/edit.png'> </a>" + "</tr></td>";
	}
	
	
	
	
	
}
