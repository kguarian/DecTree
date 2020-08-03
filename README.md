# DecTree

DEC_TREE info:

        DecTree can be a tree-indexed data storage solution, a double-indexed linked tree, and far more because its stored data type is
        generic, so one might use it to store (**in RAM, for now**) double-indexed data and arrangements of double-indexed data.

        MAIN METHODS for DecTree<D> { //badum tss
            dev0(double,D) //add element at double index (address)
            dev0(double) //retrieve from that address
            ensureDev1() //ensure that dev1 (and dev2) exists
            ensureDev2() //ensure that dev2 exists
            dev1(double, D) //add double index at specified double value address
            dev1(double) //retrieve ""
            dev2(double, DecTree<D>()) //store systems of DecTree<D>'s (the centralized way, with 1-1 indexing)
            dev2(double) //retrieve from next node at particular index
        }
        
Reference for reader: Code Usage Examples kept up-to-date in DecTreeTester.java.
