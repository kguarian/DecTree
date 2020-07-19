#README

The description of this project is a series of code snippets that should compile. The method usage should be straightforward. More importantly, it should be yours.
EDIT: I REWROTE A LOT OF CODE. I HAVE NO IDEA WHETHER ANY OF THE CODE IN THIS FILE STILL RUNS. WILL WORK ON UPDATING PROMPTLY.

INITIAL STATE:

null

``Type[] typeVals = new typeVals[args.length];
``typeVals[0] = new Type(args[0]);
``for(int i = 1; i < args.length; i++){
``  typeVals[i] = new Type(typeVals[i-1]);
``}
``DigitTree<Type> tree = new DigitTree<Type>();
    
tree: []

``for(int i = 0; i < args.length; i++){
``  tree.add(i, typeVals[i]);
``}

tree: [tree arrangement of all generated Type values.]

``for(int i = 0; i < args.length; i++){
``  System.out.println(tree.get(i))
``}

//ASSUME args[] LENGTH 10,000,888,999,915,207
``DigitTree<Type> lineage = tree.newLineage(0); //return value for newLineage is ::: new DigitTree<DigitTree<Type>>(); ::: empty DigitTree<DigitTree<Type>>();
``lineage.start(0, tree.get(5));
``lineage.pro(1, tree.get(1));
``lineage.pro(2, tree.get(2));
``lineage.pro(3, tree.get(3));
``lineage.pro(4, tree.get(4));
``lineage.end();
``System.out.println(lineage.eget(2).toString());
//That would print typeVals[2];
``lineage.start(lineage.slen(0), tree.get(5));
``lineage.anti(6, tree.get(6));
``lineage.pro(7, tree.get(7));
``lineage.pro(8, tree.get(8));
//Can add dimensionality; Describing the tree from here is not necessarily useful
