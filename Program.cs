using System;
using static System.Environment;
using System.IO;
using static System.IO.Path;

namespace Dec
{
    class Program
    {
        static void Main(string[] args)
        {
            DecTree<string> blocklistTree = new DecTree<string>();
            DecTree<DateTime> datetimeTree = new DecTree<DateTime>();

            string[] linesForInput = System.IO.File.ReadAllLines("blocklist.txt");
            for (int i = 0; i < linesForInput.Length; i++){
                blocklistTree.Add(linesForInput[i], blocklistTree.Hasher(0, linesForInput[i]).ToString()+": " + linesForInput[i]);
                if(i%1000==0){
                    datetimeTree.Add(i / 1000, DateTime.UtcNow);
                }
            }
            string destFilePath1 = Path.Combine(System.Environment.CurrentDirectory, "testtext1.txt");
            string destFilePath2 = Path.Combine(System.Environment.CurrentDirectory, "testtext2.txt");
            Console.WriteLine(DateTime.Now);
            blocklistTree.Export(destFilePath1);
            Console.WriteLine(DateTime.Now);
            DecTree<string> importedSameTree = DecTree<string>.Import(destFilePath1);
            Console.WriteLine(DateTime.Now);
            importedSameTree.Export(destFilePath2);
            Console.WriteLine(DateTime.Now);
        }
    }
}