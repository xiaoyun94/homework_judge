import java.util.ArrayList;

public class Lanuch
{
  public static void main(String[] args)
  {
    StudentList.students.add(new Student(11310119, "fangge", 1));
    ((Student)StudentList.students.get(0)).addAssignment(new Assignment(1, new double[] { 1.0D, 1.0D, 1.0D }, "22"));
    ((Student)StudentList.students.get(0)).addAssignment(new Assignment(3, new double[] { 2.0D }, "22"));
    ((Student)StudentList.students.get(0)).addAssignment(new Assignment(2, new double[] { 3.0D }, "22"));
    ((Student)StudentList.students.get(0)).addAssignment(new Assignment(5, new double[] { 4.0D }, "22"));
    ((Student)StudentList.students.get(0)).addAssignment(new Assignment(4, new double[] { 5.0D }, "22"));
    
    StudentList.students.add(new Student(11310120, "Song cheng", 1));
    ((Student)StudentList.students.get(1)).addAssignment(new Assignment(1, new double[] { 1.0D, 1.0D, 1.0D }, "22"));
    ((Student)StudentList.students.get(1)).addAssignment(new Assignment(3, new double[] { 2.0D }, "22"));
    ((Student)StudentList.students.get(1)).addAssignment(new Assignment(2, new double[] { 3.0D }, "22"));
    ((Student)StudentList.students.get(1)).addAssignment(new Assignment(5, new double[] { 4.0D }, "22"));
    ((Student)StudentList.students.get(1)).addAssignment(new Assignment(4, new double[] { 5.0D }, "22"));
    ((Student)StudentList.students.get(1)).setEmail("xiao@qq.com");
    MainFrame mainFrame = new MainFrame(1);
    mainFrame.setVisible(true);
  }
}
