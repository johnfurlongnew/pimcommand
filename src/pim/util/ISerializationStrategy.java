package pim.util;

public interface ISerializationStrategy
{
  void write(String filename, Object obj) throws Exception;
  Object read(String filename) throws Exception;
}
