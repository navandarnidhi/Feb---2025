using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter number of batches: ");
        int batches = int.Parse(Console.ReadLine());

        // Create a jagged array (array of arrays)
        int[][] marks = new int[batches][];

        for (int i = 0; i < batches; i++)
        {
            Console.Write($"Enter number of students in batch {i + 1}: ");
            int students = int.Parse(Console.ReadLine());

            marks[i] = new int[students];

            for (int j = 0; j < students; j++)
            {
                Console.Write($"Enter mark for student {j + 1} in batch {i + 1}: ");
                marks[i][j] = int.Parse(Console.ReadLine());
            }
        }

        Console.WriteLine("\n--- Displaying Marks ---");
        for (int i = 0; i < batches; i++)
        {
            Console.WriteLine($"Batch {i + 1}:");
            for (int j = 0; j < marks[i].Length; j++)
            {
                Console.WriteLine($"  Student {j + 1}: {marks[i][j]}");
            }
        }
    }
}
