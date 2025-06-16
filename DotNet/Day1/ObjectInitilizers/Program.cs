namespace ObjectInitilizers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Person person = new Person();
            person.Id = 1;
            person.Name = "John Doe";
            person.Email = "nidhi@gmail.com";

            // Using object initializer syntax - use it when you want to set properties at the time of object creation 
            // when there is no need to call a constructor or when you want to set multiple properties at once.

            Person person2 = new Person()
            {
                Id = 2,
                Name = "Jane Doe",
                Email = "jane@gmail.com"
            };

            Person person3 = new Person
            {
                Id = 3,
                Name = "Sam Smith",
                Email = "sam@gmail.com"
            };

            Console.WriteLine(person.Id);
        }
    }
        public class  Person
        {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        }
}
