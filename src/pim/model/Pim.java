package pim.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Pim
{
  private AddressBook addressBook;

  public Pim()
  {
    newPim();
  }

  public AddressBook getAddressBook()
  {
    return addressBook;
  }

  public void newPim()
  {
    addressBook = new AddressBook();
  }

  public void open(String filename) throws Exception
  {
    ObjectInputStream is = null;

    try
    {
      XStream xstream = new XStream(new DomDriver());
      is = xstream.createObjectInputStream(new FileReader(filename));
      addressBook = (AddressBook) is.readObject();
    }
    finally
    {
      if (is != null)
      {
        is.close();
      }
    }
  }

  public void save(String filename) throws Exception
  {
    ObjectOutputStream os = null;

    try
    {
      XStream xstream = new XStream(new DomDriver());
      os = xstream.createObjectOutputStream(new FileWriter(filename));
      os.writeObject(addressBook);
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
