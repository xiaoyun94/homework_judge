import java.io.Serializable;
import java.util.ArrayList;

public class Student
  implements Serializable
{
  private int id;
  private String name;
  private int requiredNumber;
  private String email;
  private ArrayList<Assignment> assignments;
  
  public Student(int id, String name)
  {
    this(id, name, 1);
  }
  
  public Student(int id, String name, int require)
  {
    this.id = id;
    this.name = name;
    this.requiredNumber = require;
    this.assignments = new ArrayList();
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public void addOnce()
  {
    this.requiredNumber += 1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public ArrayList<Assignment> getAssignments()
  {
    return this.assignments;
  }
  
  public void setAssignments(ArrayList<Assignment> assignments)
  {
    this.assignments = assignments;
  }
  
  public boolean addAssignment(Assignment assignment)
  {
    int min = 0;
    int max = this.assignments.size() - 1;
    int mid = 0;
    while (max >= min)
    {
      mid = (min + max) / 2;
      if (((Assignment)this.assignments.get(mid)).getName() < assignment.getName())
      {
        min = mid + 1;
        mid++;
      }
      else
      {
        if (((Assignment)this.assignments.get(mid)).getName() < assignment.getName()) {
          return false;
        }
        max = mid - 1;
      }
    }
    this.assignments.add(mid, assignment);
    
    return true;
  }
  
  public int getRequiredNumber()
  {
    return this.requiredNumber;
  }
  
  public void setRequiredNumber(int requiredNumber)
  {
    this.requiredNumber = requiredNumber;
  }
  
  public String[][] getInformationArray()
  {
    int size = this.assignments.size();
    String[] a = new String[size + 3];
    String[] b = new String[size + 3];
    
    a[0] = "Name";
    b[0] = this.name;
    
    a[1] = "id";
    b[1] = String.valueOf(this.id);
    
    a[2] = "#sub";
    b[2] = String.valueOf(size);
    for (int i = 0; i < size; i++)
    {
      a[(i + 3)] = String.format("HW%s", new Object[] { Integer.valueOf(i + 1) });
      b[(i + 3)] = String.valueOf(((Assignment)this.assignments.get(i)).getAverage());
    }
    return new String[][] { a, b };
  }
  
  public String toString()
  {
    return 
      "Student [id=" + this.id + ", name=" + this.name + ", requiredNumber=" + this.requiredNumber + ", assignments=" + this.assignments + "]";
  }
}
