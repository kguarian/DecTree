using System;

namespace DecTree
{
    class DecTree<E>
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
        public E element;

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

        /* used to Make Type-Specific DecTrees*/
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

        public E Rm(long address)
        {
            return this.PaveTo(address).Rm(address);
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
            String retString;
            if (this.element != null)
            {
                retString = Hasher(this.element.ToString()).ToString() + ".";
            }
            else
            {
                retString = "\\";
            }
            if (this.dt0 != null)
            {
                retString += this.dt0.ToString() + "z";
            }
            if (this.dt1 != null)
            {
                retString += this.dt1.ToString() + "e";
            }
            if (this.dt2 != null)
            {
                retString += this.dt2.ToString() + "d";
            }
            if (this.dt3 != null)
            {
                retString += this.dt3.ToString() + "o";
            }
            if (this.dt4 != null)
            {
                retString += this.dt4.ToString() + "f";
            }
            if (this.dt5 != null)
            {
                retString += this.dt5.ToString() + "p";
            }
            if (this.dt6 != null)
            {
                retString += this.dt6.ToString() + "c";
            }
            if (this.dt7 != null)
            {
                retString += this.dt7.ToString() + "s";
            }
            if (this.dt8 != null)
            {
                retString += this.dt8.ToString() + "a";
            }
            if (this.dt9 != null)
            {
                retString += this.dt9.ToString() + "H";
            }
            if (this.dtN != null)
            {
                retString += this.dtN.ToString() + "N";
            }
            if (this.dtC != null)
            {
                retString += this.dtC.ToString() + "W";
            }
            return retString;
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
    }
    //cursor rest point
}