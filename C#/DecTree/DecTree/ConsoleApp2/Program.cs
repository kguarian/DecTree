using System;

namespace Storage
{
    class DecTree<E>
    {
        DecTree<E> dt0;
        DecTree<E> dt1;
        DecTree<E> dt2;
        DecTree<E> dt3;
        DecTree<E> dt4;
        DecTree<E> dt5;
        DecTree<E> dt6;
        DecTree<E> dt7;
        DecTree<E> dt8;
        DecTree<E> dt9;
        DecTree<E> dtC;
        DecTree<E> dtN;
        DecTree<E> dtP;
        DecTree<E> dev;
        DecTree<long> Primes;
        E element;

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

        public DecTree()
        {
        }

        public DecTree(bool init){
            if(init){
                this.Primes = new DecTree<long>();
            }
        }

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
            opTree.Primes = this.Primes;
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
        public DecTree<E> PaveTo(double address)
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
                address = (double)((int)address / 10);
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
            if (address < 0)
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

        public DecTree<E> Add(E element)
        {
            if (this.dtC == null)
            {
                this.dtC = this.MakeDecTree(-3);
                this.dtC.element = element;
                return this.dtC;
            }
            else
            {
                return this.dtC.Add(element);
            }
        }

        public DecTree<E> AddL(E element)
        {
            DecTree<E> opTree = this;
            while (opTree.dtC != null)
            {
                opTree = opTree.dtC;
            }
            return opTree.Add(element);
        }

        public E Get()
        {
            return this.dtC.element;
        }
        public DecTree<E> Add(double address, E element)
        {
            return this.PaveTo(address).Add(element);
        }

        public DecTree<E> AddL(double address, E element)
        {
            DecTree<E> opTree = this.PaveTo(address);
            return opTree.AddL(element);
        }

        public E Get(double address)
        {
            return this.PaveTo(address).Get();
        }

        public E GetL(double address)
        {
            DecTree<E> opTree = this;
            while (opTree.dtC != null)
            {
                opTree = opTree.dtC;
            }
            return opTree.element;
        }

        public E Rm()
        {
            E retValue = default(E);
            DecTree<E> FocusTree = this;
            if (FocusTree.dtC == null)
            {
                retValue = default(E);
                return retValue;
            }
            else
            {
                DecTree<E> opTree = FocusTree.dtC;
                if (opTree.dtC == null)
                {
                    retValue = FocusTree.dtC.element;
                    FocusTree.dtC = null;
                }
                else
                {
                    retValue = FocusTree.dtC.element;
                    FocusTree.dtC = opTree.dtC;
                }
                return retValue;
            }
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

        public E Rm(double address)
        {
            return this.PaveTo(address).Rm(address);
        }

        public E RmL(double address)
        {
            return this.PaveTo(address).RmL(address);
        }

        public long Hasher(string tag)
        {
            int max = 0;
            long hashValue = 0;
            for (int i = 0; i < tag.Length; i++)
            {
                int currentChar = tag[i];
                if (tag[i] > max)
                {
                    max = currentChar;
                }
            }
            for (int i = 0; i < tag.Length; i++)
            {
                hashValue += tag[i] * this.Prime(i);
            }
            return hashValue;
        }

        // Level 0
        public long Prime(long index)
        {
            DecTree<bool> used = new DecTree<bool>();
            long Prime_Index = 0;
            this.Primes.Add(0, 2);
            for (long i = Primes.Get(Prime_Index) + 1; i < Primes.Get(Prime_Index) * 2; i++)
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
                    if (i % Primes.Get(j) == 0)
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
                        Primes.Add(++Prime_Index, i);
                    }
                    // LOOP ENDS HERE
                }
            }
            return this.Primes.Get(index);
        }
    }
}

class DecTester
{

    public static bool TestAdd()
    {
        Storage.DecTree<double> TestTree = new Storage.DecTree<double>();
        for (double i = 0; i < 999; i++)
        {
            TestTree.Add(i, i);
        }
        for (double i = 0; i < 999; i++)
        {
            if (TestTree.Get(i) != i)
            {
                return false;
            }
        }
        return true;
    }

    public static long TestHasher(String input){
        Storage.DecTree<string> dtString = new Storage.DecTree<string>(true);
        return dtString.Hasher(input);
    }

    public static long TestPrime(long index){
        Storage.DecTree<string> dtString = new Storage.DecTree<string>(true);
        return dtString.Prime(index);
    }

    static void Tests()
    {
        Console.WriteLine("Hasher: Hello World => " + TestHasher("Hello World"));
        Console.WriteLine("Hasher: dlroW olleH => " + TestHasher("dlroW olleH"));
        Console.WriteLine("Add && Retrieve: addresses 0->999 => " + TestAdd());
        Console.WriteLine("Prime Finder: The 1,000th prime number is " + TestPrime(1_000));

    }
    static void Main(string[] args)
    {
        Tests();
    }
}
//cursor rest point