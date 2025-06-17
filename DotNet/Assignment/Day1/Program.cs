using System.Net;

namespace Day1
{
    internal class Program
    {
        static void Main()
        {
            Employee o1 = new Employee(1, "Amol", 123465, 10);
            Employee o2 = new Employee(1, "Amol", 123465);
            Employee o3 = new Employee(1, "Amol");
            Employee o4 = new Employee(1);
            Employee o5 = new Employee();

            static void PrintEmployee(Employee emp)
            {
                Console.WriteLine("EmpNo: " + emp.EmpNo);
                Console.WriteLine("Name: " + emp.Name);
                Console.WriteLine("Basic: " + emp.Basic);
                Console.WriteLine("DeptNo: " + emp.DeptNo);
                Console.WriteLine("Net Salary: " + emp.GetNetSalary());
                Console.WriteLine("----------------------------------");
            }

            PrintEmployee(o1);
            PrintEmployee(o2);
            PrintEmployee(o3);
            PrintEmployee(o4);
            PrintEmployee(o5);





        }
    }

    public class Employee
    {

        //fields
        private string name;
        public string Name
        {
            set
            {
                if (value.Trim() == null || value.Trim().Length == 0)
                {
                    Console.WriteLine("Name can not be null");
                }
                else
                    name = value;
            }
            get
            {

                return name;
            }
        }

        private int empno;
        public int EmpNo
        {
            set
            {
                if (value > 0)
                {
                    empno = value;
                }
                else
                {
                    Console.WriteLine("Cant be less than 0");
                }
            }
            get
            {
                return empno;
            }

        }
        private decimal basic;
        public decimal Basic
        {
            set
            {
                if (value > 25000 && value <= 30000)
                {
                    basic = 28000;
                }
                else if (value > 30000)
                {
                    basic = 32500;
                }
                else
                {
                    Console.WriteLine("Enter valid salary");
                }



            }
            get
            {
                return basic;
            }
        }
        private short deptno;
        public short DeptNo
        {
            set
            {
                if (value > 0)
                {
                    deptno = value;
                }
                else
                {
                    Console.WriteLine("Enter valid department number");
                }
            }
            get
            {
                return deptno;
            }
        }

        public Employee()
        {

        }

        public Employee(int EmpNo = 0, string Name = "", decimal Basic = 0, short DeptNo = 0)
        {
            this.Name = Name;
            this.EmpNo = EmpNo;
            this.DeptNo = DeptNo;
            this.Basic = Basic;

        }


        public decimal GetNetSalary()
        {
            return Basic + 20000.0M - 3000.0M;
        }


    }
}
/*
 Create a Class Employee with the following specifications

Properties
----------
string Name -> no blank names should be allowed
int EmpNo -> must be greater than 0
decimal Basic -> must be between some range
short DeptNo -> must be > 0

Methods
-------
decimal GetNetSalary() -> returns calculated net salary (Use any formula to get net salary based on Basic salary)

Create constructors to accept initial values for Employee obj
eg
Employee o1 = new Employee(1,"Amol",123465, 10);
Employee o2 = new Employee(1,"Amol",123465);
Employee o3 = new Employee(1,"Amol");
Employee o4 = new Employee(1);
return Basic + 20000.0M - 3000.0M;

 */