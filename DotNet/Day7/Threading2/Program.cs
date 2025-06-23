using System;
using System.Collections.Generic;
using System.Threading;

namespace Threading2
{
    struct MyData
    {
        public int Id;
        public string Name;
    }

    internal class Program
    {
        static void Main()
        {
            // 1. Pass List<int>
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);
            list.Add(30);

            Thread t1 = new Thread(new ParameterizedThreadStart(Func_List));
            t1.Start(list);

            // 2. Pass int[] array
            int[] arr = new int[3];
            arr[0] = 100;
            arr[1] = 200;
            arr[2] = 300;

            Thread t2 = new Thread(new ParameterizedThreadStart(Func_Array));
            t2.Start(arr);

            // 3. Pass struct
            MyData data = new MyData { Id = 1, Name = "Nidhi" };
            Thread t3 = new Thread(new ParameterizedThreadStart(Func_Struct));
            t3.Start(data);

            // 4. Anonymous method (no parameters)
            Thread t4 = new Thread(() =>
            {
                for (int i = 1; i <= 5; i++)
                {
                    Console.WriteLine("Anonymous Thread: " + i);
                }
            });
            t4.Start();

        }

        static void Func_List(object obj)
        {
            List<int> list = (List<int>)obj;
            foreach (int item in list)
            {
                Console.WriteLine("List Item: " + item);
            }
        }

        static void Func_Array(object obj)
        {
            int[] arr = (int[])obj;
            foreach (int item in arr)
            {
                Console.WriteLine("Array Item: " + item);
            }
        }

        static void Func_Struct(object obj)
        {
            MyData data = (MyData)obj;
            Console.WriteLine($"Struct Data -> Id: {data.Id}, Name: {data.Name}");
        }
    }
}
