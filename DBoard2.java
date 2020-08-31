import javax.xml.crypto.Data;

public class DBoard2 {
    public static void main(String[] args) {
        DataBase.main(args);
    }
}

class DataBase {
    DataBase originial = this;
    DataBase parent;
    DecTree<DataBase> categories;
    DecTree<String> data;
    DecTree<Long> primes;
    int primeIndex;

    // Level 3
    protected DecTree<DataBase> addCat(String tag) {
        long hash = hasher(tag);
        DataBase added = new DataBase();
        added.originial = this.originial;
        added.parent = this;
        DecTree<DataBase> newCategory = this.categories.add(hash, added);
        return newCategory;
    }

    protected DecTree<String> addValue(String tag, String value) {
        long hash = hasher(tag);
        DecTree<String> newCategory = this.data.add(hash, value);
        newCategory.dtP = this.data;
        return newCategory;
    }

    // Level 2
    protected DataBase() {
        this.categories = new DecTree<DataBase>();
        this.data = new DecTree<String>();
        this.primes = new DecTree<Long>();
        this.primes.add(1, 2l);
        this.primeIndex = 1;
    }

    // Level 1
    protected long hasher(String tag) {
        char max = 0;
        long hashValue = 0;
        for (int i = 0; i < tag.length(); i++) {
            char currentChar = tag.charAt(i);
            if (tag.charAt(i) > max) {
                max = currentChar;
            }
        }
        for (int i = 0; i < tag.length(); i++) {
            hashValue += tag.charAt(i) * prime(i + 1);
        }
        return hashValue;
    }

    // Level 0
    protected long prime(int index) {
        DecTree<Boolean> superUsed = new DecTree<Boolean>();
        DecTree<Boolean> used = superUsed;
        for (long i = this.primes.get(primeIndex) + 1; i < this.primes.get(primeIndex) * 2; i++) { // Bertrand's
                                                                                                   // Postulate
            if (this.primeIndex >= index) {
                break;
            }
            for (int j = 1; j <= this.primeIndex; j++) {
                if (this.primeIndex >= index) {
                    break;
                }
                if (i % this.primes.get(j) == 0) {
                    break;
                } else {
                    used.add(j, true);
                    try {
                        if (used.tGet(primeIndex) != null) {
                            // we won't have to catch the nullpointerexception
                        }
                    } catch (NullPointerException e) {
                        continue;
                    }
                    primes.add(++primeIndex, i);
                }
                // LOOP ENDS HERE
            }
        }
        return primes.get(index);
    }

    public static void main(String[] args) {
        DecTree<Long> results = new DecTree<Long>();
        int resultsSize = 0;
        DecTree<Long> store = new DecTree<Long>();
        for (int limit = 0; limit < Integer.parseInt(args[0]); limit *= 10) {
            Long initialTime = System.nanoTime();
            store = new DecTree<Long>();
            for (int i = 0; i < limit; i++) {
                store.add(i, (long) i);
            }
            store = new DecTree<Long>();
            results.add(resultsSize++, System.nanoTime()-initialTime);
        }
        for(int i = 0; i < resultsSize; i++){
            System.out.println(results.get(i));
        }
    }
}

class APPLICATION {

}