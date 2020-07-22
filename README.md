#DecTree

The DecTree is the first generation multi-indexing, mutable (revisit phrasing) data structure.

With arrays, one cannot insert a value. For instance, if one must insert n values into integer array of length n, then insert another value between two others, i.e.:

**//En-method**

    int[] foo = new int{1,2,3,5};

Goal: insert a 4 between the 3 and 5.

    foo[3]=4;

//we still don't have 1,2,3,4,5

    foo[3]=3;

//reset

    foo[4]=4;
    foo[3]=5;

//same issue

**DecTree Implementation:**

//Same problem set up

    int[] given = new int[]{1,2,3,4,5]
    DecTree<Integer> sample = new DecTree<Integer>();
    for(int i = 0; i < int.length; i++){
        sample.add(i, given[i]);
    }


**Alternative solutions:**

1

    //link the missing value in

    demo.tGet(3).pro(0,demo.add(4)).pro(0,demo.tGet(4).pro();
    demo.tGet(5).anti(0, demo.tGet(3).pro(0)).anti(0, demo.tGet(3));

    /*retrieval:

    demo.tGet(3).pro(0);
    
    //you'll have to remember/automate that you added a value between 3 and 4 along the pro-0 line.

    :laveirter*/




2

    //add the missing value under the value which shold "preceed" it

    demo.add(3, 4);

    ****you will havee to independently implement the mechanism to retrieve this. 




