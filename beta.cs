using System;
using System.IO;
using System.Text.Encodings;
using System.Runtime.Serialization;
using System.Xml.Serialization;

namespace beta
{
    [DataContractAttribute]
    public class DecTree<E>
    {
        [DataMemberAttribute]
        public DecTree<E> dt0;
        [DataMemberAttribute]
        public DecTree<E> dt1;
        [DataMemberAttribute]
        public DecTree<E> dt2;
        [DataMemberAttribute]
        public DecTree<E> dt3;
        [DataMemberAttribute]
        public DecTree<E> dt4;
        [DataMemberAttribute]
        public DecTree<E> dt5;
        [DataMemberAttribute]
        public DecTree<E> dt6;
        [DataMemberAttribute]
        public DecTree<E> dt7;
        [DataMemberAttribute]
        public DecTree<E> dt8;
        [DataMemberAttribute]
        public DecTree<E> dt9;
        [DataMemberAttribute]
        public DecTree<E> dtC;
        [DataMemberAttribute]
        public DecTree<E> dtN;
        [IgnoreDataMemberAttribute]
        public DecTree<E> dtP;
        [DataMemberAttribute]
        public DecTree<long> primes;
        [DataMemberAttribute]
        public E element = default(E);

        [DataMemberAttribute]
        long type = 0;
        [DataMemberAttribute]
        long counter = 0;
        [DataMemberAttribute]
        long serializationCounter = 0;

        static int ZERO = 0;
        static int ONE = 1;
        static int TWO = 2;
        static int THREE = 3;
        static int FOUR = 4;
        static int FIVE = 5;
        static int SIX = 6;
        static int SEVEN = 7;
        static int EIGHT = 8;
        static int NINE = 9;
        static int NEGATIVE = -1;
        static int CHILD = -3;
        static int PARENT = -100;

        /* used to Make Type-Specific DecTrees*/
        public DecTree()
        {
        }
        private DecTree(int type)
        {
            this.type = type;
        }

        public DecTree(E element)
        {
            this.element = element;
        }

        public void counterDecrement()
        {
            this.counter--;
            if (this.dtP != null)
            {
                this.dtP.counterDecrement();
            }
        }

        /// <summary>
        /// Trying to figure out how not to break the hasher with this. Unused for now.
        /// </summary>
        public void counterIncrement()
        {
            this.counter++;
            if (this.dtP != null)
            {
                this.dtP.counterIncrement();
            }
        }

        public DecTree<E> MakeDecTree(int type)
        {
            DecTree<E> opTree;
            switch (type)
            {
                case 0:
                    {
                        this.dt0 ??= new DecTree<E>(ZERO);
                        opTree = this.dt0;
                        break;
                    }

                case 1:
                    {
                        this.dt1 ??= new DecTree<E>(ONE);
                        opTree = this.dt1;
                        break;
                    }

                case 2:
                    {
                        this.dt2 ??= new DecTree<E>(TWO);
                        opTree = this.dt2;
                        break;
                    }

                case 3:
                    {
                        this.dt3 ??= new DecTree<E>(THREE);
                        opTree = this.dt3;
                        break;
                    }
                case 4:
                    {
                        this.dt4 ??= new DecTree<E>(FOUR);
                        opTree = this.dt4;
                        break;
                    }

                case 5:
                    {
                        this.dt5 ??= new DecTree<E>(FIVE);
                        opTree = this.dt5;
                        break;
                    }

                case 6:
                    {
                        this.dt6 ??= new DecTree<E>(SIX);
                        opTree = this.dt6;
                        break;
                    }

                case 7:
                    {
                        this.dt7 ??= new DecTree<E>(SEVEN);
                        opTree = this.dt7;
                        break;
                    }
                case 8:
                    {
                        this.dt8 ??= new DecTree<E>(EIGHT);
                        opTree = this.dt8;
                        break;
                    }

                case 9:
                    {
                        this.dt9 ??= new DecTree<E>(NINE);
                        opTree = this.dt9;
                        break;
                    }

                case -1:
                    {
                        this.dtN ??= new DecTree<E>(NEGATIVE);
                        opTree = this.dtN;
                        break;
                    }

                case -3:
                    {
                        this.dtC ??= new DecTree<E>(CHILD);
                        opTree = this.dtC;
                        break;
                    }

                case -100:
                    {
                        this.dtP ??= new DecTree<E>(PARENT);
                        opTree = this.dtP;
                        break;
                    }

                default:
                    opTree = null;
                    break;

            }
            opTree.dtP = this;
            return opTree;
        }

        public DecTree<E> GetDecTree(int type)
        {
            DecTree<E> opTree;

            switch (type)
            {
                case 0:
                    {
                        opTree = this.dt0;
                        break;
                    }

                case 1:
                    {
                        opTree = this.dt1;
                        break;
                    }

                case 2:
                    {
                        opTree = this.dt2;
                        break;
                    }

                case 3:
                    {
                        opTree = this.dt3;
                        break;
                    }
                case 4:
                    {
                        opTree = this.dt4;
                        break;
                    }

                case 5:
                    {
                        opTree = this.dt5;
                        break;
                    }

                case 6:
                    {
                        opTree = this.dt6;
                        break;
                    }

                case 7:
                    {
                        opTree = this.dt7;
                        break;
                    }
                case 8:
                    {
                        opTree = this.dt8;
                        break;
                    }

                case 9:
                    {
                        opTree = this.dt9;
                        break;
                    }

                case -1:
                    {
                        opTree = this.dtN;
                        break;
                    }

                case -3:
                    {
                        opTree = this.dtC;
                        break;
                    }
                case -100:
                    {
                        opTree = this.dtP;
                        break;
                    }

                default:
                    opTree = null;
                    break;

            }
            return opTree;
        }
        public DecTree<E> PaveTo(long address)
        {
            DecTree<E> retTree = this;
            if (address == 0)
            {
                return this;
            }
            if (address < 0)
            {
                retTree = retTree.MakeDecTree(NEGATIVE);
                address *= -1;
            }
            while ((int)address > 0)
            // TODO: I kind of want to parse left to right but I don't want to sacrifice the runtime.
            {
                int mod = (int)address % 10;
                address /= 10;
                retTree = retTree.MakeDecTree(mod);
            }
            return retTree;
        }

        public DecTree<E> PaveTo(String address)
        {
            DecTree<E> retTree = this;

            long longAddress = Hasher(0, address);

            if (longAddress == 0)
            {
                return this;
            }
            if (longAddress < 0)
            {
                retTree = retTree.MakeDecTree(NEGATIVE);
                longAddress *= -1;
            }
            while ((int)longAddress > 0)
            {
                int mod = (int)longAddress % 10;
                longAddress /= 10;
                retTree = retTree.MakeDecTree(mod);
            }
            return retTree;
        }

        public DecTree<E> GoGet(long address)
        {
            DecTree<E> retTree = this;
            DecTree<E> opTree = retTree;

            if (address == 0)
            {
                return this;
            }
            else if (address < 0)
            {
                opTree = opTree.GetDecTree(NEGATIVE);
                address *= -1;
            }
            while (address > 0)
            {
                int mod = (int)address % 10;
                address /= 10;
                opTree = opTree.GetDecTree(mod);
            }
            return opTree;
        }

        public DecTree<E> GoGet(String address)
        {
            DecTree<E> retTree = this;
            DecTree<E> opTree = retTree;

            long longAddress = Hasher(0, address);

            if (longAddress == 0)
            {
                return this;
            }
            else if (longAddress < 0)
            {
                opTree = opTree.GetDecTree(NEGATIVE);
                longAddress *= -1;
            }
            else while (longAddress > 0)
                {
                    int mod = (int)longAddress % 10;
                    longAddress /= 10;
                    opTree = opTree.GetDecTree(mod);
                }
            return opTree;
        }

        public DecTree<E> Add(E element)
        {
            DecTree<E> opTree = this;
            if (opTree.dtC == null)
            {
                opTree = opTree.MakeDecTree(CHILD);
                opTree.element = element;
                return opTree;
            }
            else
            {
                DecTree<E> nextInChain = opTree.dtC;
                opTree.dtC = default(DecTree<E>);
                opTree = opTree.MakeDecTree(CHILD);
                opTree.element = element;
                opTree.dtC = nextInChain;
                nextInChain.dtP = opTree;
                return opTree;
            }
        }

        public DecTree<E> Add(long address, E element)
        {
            return this.PaveTo(address).Add(element);
        }

        public DecTree<E> Add(string address, E element)
        {
            return this.PaveTo(Hasher(0, address)).Add(element);
        }

        //<>Section<>

        public DecTree<E> AddL(E element)
        {
            DecTree<E> opTree = this;
            while (opTree.dtC != null)
            {
                opTree = opTree.dtC;
            }
            opTree = opTree.Add(element);
            return opTree;
        }

        public DecTree<E> AddL(long address, E element)
        {
            DecTree<E> opTree = this.PaveTo(address);
            return opTree.AddL(element);
        }
        public DecTree<E> AddL(string address, E element)
        {
            DecTree<E> opTree = this.PaveTo(Hasher(0, address));
            return opTree.AddL(element);
        }

        public E Get()
        {
            return this.dtC.element;
        }

        public DecTree<E> TGet(String address)
        {
            return this.GoGet(address).dtC;
        }

        public E Get(long address)
        {
            return this.GoGet(address).Get();
        }

        public E Get(string address)
        {
            return this.GoGet(Hasher(0, address)).Get();
        }

        public E GetL(long address)
        {
            DecTree<E> opTree = this.PaveTo(address);
            while (opTree.dtC != null)
            {
                opTree = opTree.dtC;
            }
            return opTree.element;
        }

        public E GetL(string address)
        {
            DecTree<E> opTree = this.PaveTo(Hasher(0, address));
            while (opTree.dtC != null)
            {
                opTree = opTree.dtC;
            }
            return opTree.element;
        }

        public DecTree<E> TGet(long address)
        {
            return this.PaveTo(address).dtC;
        }

        public bool Rm()
        {
            if (this.dtC != null && this.dtC.dtC != null)
            {
                this.dtC = this.dtC.dtC;
                return true;
            }
            else if (this.dtC != null && this.dtC.dtC == null)
            {
                this.dtC = null;
                this.element = default(E);
            }
            {
                return false;
            }
        }

        public bool Rm(long address)
        {
            return this.GoGet(address).Rm();
        }

        public bool Rm(String address)
        {
            return this.Rm(Hasher(0, address));
        }

        public bool RmL()
        {
            DecTree<E> FocusTree = this;
            DecTree<E> ChildTree;
            if (FocusTree.dtC == null)
            {
                return false;
            }
            ChildTree = FocusTree.dtC;
            while (ChildTree != null)
            {
                ChildTree = ChildTree.dtC;
                FocusTree = FocusTree.dtC;
            }
            FocusTree.dtC = null;
            counterDecrement();
            return true;
        }

        public bool RmL(long address)
        {
            return this.PaveTo(address).RmL(address);
        }



        public bool RmL(string address)
        {
            return this.Rm(int.Parse(address));
        }


        public long Hasher(long zero, string tag)
        {
            long hashValue = zero;
            for (int i = 0; i < tag.Length; i++)
            {
                hashValue += tag[i] * Prime(i);
            }
            return hashValue;
        }

        // Level 0
        public long Prime(long index)
        {
            //only want to add once.
            if (primes == null)
            {
                primes = new DecTree<long>();
                primes.Add(0, 2);
            }

            //can see how many times this method has been this.primes with primes.TGet(0) analysis.
            for (long i = primes.Get(primes.counter) + 1; i < primes.Get(primes.counter) * 2; i++)
            { // if(Bertrand's Postulate) {Infinite Loop}.
                if (primes.counter == index)
                {
                    break;
                }
                for (long j = 0; j <= primes.counter; j++)
                {
                    if (primes.counter >= index)
                    {
                        break;
                    }
                    if (i % primes.Get(j) == 0)
                    {
                        break;
                    }
                    else
                    {
                        if (j == primes.counter)
                        {
                            primes.Add(++primes.counter, i);
                        }
                    }
                    // LOOP ENDS HERE
                }
            }
            return primes.Get(index);
        }

        /// <summary>
        /// OUTPUT FORMAT:
        /// $"[{DecTree Index}] : <{element.ToString()}>\n"
        /// $"\t{Child Index}: {Index of child tree}\n")
        /// </summary>
        /// <returns></returns>
        public override string ToString()
        {
            DecString retString = new DecString();
            DecTree<E>[] order = new DecTree<E>[] { dt0, dt1, dt2, dt3, dt4, dt5, dt6, dt7, dt8, dt9, dtC, dtN };
            DecTree<DecTree<E>> referenceHolder = new DecTree<DecTree<E>>();
            referenceHolder.Add(0, this);
            foreach (DecTree<E> member in order)
            {
                if (member != null)
                {
                    referenceHolder.Add(++referenceHolder.counter, member);
                    member.serializationCounter = referenceHolder.counter;
                    member.CollectSubTrees(referenceHolder);
                }
            }
            for (int i = 0; i <= referenceHolder.counter; i++)
            {
                DecTree<E> currTree = referenceHolder.Get(i);
                retString.AddString($"{i}: <{(currTree.element != null ? currTree.element.ToString() : "null")}>\n");

                order[0] = currTree.dt0;
                order[1] = currTree.dt1;
                order[2] = currTree.dt2;
                order[3] = currTree.dt3;
                order[4] = currTree.dt4;
                order[5] = currTree.dt5;
                order[6] = currTree.dt6;
                order[7] = currTree.dt7;
                order[8] = currTree.dt8;
                order[9] = currTree.dt9;
                order[10] = currTree.dtC;
                order[11] = currTree.dtN;
                for (int j = 0; j < order.Length; j++)
                {
                    if (order[j] != null)
                    {
                        retString.AddString($"\t{j}: {order[j].serializationCounter}\n");
                    }
                }
            }
            return retString.ToString();
        }

        private DecTree<DecTree<E>> CollectSubTrees(DecTree<DecTree<E>> referenceHolder)
        {
            DecTree<E>[] order = new DecTree<E>[] { dt0, dt1, dt2, dt3, dt4, dt5, dt6, dt7, dt8, dt9, dtC, dtN };
            foreach (DecTree<E> member in order)
            {
                if (member != null)
                {
                    referenceHolder.Add(++referenceHolder.counter, member);
                    member.serializationCounter = referenceHolder.counter;
                    member.CollectSubTrees(referenceHolder);
                }
            }
            return referenceHolder;
        }

        //procedure sequence: DecTreeNav:
        public DecTree<E> shift(char c)
        {
            DecTree<E> inFocus = this;
            return c switch
            {
                '0' => inFocus.dt0,
                '1' => inFocus.dt1,
                '2' => inFocus.dt2,
                '3' => inFocus.dt3,
                '4' => inFocus.dt4,
                '5' => inFocus.dt5,
                '6' => inFocus.dt6,
                '7' => inFocus.dt7,
                '8' => inFocus.dt8,
                '9' => inFocus.dt9,
                'c' => inFocus.dtC,
                'n' => inFocus.dtN,
                'p' => inFocus.dtP,
                _ => null,
            };
        }

        public DecTree<E> Move(String path)
        {
            DecTree<E> opTree = this;
            for (int i = 0; i < path.Length; i++)
            {
                opTree = opTree.shift(path[i]);
            }
            return opTree;
        }
    }

    class Tests
    {
        DecTree<long> TestTree = new DecTree<long>();
        public bool TestAdd()
        {
            for (long i = 0; i < 999; i++)
            {
                TestTree.Add(i, i);
            }
            for (long i = 0; i < 999; i++)
            {
                if (TestTree.Get(i) != i)
                {
                    return false;
                }
            }
            return true;
        }

        public long TestHasher(String input)
        {
            return TestTree.Hasher(0, input);
        }

        public long TestPrime(long index)
        {
            DecTree<object> dtString = new DecTree<object>();
            return TestTree.Prime(index);
        }

        public static String tests()
        {
            //Tests FileWriter and records ToString() method
            DecTree<String> tsTree = new DecTree<String>();
            int upperbound = int.Parse(Prompt("Test Size"));
            for (int i = 0; i < upperbound; i++)
            {
                tsTree.Add(i, i.ToString());
            }
            String retString = tsTree.ToString();
            FileWriter<String> fw = new FileWriter<String>(tsTree);
            fw.Write("C:\\Users\\ridea\\Documents\\HOME\\coding\\DecTree\\DecTree.log", tsTree.ToString());
            return retString;
        }

        public static String Prompt(String prompt)
        {
            Console.Write(prompt + ": ");
            String retString = Console.ReadLine();
            Console.WriteLine();
            return retString;
        }

        static void HasherCrash(String test)
        {

        }
    }

    class Pair<E>
    {
        object[] pair = new object[2];
        public Pair(DecTree<E> tree, int index)
        {
            pair[0] = tree;
            pair[1] = index;
        }

        public object[] get => pair;
    }

    class XMLSerializer<E>
    {
        public void Write(E subject, string fileName)
        //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/concepts/serialization/how-to-write-object-data-to-an-xml-file
        {
            FileStream writer = new FileStream(fileName, FileMode.Append);
            System.Xml.Serialization.XmlSerializer ser =
                new System.Xml.Serialization.XmlSerializer(typeof(E));

            ser.Serialize(writer, subject);
            writer.Close();
        }

        public E Read(string fileName)
        //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/concepts/serialization/how-to-read-object-data-from-an-xml-file
        {
            System.Xml.Serialization.XmlSerializer reader =
        new System.Xml.Serialization.XmlSerializer(typeof(E));
            System.IO.StreamReader file = new System.IO.StreamReader(fileName);
            E retObject = (E)reader.Deserialize(file);
            file.Close();
            return retObject;
        }
    }

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
                s.Write(System.Text.Encoding.Unicode.GetBytes(content));
                s.Close();
            }
        }
    }

    /// <summary>
    /// Developers get freedom here. Swap out "chars" with something else if you want, but the <methodname>Stable</methodname>
    /// </summary>
    class DecString
    {
        private DecTree<char> chars;
        private int Length;
        //standard string length.
        private bool open = true;

        public DecString()
        {
            chars = new DecTree<char>();
            Length = 0;
        }

        public void AddChar(char c)
        {
            if(open){
                chars.Add(Length++, c);
            }
        }

        public char GetChar(int index){
            if(index > -1 && index < Length){
                return chars.Get(Length);
            }
            else{
                return (char) 0;
            }
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
            Length = 0;
            this.AddString(init);
        }

        public override String ToString()
        {
            char[] allChars = new char[this.Length];
            for (int i = 0; i < this.Length; i++)
            {
                allChars[i] = chars.Get(i);
            }
            return (new string(allChars));
        }

        /// <summary>
        /// splits strings by space characters, stores each splice in a
        /// child DecTree, stores it at the next available index--INDEXING
        /// STARTS AT ZERO, increments by +1.
        /// </summary>
        /// <param name="input">the string to be split.</param>
        /// <returns></returns>
        public static DecTree<DecString> Split(string input){

            if(input.Length == 0){
                DecTree<DecString> r_tree = new DecTree<DecString>();
                r_tree.Add(1, new DecString("\0"));
                return r_tree;
            }

            int stringIndex = 0;
            int charCounter = 0;

            DecTree<DecString> r_tree1 = new DecTree<DecString>();
            DecString opDString = new DecString();
            while(charCounter<input.Length){
                opDString.AddChar(input[charCounter]);
                charCounter++;
                if(input[charCounter]==' '){
                    r_tree1.Add(stringIndex++, opDString);
                    //indexing starts at 0 for this reason.
                    opDString = new DecString();
                    stringIndex = 0;
                }
            }
            if(input[input.Length-1]!=' '){
                r_tree1.Add(stringIndex, opDString);
            }
            return r_tree1;
        }

        #pragma warning disable 168
        public bool Stable(){
            try{
                for (int i = 0; i < this.Length; i++){
                    this.GetChar(i);
                }
                return true;
            } catch (Exception e){
                return false;
            }
        }
        #pragma warning restore 168
    }
    //cursor rest point
}