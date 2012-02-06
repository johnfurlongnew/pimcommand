package pim.model;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Contact implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String email;
  private boolean imEnabled;
  private String nickName;
  private String ID;
  private String notes;

  public Contact()
  {
  }

  public Contact(String lastName, String firstName, String email)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.imEnabled = false;
  }

  public Contact(String lastName, String firstName, String email, String nickName, String ID)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.imEnabled = true;
    this.nickName = nickName;
    this.ID = ID;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  public String getNotes()
  {
    return notes;
  }

  @Override
  public String toString()
  {
    String str = lastName + ", " + firstName + ", " + email;
    if (imEnabled)
    {
      str += ", " + nickName + ", " + ID;
    }
    return str;
  }

  @Override
  public boolean equals(Object other)
  {
    return EqualsBuilder.reflectionEquals(this, other);
  }

  @Override
  public int hashCode()
  {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getNickName()
  {
    return nickName;
  }

  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public String getID()
  {
    return ID;
  }

  public void setID(String ID)
  {
    this.ID = ID;
  }

  public boolean isIMEnabled()
  {
    return imEnabled;
  }

  public void setIMEnabled(boolean enable)
  {
    this.imEnabled = enable;
  }
}
