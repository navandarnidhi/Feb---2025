namespace Day1
{
    internal class Program
    {
        public class Employee
        {

            string name; //-> no blank names should be allowed
            int empNo; //-> must be greater than 0
            decimal basic;// -> must be between some range
            short deptNo;// -> must be > 0
            
            public string Name
            {
                get
                {
                    return name;
                }
                set
                {
                    if (!string.IsNullOrEmpty(value))
                        name = value;
                    else
                        Console.WriteLine("Invalid Name");
                }
            }
            public int EmpNo
            {
                get { return empNo; }
                set
                {
                    if (value > 0)
                        empNo = value;
                    else
                        Console.WriteLine("invalid empno");
                }

            }
            public decimal Basic
            {
                get { return basic; }
                set
                {
                    if (value < 10000 || value > 100000)
                        Console.WriteLine("Invalid Basic");
                    else
                        basic = value;

                }
            }
            public short DeptNo
            {
                get { return deptNo; }
                set
                {
                    if (value > 0)
                        deptNo = value;
                    else
                        Console.WriteLine("Invalid EmpNo");
                }
            }
            public decimal GetNetSalary()
            {
                return Basic * 2;
            }
            public Employee(int EmpNo = 1, string Name = "Default", decimal Basic = 10000, short DeptNo = 1)
            {
                //this.empNo = EmpNo; //variable - no validations - DONT USE THIS
                this.EmpNo = EmpNo; //Property - set - validations are called
                this.Name = Name;
                this.Basic = Basic;
                this.DeptNo = DeptNo;
            }
        }


        static void Main(string[] args)
        {
            Employee emp = new Employee();
            emp.Name = "Nidhi";
            emp.EmpNo = 1;
            emp.Basic = 20000;
            emp.DeptNo = 1;

            Employee emp2 = new Employee(2, "Ravi");

            emp.GetNetSalary(); //-> 40000
            emp2.GetNetSalary(); //-> 20000

            Console.WriteLine($"EmpNo: {emp.EmpNo}, Name: {emp.Name}, Basic: {emp.Basic}, DeptNo: {emp.DeptNo}, Net Salary: {emp.GetNetSalary()}");
            Console.WriteLine($"EmpNo: {emp2.EmpNo}, Name: {emp2.Name}, Basic: {emp2.Basic}, DeptNo: {emp2.DeptNo}, Net Salary: {emp2.GetNetSalary()}");
        }
    }
}
