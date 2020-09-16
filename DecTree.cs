using System;

namespace Dec
{
    public class DecTree<E>
    {
        public DecTree<E> dt0;
        public DecTree<E> dt1;
        public DecTree<E> dt2;
        public DecTree<E> dt3;
        public DecTree<E> dt4;
        public DecTree<E> dt5;
        public DecTree<E> dt6;
        public DecTree<E> dt7;
        public DecTree<E> dt8;
        public DecTree<E> dt9;
        public DecTree<E> dtC;
        public DecTree<E> dtN;
        public DecTree<E> dtP;
        static DecTree<long> primes = new DecTree<long>();
        public E element = default(E);

        int type;

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
        public DecTree(){}
        public DecTree(int type)
        {
            this.type = type;
        }

        public DecTree(E element)
        {
            this.element = element;
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
            DecTree<E> opTree = retTree;
            if (address == 0)
            {
                return this;
            }
            if (address < 0)
            {
                opTree = opTree.MakeDecTree(NEGATIVE);
                address *= -1;
            }
            while ((int)address > 0)
            {
                int mod = (int)address % 10;
                address /= 10;
                opTree = opTree.MakeDecTree(mod);
            }
            return opTree;
        }

        public DecTree<E> PaveTo(String address)
        {
            DecTree<E> retTree = this;
            DecTree<E> opTree = retTree;

            long longAddress = Hasher(address);

            if (longAddress == 0)
            {
                return this;
            }
            if (longAddress < 0)
            {
                opTree = opTree.MakeDecTree(NEGATIVE);
                longAddress *= -1;
            }
            while ((int)longAddress > 0)
            {
                int mod = (int)longAddress % 10;
                longAddress /= 10;
                opTree = opTree.MakeDecTree(mod);
            }
            return opTree;
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
            else while (address > 0)
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

            long longAddress = Hasher(address);

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
            return this.PaveTo(Hasher(address)).Add(element);
        }

        //<>Section<>

        public DecTree<E> AddL(E element)
        {
            DecTree<E> opTree = this;
            while (opTree.dtC != null)
            {
                opTree = opTree.dtC;
            }
            return opTree.Add(element);
        }

        public DecTree<E> AddL(long address, E element)
        {
            DecTree<E> opTree = this.PaveTo(address);
            return opTree.AddL(element);
        }
        public DecTree<E> AddL(string address, E element)
        {
            DecTree<E> opTree = this.PaveTo(Hasher(address));
            return opTree.AddL(element);
        }

        public E Get()
        {
            return this.dtC.element;
        }

        public DecTree<E> TGet(String address)
        {
            return this.PaveTo(address).dtC;
        }

        public E Get(long address)
        {
            return this.PaveTo(address).Get();
        }

        public E Get(string address)
        {
            return this.PaveTo(Hasher(address)).Get();
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
            DecTree<E> opTree = this.PaveTo(Hasher(address));
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

        public E Rm()
        {
            E retValue = default(E);
            if (this.dtC != null && this.dtC != default(DecTree<E>))
            {
                this.dtC.element = default(E);
            }
            return retValue;
        }

        public E Rm(long address)
        {
            return this.PaveTo(address).Rm();
        }

        public E Rm(String address)
        {
            return this.Rm(Hasher(address));
        }

        public E RmL()
        {
            E retValue = default(E);
            DecTree<E> FocusTree = this;
            DecTree<E> ChildTree;
            if (FocusTree.dtC == null)
            {
                return default(E);
            }
            ChildTree = FocusTree.dtC;
            while (ChildTree != null)
            {
                ChildTree = ChildTree.dtC;
                FocusTree = FocusTree.dtC;
                retValue = FocusTree.element;
            }
            FocusTree.dtC = null;
            return retValue;
        }

        public E RmL(long address)
        {
            return this.PaveTo(address).RmL(address);
        }



        public E RmL(string address)
        {
            return this.Rm(int.Parse(address));
        }


        public static long Hasher(string tag)
        {
            long hashValue = 0;
            for (int i = 0; i < tag.Length; i++)
            {
                hashValue += tag[i] * Prime(i);
            }
            return hashValue;
        }

        // Level 0
        public static long Prime(long index)
        {
            DecTree<bool> used = new DecTree<bool>();
            long Prime_Index = 0;
            primes.Add(0, 2);
            for (long i = primes.Get(Prime_Index) + 1; i < primes.Get(Prime_Index) * 2; i++)
            { // if(Bertrand's Postulate) {Infinite Loop}.
                if (Prime_Index >= index)
                {
                    break;
                }
                for (long j = 0; j <= Prime_Index; j++)
                {
                    if (Prime_Index >= index)
                    {
                        break;
                    }
                    if (i % primes.Get(j) == 0)
                    {
                        break;
                    }
                    else
                    {
                        used.Add(j, true);
                        try
                        {
                            used.Get(Prime_Index);
                        }
                        catch (NullReferenceException e)
                        {
                            e.ToString();
                            continue;
                        }
                        primes.Add(++Prime_Index, i);
                    }
                    // LOOP ENDS HERE
                }
            }
            return primes.Get(index);
        }

        public override string ToString()
        {
            return this.ConvertToString();
        }

        private void WriteToFile(String content, String path)
        {
            //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/file-system/how-to-write-to-a-text-file
            using (System.IO.StreamWriter file = new System.IO.StreamWriter(path, true))
            {
                file.WriteLine(content);
            }
        }

        private String ConvertToString()
        {
            DecString retString = new DecString();
            retString.AddString("[");
            if(element==null){
                retString.AddString("<>");
            }
            else
            {
                retString.AddString("<");
                retString.AddString(this.element.ToString());
                retString.AddString(">");
            }
            DecTree<E>[] order = new DecTree<E>[] { dt0, dt1, dt2, dt3, dt4, dt5, dt6, dt7, dt8, dt9, dtC, dtN };
            foreach (DecTree<E> member in order)
            {
                if (member != null)
                {
                    retString.AddString(member.ToString() + ",");
                }
                else
                {
                    retString.AddString(",");
                }
            }
            retString.AddString("]");
            return retString.ToString();
        }

        public long Record()
        {
            WriteToFile(ConvertToString(), @"C:\Users\ridea\Documents\HOME\coding\Jarvis\data\" + Hasher(this.ToString()) + ".txt");
            long hashVal = Hasher(this.ToString());
            return hashVal;
        }

        public void ReadIn(long hashVal)
        {
            //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/file-system/how-to-read-from-a-text-file
            string text = System.IO.File.ReadAllText(@"C:\Users\ridea\Documents\HOME\coding\Jarvis\data\" + hashVal + ".txt");
            char[] record = text.ToCharArray();

            DecTree<E> opTree;
            bool finished = false;
            int holdover = 0;
            for (long i = 0; i < record.Length; i++)
            {
                char current = record[i];
                switch (holdover)
                {
                    case '[':
                        switch (current)
                        {

                        }
                        break;
                    default:
                        break;
                }
            }
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

        public DecTree<E> move(String path)
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
        public static bool TestAdd()
        {
            DecTree<double> TestTree = new DecTree<double>();
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

        public static long TestHasher(String input)
        {
            return DecTree<object>.Hasher(input);
        }

        public static long TestPrime(long index)
        {
            DecTree<object> dtString = new DecTree<object>();
            return DecTree<object>.Prime(index);
        }

        static void tests()
        {
            Console.WriteLine("VolumeTests:");
            TestAdd();

        }

        static void HasherCrash(String test){
            
        }
    }
    //cursor rest point
}