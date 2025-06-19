using System;

class Employee
{
    public int EmpNo;
    public string Name;
    public double Salary;

    public void Accept()
    {
        Console.Write("Enter Employee Number: ");
        EmpNo = int.Parse(Console.ReadLine());

        Console.Write("Enter Name: ");
        Name = Console.ReadLine();

        Console.Write("Enter Salary: ");
        Salary = double.Parse(Console.ReadLine());
    }

    public void Display()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary}");
    }
}

class Program
{
    static void Main()
    {
        Console.Write("Enter number of employees: ");
        int n = int.Parse(Console.ReadLine());

        Employee[] employees = new Employee[n];

        // Accept employee details
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine($"\nEnter details for Employee {i + 1}");
            employees[i] = new Employee();
            employees[i].Accept();
        }

        // Find employee with highest salary
        Employee highest = employees[0];
        for (int i = 1; i < n; i++)
        {
            if (employees[i].Salary > highest.Salary)
            {
                highest = employees[i];
            }
        }

        Console.WriteLine("\nEmployee with highest salary:");
        highest.Display();

        // Search by EmpNo
        Console.Write("\nEnter EmpNo to search: ");
        int searchEmpNo = int.Parse(Console.ReadLine());

        bool found = false;
        foreach (Employee emp in employees)
        {
            if (emp.EmpNo == searchEmpNo)
            {
                Console.WriteLine("Employee found:");
                emp.Display();
                found = true;
                break;
            }
        }

        if (!found)
        {
            Console.WriteLine("Employee not found.");
        }
    }
}
