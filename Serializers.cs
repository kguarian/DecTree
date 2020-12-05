using System.IO;
using System.Runtime.Serialization;
using System.Xml;

namespace Dec
{
    class XMLSerializer<E>
    {
        public void Write(E subject, string fileName)
        //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/concepts/serialization/how-to-write-object-data-to-an-xml-file
        {
            FileStream writer = new FileStream(fileName, FileMode.Append);
            System.Xml.Serialization.XmlSerializer ser =
                new System.Xml.Serialization.XmlSerializer(typeof(E));

            ser.Serialize(writer, subject);
            writer.Close();
        }

        public E Read(string fileName)
        //https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/concepts/serialization/how-to-read-object-data-from-an-xml-file
        {
            System.Xml.Serialization.XmlSerializer reader =
        new System.Xml.Serialization.XmlSerializer(typeof(E));
            System.IO.StreamReader file = new System.IO.StreamReader(fileName);
            E retObject = (E)reader.Deserialize(file);
            file.Close();
            return retObject;
        }
    }
}