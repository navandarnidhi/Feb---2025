using System;

namespace InheritanceAssignment
{
    interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public abstract class Employee : IDbFunctions
    {
        string name;
        short deptNo;
        decimal basic;
        static int count;

        public Employee(string Name = "default", decimal Basic = 20000, short DeptNo = 1)
        {
            EmpNo = ++count;
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }

        public string Name
        {
            get => name;
            set
            {
                if (!string.IsNullOrWhiteSpace(value))
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }

        public int EmpNo { get; }

        public short DeptNo
        {
            get => deptNo;
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Invalid DeptNo");
            }
        }

        public abstract decimal Basic { get; set; }
        public abstract decimal CalcNetSalary();

        public virtual void Insert() => Console.WriteLine("Insert to DB - Employee");
        public virtual void Update() => Console.WriteLine("Update to DB - Employee");
        public virtual void Delete() => Console.WriteLine("Delete from DB - Employee");
    }

    public class Manager : Employee, IDbFunctions
    {
        string designation;
        decimal basic;

        public Manager(string Name = "default", decimal Basic = 30000, short DeptNo = 1, string Designation = "Manager")
            : base(Name, Basic, DeptNo)
        {
            this.Designation = Designation;
            this.Basic = Basic;
        }

        public string Designation
        {
            get => designation;
            set
            {
                if (!string.IsNullOrWhiteSpace(value))
                    designation = value;
                else
                    Console.WriteLine("Invalid Designation");
            }
        }

        public override decimal Basic
        {
            get => basic;
            set
            {
                if (value >= 25000 && value <= 90000)
                    basic = value;
                else
                    Console.WriteLine("Invalid Basic for Manager");
            }
        }

        public override decimal CalcNetSalary()
        {
            return Basic + (Basic * 0.25m);
        }

        public new void Insert() => Console.WriteLine("Insert to DB - Manager");
        public new void Update() => Console.WriteLine("Update to DB - Manager");
        public new void Delete() => Console.WriteLine("Delete from DB - Manager");
    }

    public class GeneralManager : Manager, IDbFunctions
    {
        public string Perks { get; set; }

        public GeneralManager(string Name = "default", decimal Basic = 40000, short DeptNo = 1, string Designation = "GM", string Perks = "Car")
            : base(Name, Basic, DeptNo, Designation)
        {
            this.Perks = Perks;
            this.Basic = Basic;
        }

        public override decimal Basic
        {
            get => base.Basic;
            set
            {
                if (value >= 35000 && value <= 95000)
                    base.Basic = value;
                else
                    Console.WriteLine("Invalid Basic for General Manager");
            }
        }

        public override decimal CalcNetSalary()
        {
            return Basic + (Basic * 0.35m);
        }

        public new void Insert() => Console.WriteLine("Insert to DB - GeneralManager");
        public new void Update() => Console.WriteLine("Update to DB - GeneralManager");
        public new void Delete() => Console.WriteLine("Delete from DB - GeneralManager");
    }

    public class CEO : Employee, IDbFunctions
    {
        private decimal basic;

        public CEO(string Name = "default", decimal Basic = 50000, short DeptNo = 1)
            : base(Name, Basic, DeptNo)
        {
            this.Basic = Basic;
        }

        public override decimal Basic
        {
            get => basic;
            set
            {
                if (value >= 50000 && value <= 150000)
                    basic = value;
                else
                    Console.WriteLine("Invalid Basic for CEO");
            }
        }

        public sealed override decimal CalcNetSalary()
        {
            return Basic + (Basic * 0.5m);
        }

        public new void Insert() => Console.WriteLine("Insert to DB - CEO");
        public new void Update() => Console.WriteLine("Update to DB - CEO");
        public new void Delete() => Console.WriteLine("Delete from DB - CEO");
    }

    class Program
    {
        static void Main(string[] args)
        {
            Employee e1 = new Manager("Nidhi", 40000, 10, "Tech Lead");
            Employee e2 = new GeneralManager("Namrata", 50000, 20, "Operations Head", "Laptop");
            Employee e3 = new CEO("Ravi", 100000, 30);

            Console.WriteLine($"{e1.GetType().Name} Name: {e1.Name}, EmpNo: {e1.EmpNo}, NetSalary: {e1.CalcNetSalary():F2}");
            Console.WriteLine($"{e2.GetType().Name} Name: {e2.Name}, EmpNo: {e2.EmpNo}, NetSalary: {e2.CalcNetSalary():F2}");
            Console.WriteLine($"{e3.GetType().Name} Name: {e3.Name}, EmpNo: {e3.EmpNo}, NetSalary: {e3.CalcNetSalary():F2}");

            // Call interface methods
            ((IDbFunctions)e1).Insert();
            ((IDbFunctions)e2).Update();
            ((IDbFunctions)e3).Delete();
        }
    }
}
