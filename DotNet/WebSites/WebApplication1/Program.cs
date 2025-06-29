namespace WebApplication1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            WebApplicationBuilder builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();

            WebApplication app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            // Enable HTTPS redirection middleware
            app.UseHttpsRedirection();

            // Enable static files middleware to serve files from wwwroot
            app.UseRouting();

            // Enable authentication and authorization middleware
            app.UseAuthorization();

            // used to acstatic files in the wwwroot folder
            app.MapStaticAssets();

            // Map controller routes
            app.MapControllerRoute(
                // Define a route for the application
                name: "default",

                // Specify the route template
                //conventional routing
                // This will map to the HomeController's Index action by default
                // and allow for an optional id parameter


                //https://localhost:7256/Default/Index/12345?a=1&b=2&c=3
                //https://localhost:7256/Default/Index/12345?c=3
                pattern: "{controller=Default}/{action=Index}/{id?}")
                //pattern: "{controller=Default}/{action=Index}/{id?}/{a?}/{b?}/{c?}")

                // Map Razor Pages if you have any
                .WithStaticAssets();

            
            app.Run();
        }
    }
}
