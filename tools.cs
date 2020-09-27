using System;
using System.IO;
using System.Text;
namespace Dec
{
    public delegate string Del_x_string(); //delegateP: no args to string

    class FileWriter<E>{
        Del_x_string toStringAsync;
        DecTree<E> operand;
        public FileWriter(DecTree<E> operand){
            this.operand = operand;
            toStringAsync = new Del_x_string(operand.ToString);
        }
        public void Write(String filename, String content)
        {
            //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/file-system/how-to-write-to-a-text-file
            using (Stream s = new FileStream(filename + ".decT", FileMode.Create))
            {
                s.Write(Encoding.Unicode.GetBytes(content));
                s.Close();
            }
        }
    }
    class DecString
    {
        DecTree<char> chars;
        int currentIndex;
        public DecString()
        {
            chars = new DecTree<char>();
            currentIndex = 0;
        }

        private void AddChar(char c)
        {
            chars.Add(currentIndex++, c);
        }

        public void AddString(String starter)
        {
            for (int i = 0; i < starter.Length; i++)
            {
                AddChar(starter[i]);
            }
        }

        public DecString(String init)
        {
            chars = new DecTree<char>();
            currentIndex = 0;
            this.AddString(init);
        }

        public override String ToString()
        {
            char[] allChars = new char[this.currentIndex];
            for (int i = 0; i < this.currentIndex; i++)
            {
                allChars[i] = chars.Get(i);
            }
            return new string(allChars);
        }
    }
}