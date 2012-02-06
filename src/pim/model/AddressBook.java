package pim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<Contact> contactList;

  public AddressBook()
  {
    contactList = new ArrayList<Contact>();
  }

  public boolean isContact(Contact contact)
  {
    return contactList.contains(contact);
  }

  public void deleteContact(Contact contact)
  {
    contactList.remove(contact);
  }

  public void addContact(Contact contact)
  {
    contactList.add(contact);
  }

  public Contact getContact(String email)
  {
    for (Contact contact : contactList)
    {
      if (contact.getEmail().equals(email))
      {
        return contact;
      }
    }
    return null;
  }

  public int size()
  {
    return contactList.size();
  }

  public void clear()
  {
    contactList.clear();
  }

  @Override
  public String toString()
  {
    String str = new String();
    for (Contact contact : contactList)
    {
      str += contact + "\n";
    }
    return str;
  }
}
