package pim.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinarySerializer implements ISerializationStrategy
{
  public Object read(String filename) throws Exception
  {
    ObjectInputStream is = null;
    Object obj = null;

    try
    {
      is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
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
      os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
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
