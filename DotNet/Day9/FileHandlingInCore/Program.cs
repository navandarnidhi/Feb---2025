namespace FileHandlingInCore
{
    internal class Program
    {
        static void Main(string[] args)
        {
            WriteToFile();
            ReadFromFile();
        }

        private static void WriteToFile()
        {


            StreamWriter writer = File.CreateText("C:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");

            writer.Close();
        }

        private static void ReadFromFile()
        {
            StreamReader reader = File.OpenText("C:\\aaaa\\a.txt");
            string line;
            while ((line = reader.ReadLine()) != null)
            {
                Console.WriteLine(line);
            }

            reader.Close();
        }
    }
}


// create a employee object and persist it to a file
// then read the employee object from the file and recreate the employee object



