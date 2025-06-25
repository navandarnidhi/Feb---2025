using Microsoft.Data.SqlClient;
using System.Data;
namespace DataBaseCode
{
    internal class Program
    {
        static void Main()
        {
            //Connect();
            //Insert();

            Employee obj = new Employee { EmpNo = 6, Name = "Alfred D'Mello", DeptNo = 20, Basic = 5000 };
            //Insert2(obj);
            //InsertWithParameters(obj);


            //InsertWithSP(obj); //insert


            //obj.Name = "Alfred Updated";
            //obj.Basic = 6500;
            //UpdateWithSP(obj);    // Update

            DeleteWithSP(obj.EmpNo); // Delete
        }
        static void Connect()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();
                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        //static void Insert()
        //{
        //    SqlConnection cn = new SqlConnection();
        //    try
        //    {
        //        cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

        //        cn.Open();

        //        // SqlCommand cmd = cn.CreateCommand();
        //        SqlCommand cmd = new SqlCommand();
        //        cmd.Connection = cn;
        //        cmd.CommandType = CommandType.Text;
        //        cmd.CommandText = "insert into Employees values(3,'Shital', 25000, 20) ";
        //        cmd.ExecuteNonQuery();

        //        Console.WriteLine("success");
        //    }
        //    catch (Exception ex)
        //    {
        //        Console.WriteLine(ex.Message);
        //    }
        //    finally
        //    {
        //        cn.Close();
        //    }
        //}
        //static void Insert2(Employee obj)
        //{
        //    SqlConnection cn = new SqlConnection();
        //    try
        //    {
        //        cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

        //        cn.Open();

        //        // SqlCommand cmd = cn.CreateCommand();
        //        SqlCommand cmd = new SqlCommand();
        //        cmd.Connection = cn;
        //        cmd.CommandType = CommandType.Text;
        //        cmd.CommandText = $"insert into Employees values({obj.EmpNo},'{obj.Name}', {obj.Basic}, {obj.DeptNo}) ";
        //        Console.WriteLine(cmd.CommandText);
        //        Console.ReadLine();
        //        cmd.ExecuteNonQuery();

        //        Console.WriteLine("success");
        //    }
        //    catch (Exception ex)
        //    {
        //        Console.WriteLine(ex.Message);
        //    }
        //    finally
        //    {
        //        cn.Close();
        //    }
        //}
        //static void InsertWithParameters(Employee obj)
        //{
        //    SqlConnection cn = new SqlConnection();
        //    try
        //    {
        //        cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

        //        cn.Open();

        //        // SqlCommand cmd = cn.CreateCommand();
        //        SqlCommand cmd = new SqlCommand();
        //        cmd.Connection = cn;
        //        cmd.CommandType = CommandType.Text;
        //        cmd.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";

        //        cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
        //        cmd.Parameters.AddWithValue("@Name", obj.Name);
        //        cmd.Parameters.AddWithValue("@Basic", obj.Basic);
        //        cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


        //        cmd.ExecuteNonQuery();

        //        Console.WriteLine("success");
        //    }
        //    catch (Exception ex)
        //    {
        //        Console.WriteLine(ex.Message);
        //    }
        //    finally
        //    {
        //        cn.Close();
        //    }
        //}
        static void InsertWithSP(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "InsertEmployee";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void UpdateWithSP(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "UpdateEmployee";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                Console.WriteLine("Update successful");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Update failed: " + ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void DeleteWithSP(int empNo)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "DeleteEmployee";

                cmd.Parameters.AddWithValue("@EmpNo", empNo);

                cmd.ExecuteNonQuery();
                Console.WriteLine("Delete successful");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Delete failed: " + ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
    }


    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
    }
}