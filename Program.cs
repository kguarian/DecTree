using System;
using static System.Environment;
using System.IO;
using static System.IO.Path;

namespace Dec
{
    class Program
    {
        static void Main(string[] args){
            DecTree<string> tsTree = new DecTree<string>();
            int upperLim = 2000;
            for (int i = 1; i <= upperLim; i++){
                tsTree.Add(i, $"<id: ");
                //want percentage each time we have whole percentage: 1_000_000/i equiv 0 mod 100
                if(i%(upperLim/100)==0){
                    Console.WriteLine($"{i / (upperLim/100)}%");
                }
            }
            string path1 = System.IO.Path.GetFullPath("load.dec");
            tsTree.Export(path1);
        }

        // static void Main(string[] args)
        // {
        //     string path1 = System.IO.Path.GetFullPath("testtext1.txt");
        //     string path2 = System.IO.Path.GetFullPath("testtext2.txt");

        //     Console.WriteLine(DateTime.Now.ToString());
        //     DecTree<string> tsTree = new DecTree<string>();
        //     string[] lines = System.IO.File.ReadAllLines(path1);
        //     for (int i = 0; i < lines.Length; i++){
        //         tsTree.Add(i, lines[i]);
        //     }
        //     Console.WriteLine(DateTime.Now.ToString());
        //     tsTree.Export(path2);
        //     Console.WriteLine(DateTime.Now.ToString());
        // }
    }
}