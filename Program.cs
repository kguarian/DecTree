using System;

namespace Dec
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] blocklistFileContents = System.IO.File.ReadAllLines("DecTree.cs");
            long fileLength = blocklistFileContents.Length;
            DecTree<string> dbComponent = new DecTree<string>();

            for (int i = 0; i < fileLength; i++)
            {
                dbComponent.Add(i, blocklistFileContents[i]);
            }
            dbComponent.Export("newfile.dec");

            DecTree<string> readin = DecTree<string>.Import("newfile.dec");
            Console.WriteLine("Finished!");
        }
    }
}