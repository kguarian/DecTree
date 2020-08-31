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
        DecTree<E> dtD;
        DecTree<E> dtN;
        DecTree<E> dtP;
        DecTree<E> dev;
        E element;

        int type;
        int subAdds = 0;
        int size = 0;
        int curr = 0;
        int RMCYCLE = 0;

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
        static int DECIMAL = -10;
        static int PARENT = -100;

        public DecTree()
        {
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
                        if (this.dt0 == null)
                        {
                            this.dt0 = new DecTree<E>();
                        }
                        opTree = this.dt0;
                        break;
                    }

                case 1:
                    {
                        if (this.dt1 == null)
                        {
                            this.dt1 = new DecTree<E>();
                        }
                        opTree = this.dt1;
                        break;
                    }

                case 2:
                    {
                        if (this.dt2 == null)
                        {
                            this.dt2 = new DecTree<E>();
                        }
                        opTree = this.dt2;
                        break;
                    }

                case 3:
                    {
                        if (this.dt3 == null)
                        {
                            this.dt3 = new DecTree<E>();
                        }
                        opTree = this.dt3;
                        break;
                    }
                case 4:
                    {
                        if (this.dt4 == null)
                        {
                            this.dt4 = new DecTree<E>();
                        }
                        opTree = this.dt4;
                        break;
                    }

                case 5:
                    {
                        if (this.dt5 == null)
                        {
                            this.dt5 = new DecTree<E>();
                        }
                        opTree = this.dt5;
                        break;
                    }

                case 6:
                    {
                        if (this.dt6 == null)
                        {
                            this.dt6 = new DecTree<E>();
                        }
                        opTree = this.dt6;
                        break;
                    }

                case 7:
                    {
                        if (this.dt7 == null)
                        {
                            this.dt7 = new DecTree<E>();
                        }
                        opTree = this.dt7;
                        break;
                    }
                case 8:
                    {
                        if (this.dt8 == null)
                        {
                            this.dt8 = new DecTree<E>();
                        }
                        opTree = this.dt8;
                        break;
                    }

                case 9:
                    {
                        if (this.dt9 == null)
                        {
                            this.dt9 = new DecTree<E>();
                        }
                        opTree = this.dt9;
                        break;
                    }

                case -1:
                    {
                        if (this.dtN == null)
                        {
                            this.dtN = new DecTree<E>();
                        }
                        opTree = this.dtN;
                        break;
                    }

                case -3:
                    {
                        if (this.dtC == null)
                        {
                            this.dtC = new DecTree<E>();
                        }
                        opTree = this.dtC;
                        break;
                    }
                case -10:
                    {
                        if (this.dtD == null)
                        {
                            this.dtD = new DecTree<E>();
                        }
                        opTree = this.dtD;
                        break;
                    }

                case -100:
                    {
                        if (this.dtP == null)
                        {
                            this.dtP = new DecTree<E>();
                        }
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
                case -10:
                    {
                        opTree = this.dtD;
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
            if(address < 0)
            {
                opTree = opTree.MakeDecTree(-1);
                address *= -1;
            }
            while ((int) address >= 1)
            {
                int mod = (int)address % 10;
                address = (double)((int) address / 10);
                opTree = opTree.MakeDecTree(mod);
            }
            if ((int) address != 0)
            {
                opTree = opTree.MakeDecTree(DECIMAL);
            }
            while (address != 0)
            {
                address *= 10;
                int mod = (int)address;
                address -= mod;
                opTree = opTree.MakeDecTree(mod);
            }
            return opTree;
        }

        public DecTree<E> GoGet(double address)
        {
            DecTree<E> retTree = this;
            DecTree<E> opTree = retTree;
            if (address == 0)
            {
                return this;
            }
            if (address < 0)
            {
                opTree = opTree.GetDecTree(-1);
                address *= -1;
            }
            while (address >= 1)
            {
                int mod = (int)address % 10;
                address = (double)((int) address / 10);
                opTree = opTree.GetDecTree(mod);
            }
            if (address != 0)
            {
            opTree = opTree.GetDecTree(DECIMAL);
            }
            while (address != 0)
            {
                address *= 10;
                int mod = (int)address;
                address -= mod;
                opTree = opTree.GetDecTree(mod);
            }
            return opTree;
        }

        public DecTree<E> Add(E element)
        {
            if (this.dtC == null){
                this.dtC = this.MakeDecTree(-3);
                this.dtC.element = element;
            } else
            {
                this.dtC.Add(element);
            }
            return this.dtC;
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
            DecTree<E> opTree = this.PaveTo(address);
            return opTree.Add(element);
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
            if(FocusTree.dtC == null)
            {
                retValue = default(E);
                return retValue;
            }
            else
            {
                DecTree<E> opTree = FocusTree.dtC;
                if(opTree.dtC == null)
                {
                    retValue = FocusTree.dtC.element;
                    FocusTree.dtC = null;
                } else
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
    }

    class DecTester
    {

        public static Boolean TestAdd()
        {
            DecTree<double> TestTree = new DecTree<double>();
            for(double i = -2; i < 2; i += i/(1_000 * i))
            {
                TestTree.Add(i, i);
            }
            for(double i = -2; i < 2; i += i/(1_000 * i))
            {
                if (TestTree.Get(i) != i)
                {
                    return false;
                }
            }
            return true;
        }

        static void Tests()
        {
            Console.WriteLine("Add: " + TestAdd());
        }
        static void Main(string[] args)
        {
            Tests();
        }
    }
}