package pim.model;

import pim.util.ISerializationStrategy;

public class Pim
{
  private AddressBook addressBook;
  private ISerializationStrategy serializer;

  public Pim()
  {
    serializer = null;
    newPim();
  }

  public Pim(ISerializationStrategy serializer)
  {
    this.serializer = serializer;
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
    addressBook = (AddressBook) serializer.read(filename);
  }

  public void save(String filename) throws Exception
  {
    serializer.write(filename, addressBook);
  }
}
