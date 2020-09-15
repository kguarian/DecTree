using System;
namespace Dec
{
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