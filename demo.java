//terminal version. likely little if any gui.

class ServerSide{
    class Projection{
        //Projection of a person. This will store personal information and must not represent a whole person. A reasonably less holistic **projection** at most.
        class Tag{

        }
        class Add{
            //Add.=address
        }

    }

    DecTree<Projection.Tag> tags;
    DecTree<Projection.Add> addresses;
    DecTree<Projection> projections;

    class StoredInfo{
        /*READ:
            INFORMATION IS ALWAYS STORED IN AN ACTIVE STOREDINFO CLASS. IT IS, BY DEFAULT, ZERO-VALUED
        */
        class Covid{
            boolean covidPositive=false;
        }

        class Date{

        }
    }
    
}