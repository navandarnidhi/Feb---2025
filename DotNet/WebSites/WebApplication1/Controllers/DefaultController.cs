using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id, int a = 30, int b = 20, int c = 10)
        {
            //if (id == null)
            //    return NotFound();

            //here we can use ViewData or ViewBag to pass data to the view
            ViewBag.id = id; // if id is null, set it to 0
            ViewBag.a = a;
            ViewBag.b = b;
            ViewBag.c = c;
            return View();
        }
    }
}
