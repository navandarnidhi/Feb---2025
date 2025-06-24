using System;

namespace Idisposable1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Main1();  // You can also call Main2() instead
            //Main2();
        }

        static void Main1()
        {
            Class1 o = new Class1();
            o.Display();
            o.Dispose();  // Manual dispose
        }

        static void Main2()
        {
            using (Class1 o = new Class1())
            {
                o.Display();  // Dispose is called automatically at end of using block
            }
        }
    }

    public class Class1 : IDisposable
    {
        public Class1()
        {
            // Open file or DB connection here
            Console.WriteLine("Constructor called");
        }

        public void Display()
        {
            Console.WriteLine("Display called");
        }

        public void Dispose()
        {
            // Close file or DB connection here
            Console.WriteLine("Dispose code called. Write code here instead of Destructor");
        }
    }
}

namespace Idisposable
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Class1 o = new Class1();
            o.Display();
            o.Dispose();

            try
            {
                o.Display();  // Will throw ObjectDisposedException
            }
            catch (ObjectDisposedException ex)
            {
                Console.WriteLine($"Exception caught: {ex.Message}");
            }
        }
    }

    public class Class1 : IDisposable
    {
        private bool isDisposed = false;

        public Class1()
        {
            Console.WriteLine("Constructor called");
        }

        public void Display()
        {
            CheckForDisposed();
            Console.WriteLine("Display called");
        }

        public void Dispose()
        {
            if (!isDisposed)
            {
                // Release resources here
                Console.WriteLine("Dispose code called. Write code here instead of Destructor");
                isDisposed = true;
            }
        }

        private void CheckForDisposed()
        {
            if (isDisposed)
                throw new ObjectDisposedException(nameof(Class1));
        }
    }
}
