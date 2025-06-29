using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ModelBinding.Models;

namespace ModelBinding.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: EmployeesController
        //Employees/Index  
        public ActionResult Index()
        {
            List<Employee> emps = Employee.GetAllEmployees();
           
            return View(emps);
        }

        // GET: EmployeesController/Details/5
        //Employees/Details/123
        public ActionResult Details(int id)
        {
            Employee obj = Employee.GetSingleEmployee(id);

            if (obj == null)
            {
                // If the employee is not found, you can redirect to an error page or show a message
                //return NotFound(); // or RedirectToAction("Error", "Home");
                ViewBag.message = "Employee Not Found";

            } 
            return View(obj);
                
        }

        // GET: EmployeesController/Create
        //Employees/Create
        //[HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        //public ActionResult Create(IFormCollection collection)
        //{
        //    try
        //    {
        //        string name = collection["Name"];
        //        string EmpNo = collection["EmpNo"];
        //        string Basic = collection["Basic"];
        //        string DeptNo = collection["DeptNo"];
        //        //return RedirectToAction(nameof(Index));
        //        return RedirectToAction("Index");
        //    }
        //    catch
        //    {
        //        return View();
        //    }
        //}

        //Binding - enseure parameter names are the same as HTML control names
        //public ActionResult Create( int EmpNo, string Name, decimal Basic, int DeptNo)
        //{
        //    try
        //    {
        //        //return RedirectToAction(nameof(Index));
        //        return RedirectToAction("Index");
        //    }
        //    catch
        //    {
        //        return View();
        //    }
        //}

        //Model Binding Ensure property names in the model class are same as HTML control names

        public ActionResult Create(Employee obj)
        {
            try
            {
                // Here you can save the employee to the database or perform other actions
                // For now, we will just redirect to the Index action
                Employee.Insert(obj);
                //return RedirectToAction(nameof(Index));

                ViewBag.message = "Employee Created Successfully";
                return View();
            }
            catch(Exception ex) 
            {
                ViewBag.message = ex.Message;
                return View();
            }
        }

        // GET: EmployeesController/Edit/5
        public ActionResult Edit(int id)
        {
            Employee obj = Employee.GetSingleEmployee(id);
            return View(obj);
        }

        // POST: EmployeesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Employee obj)
        {
            try
            {
                Employee.Update(obj);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesController/Delete/5
        public ActionResult Delete(int id)
        {
            Employee obj = Employee.GetSingleEmployee(id);
            return View(obj);
        }

        // POST: EmployeesController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, Employee obj)
        {
            try
            {
                //Employee.Delete2(obj);
                Employee.Delete(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}