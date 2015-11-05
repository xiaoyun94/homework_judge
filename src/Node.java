import java.io.File;
import java.io.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;

public class Node
  extends DefaultMutableTreeNode
{
  private String filepath;
  private Object object;
  
  public Node(Object object, String filepath)
  {
    super(object);
    this.object = object;
    this.filepath = filepath;
  }
  
  public String getFilePath()
  {
    return this.filepath;
  }
  
  public void setPath(String filepath)
  {
    this.filepath = filepath;
  }
  
  public String getName()
  {
    return this.object.toString();
  }
  
  public static void getAllNodes(Node parentNode)
  {
    File file = new File(parentNode.getFilePath());
    if (file.isDirectory())
    {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++)
      {
        Node thisnode = new Node(files[i].getName(), files[i].getPath());
        getAllNodes(thisnode);
        parentNode.add(thisnode);
      }
    }
  }
  
  public static void getAllNodes(Node parentNode, FileFilter filter)
  {
    File file = new File(parentNode.getFilePath());
    if (file.isDirectory())
    {
      File[] files = file.listFiles(filter);
      for (int i = 0; i < files.length; i++)
      {
        Node thisnode = new Node(files[i].getName(), files[i].getPath());
        getAllNodes(thisnode, filter);
        parentNode.add(thisnode);
      }
    }
  }
}
