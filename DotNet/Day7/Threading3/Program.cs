namespace Threading3
{
    internal class Program
    {
        static void Main()
        {
            ThreadPool.QueueUserWorkItem(new WaitCallback(Func1));
            ThreadPool.QueueUserWorkItem(new WaitCallback(Func1), "passed value");

            Console.ReadLine();
        }

        static void Func1(object obj)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Func1: " + i + " " + obj);
            }
        }
    }
}
