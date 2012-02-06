package pim.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class XMLSerializer implements ISerializationStrategy
{
  public Object read(String filename) throws Exception
  {
    ObjectInputStream is = null;
    Object obj = null;

    try
    {
      XStream xstream = new XStream(new DomDriver());
      is = xstream.createObjectInputStream(new FileReader(filename));
      obj = is.readObject();
    }
    finally
    {
      if (is != null)
      {
        is.close();
      }
    }
    return obj;
  }

  public void write(String filename, Object obj) throws Exception
  {
    ObjectOutputStream os = null;

    try
    {
      XStream xstream = new XStream(new DomDriver());
      os = xstream.createObjectOutputStream(new FileWriter(filename));
      os.writeObject(obj);
    }
    finally
    {
      if (os != null)
      {
        os.close();
      }
    }

  }
}
