using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    // HomeController is responsible for handling requests to the home page and privacy page
    // It inherits from the Controller base class, which provides methods and properties for handling HTTP requests and responses
    // The controller is decorated with the [Controller] attribute, which indicates that it is a controller class
    // The controller uses dependency injection to get an instance of ILogger<HomeController> for logging purposes
    //all controller must end with Controller suffix
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        // Constructor that takes an ILogger<HomeController> parameter for logging
        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        // Action method that handles requests to the home page
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
