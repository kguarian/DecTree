# DecTree (README IN PROGRESS)

## Overview

---

DecTree is a Base-10 trie for storing C# objects of Generic Type E by key-value pairs, where the key is a string or long (64-bit) integer.

Elements stored first at any particular address are returned first from that address.

## Documentation

---

### Structure:
Suppose we wish to a `DecTree` which stores `System.String`s called `example` (although `System.String` may be replaced by any object or struct type).
We accomplish this goal most directly with the following code: `DecTree<System.String> example = new DecTree<System.String>();`

`example` and any other `DecTree<System.String>` will have the following fields.

### Public Fields:

`DecTree<System.String> dt0, dt1, ..., dt9`: Numerical navigation trees.

`DecTree<System.String> dtC`: 'C'hild tree. These will usually store values inserted with an `Add` method.

`DecTree<System.String> dtP`: 'P'arent tree. This is exclusively used for navigation. to set a reference to `dtP` is to "move rootward". I advise against modifying this reference.

`DecTree<System.String> dtN`: 'N'egative/Special use tree. Where the most significant bit (MSB) of an index used for storing an `element` is 1, `dtN` is used for navigation. Where any particular `DecTree` is not used to store an element with negative 64-bit MSB, `dtN` may be used at the developer's leisure.

`long counter` : free for use by the developer. `counter` was originally used for indexing, but since `DecTree`s may contain cycles and nonempty `DecTrees` may be loaded by reference under other decTrees (and even themselves), the idea of a counter was simply not meaningful. Classes such as `DecString` and some internal methods use `counter` for indexing, but it is open for the developer to use. 

`System.String element` : This stores the element which is of type `System.String` in this case.

**Developers should privately encapsulate `DecTree`s inside of wrapper classes wherever they want any public fields to be private**

### Public Constructors
`DecTree<E>()` : Default constructor. Instantiates DecTree with no elements stored, all subtrees `null`.

`DecTree<E>(E element)` : Similar to `DecTree()`. Only distinction is that the following code sets `stored` to true:

---

`bool stored = false;`

`System.String message = message;`

`DecTree<System.String>(message).element == message`

---

### Public Methods

`void counterIncrement()`: Increments `counter` and initiates a recursive chain of `counter` increments in `dtP`. Complexity: O(h) where h is the distance from the `DecTree` wherein this method is called to the rootmost `DecTree`.

`void counterDecrement()`: Decrements `counter` and initiates a recursive chain of `counter` decrements in `dtP`. Complexity: O(h) where h is the distance from the `DecTree` wherein this method is called to the rootmost `DecTree`.

`DecTree<E> MakeDecTree(int type)`: mutator method used to add a `DecTree` conventionally. `type` values are encoded as follows: 0-9 correspond to `dt0`-`dt9`, respectively. `-1` corresponds to `dtN`, `-3` corresponds to `dtC`, `-100` corresponds to `dtP`.

*Note: `MakeDecTree(-100)` creates a self-loop on the root of the DecTree on which it's called. DO NOT CALL `counterIncrement()` OR `CounterDecrement()` IF YOU HAVE CALLED `MakeDecTree(-100)` ON THE REFERENCED `DecTree` OR ANY ROOTWARD DECTREES. IT WILL CAUSE AN INFINITE LOOP.*

`DecTree<E> GetDecTree(int type)` : accessor method used to retrieve fields according to the following convention: 0-9 correspond to `dt0`-`dt9`, respectively. `-1` corresponds to `dtN`, `-3` corresponds to `dtC`, `-100` corresponds to `dtP`.

---

`DecTree<E> GoGet(long address)` : accessor method for the DecTree storing the `element` stored at index `address`.

`DecTree<E> GoGet(String address)` : accessor method for the DecTree storing the `element` stored with key value `System.String address`. `address` is hashed to retrieve the desired `DecTree`

*Important: Assuming that the `address` and its relative `dtC` is instantiated, this will return a `DecTree` whose `dtC` field contains the element stored at `address` index. This action is similar that to returning a pointer in a lower-level languages, however this addressing convention allows for relative referencing. In this relative referencing model, Each `DecTree<E>` may have a unique indexing system.*

`DecTree<E> PaveTo(long address)` : Navigates to the tree corresponding to the index `address`, creating the necessary path if necessary. This is roughly equivalent to `malloc`.

`DecTree<E> PaveTo(string address)` : Navigates to the tree corresponding to the string key `address`, creating the necessary path if necessary. This is roughly equivalent to `malloc`.

`DecTree<E> GoGet(long address)` : Navigates to the tree corresponding to the index `address`, returning `null` if the index has not yet been 'Paved to'. This may be functionally similar to returning a pointer with a type-differentiated `null` value.

`DecTree<E> GoGet(string address)` : Navigates to the tree corresponding to the string key `address`, returning `null` if the index has not yet been 'Paved to'. This may be functionally similar to returning a pointer with a type-differentiated `null` value.

`DecPair<E> Add(E element)` : Adds `element` to the end of a `dtC` chain, returns a `DecPair<E>` with field `int Depth` set to the zero-indexed queueing index of `element` and `DecTree<E> Tree` set as a reference to the tree immediately rootward of that which stores `element`.

`E Get()` : returns element at `dtC.element` of referenced `DecTree`.

`DecPair<E> Add(long address, E element)` / `DecPair<E> Add(long address, E element)` : shorthand for `PaveTo(address).Add(element)`

`DecTree<E> TGet(long address)` / `DecTree<E> TGet(String address)` : shorthand for `GoGet(address).dtC`