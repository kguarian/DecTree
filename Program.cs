using System;

namespace Dec
{
    class Program
    {
        static void tests(){
            Tests.tests();
        }

        static void DecBoard(){
            DecBoard<String> board = new DecBoard<String>();
            DecBoard<String>.run();
        }
        static void Main(string[] args)
        {
            DecBoard();
        }
    }
}
