using System;
namespace Dec
{

    /*
    operations:
    0-9, c, p, n: nav
    e: show element
    r: remove below
    g: get below
    a: add below
    s: add to clipboard (lifo)
    S: save arrangement
    */
    public class DecBoard<E>
    {
        private DecTree<String> board;
        private int boardCtr = 0;
        private DecTree<String> userScope;

        bool quit = false;
        bool firstRun = true;

        public DecBoard()
        {
            board = new DecTree<String>();
            userScope = board;
        }
        private String UI_MUSTREFRESH()
        {
            DecString Menu = new DecString("Menu:\n");
            Menu.AddString("mn - menu (no arg)\n");
            Menu.AddString("cr - create category (line arg)\n");
            Menu.AddString("ps - post dectag (line arg)\n");
            Menu.AddString("gr - grab (line arg)\n");
            Menu.AddString("sh - shift (1 arg)\n");
            Menu.AddString("mv - move (line arg)\n");
            Menu.AddString("pr - print (no arg)\n");
            Menu.AddString("hm - home (no args)\n");
            Menu.AddString("qt - quit (no arg)\n");
            Menu.AddString("sh - shift (1 arg)\n");


            if (firstRun)
            {
                Console.Write($"{Menu.ToString()}\n\n:: ");
                firstRun = false;
            }
            else
            {
                Console.Write(":: ");
            }

            String UInput = Console.ReadLine();
            String[] inputArray = UInput.Split();

            if (inputArray[0] == "cr")
            {
                DecString pathString = new DecString();
                for (int i = 1; i < inputArray.Length; i++)
                {
                    pathString.AddString(inputArray[i]);
                }
                userScope = userScope.PaveTo(pathString.ToString());
                return "created";
            }

            if (inputArray[0] == "64144")
            {
                DecString hashed = new DecString();
                for (int i = 1; i < inputArray.Length; i++)
                {
                    hashed.AddString(inputArray[i]);
                    hashed.AddString(" ");
                }
                Console.WriteLine(DecTree<String>.Hasher(hashed.ToString()));
                return "ha.";
            }

            else if (inputArray[0] == "mv")
            {
                try
                {
                    DecString addString = new DecString();
                    for (int i = 1; i < inputArray.Length; i++)
                    {
                        addString.AddString(inputArray[i]);
                    }
                    userScope = userScope.GoGet(addString.ToString());
                    return "moved";
                }
                catch (NullReferenceException e)
                {
                }
                return "mv error";
            }

            else if (inputArray[0] == "sh")
            {
                userScope = userScope.shift(inputArray[1][0]);
                return inputArray[1][0].ToString();
            }

            else if (inputArray[0] == "ps")
            {
                DecString addString = new DecString();
                for (int i = 1; i < inputArray.Length; i++)
                {
                    addString.AddString(inputArray[i]);
                }
                userScope.Add(addString.ToString());
                return "posted";
            }

            else if (inputArray[0] == "gr")
            {
                if (inputArray.Length == 1)
                {
                    return userScope.element;
                }
                else
                {

                    try
                    {
                        DecString addString = new DecString();
                        for (int i = 1; i < inputArray.Length; i++)
                        {
                            addString.AddString(inputArray[i]);
                        }
                        return userScope.Get(addString.ToString());
                    }
                    catch (NullReferenceException e)
                    {
                        return "Empty";
                    }
                }
            }

            else if (inputArray[0] == "hm")
            {
                userScope = board;
                return "home";
            }

            else if (inputArray[0] == "rm")
            {
                try
                {
                    return userScope.Rm(inputArray[1]);
                }
                catch (NullReferenceException e)
                {
                    e.GetHashCode();
                    return "rm error";
                }
            }

            else if (inputArray[0] == "pr")
            {
                return board.ToString();
            }

            else if (inputArray[0] == "mn")
            {
                return $"{Menu.ToString()}\n\n";
            }

            else if (inputArray[0] == "qt")
            {
                quit = true;
                return "quitting.";
            }

            else
            {
                return "invalid command.";
            }
        }
        public static void run()
        {
            DecBoard<String> main = new DecBoard<String>();
            while (!main.quit)
            {
                Console.WriteLine(main.UI_MUSTREFRESH());
            }
        }
    }
}