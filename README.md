#DecTree

Code Confidence Agreement:
If you have access to any code from uTwitch1001 and MalignedAutopilot's DecTree repository and are not either uTwitch1001's or MalignedAutopilot's original account owner, you agree not to assume this project as your own or to share any information about it with anyone who uTwitch1001 or MalignedAutipilot's original account owners explicitly authorized to have information about this repository or project.

The following Github Users (as of 25AUG2020) are authorized to access this project and repository:

---BEGINNING OF LIST---

    Aricky3
    haythamallos

---END OF LIST---------

DEC_TREE info:

        DecTree can be a tree-indexed data storage solution, a double-indexed linked tree, and far more because its stored data type is
        generic, so one might use it to store (**in RAM, for now**) double-indexed data and arrangements of double-indexed data.

        MAIN METHODS for DecTree<D> { //badum tss
            add(double,D) //add element at double index (address)
            get(double) //retrieve from that address
            tGet(double) //retrieves dtC DecTree
            ensureDev2() //ensure that dev2 exists
            dev1(double, D) //add double index at specified double value address
            dev1(double) //retrieve ""
            dev2(double, DecTree<D>()) //store systems of DecTree<D>'s (the centralized way, with 1-1 indexing)
            dev2(double) //retrieve from next node at particular index
        }
        
Reference for reader: Code Usage Examples kept up-to-date in DecTreeTester.java.