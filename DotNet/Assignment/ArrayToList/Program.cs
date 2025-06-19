Employee[] empArray = new Employee[3];
empArray[0] = new Employee { EmpNo = 1, Name = "Alice", Salary = 50000 };
empArray[1] = new Employee { EmpNo = 2, Name = "Bob", Salary = 60000 };
empArray[2] = new Employee { EmpNo = 3, Name = "Charlie", Salary = 55000 };

// Step 2: Convert array to List<Employee>
List<Employee> empList = new List<Employee>(empArray);

// Step 3: Display all Employees in the list
Console.WriteLine("=== All Employees in the List ===");
foreach (Employee emp in empList)
{
    emp.Display();
}