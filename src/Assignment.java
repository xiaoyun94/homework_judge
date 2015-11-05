import java.io.Serializable;

public class Assignment
  implements Serializable
{
  private int name;
  private double[] score;
  private double average;
  private String comments;
  
  public Assignment(int name, double[] score, String comments)
  {
    this.comments = comments;
    this.name = name;
    this.score = score;
    setAverage();
  }
  
  public String getComments()
  {
    return this.comments;
  }
  
  public void setComments(String comments)
  {
    this.comments = comments;
  }
  
  public void setAverage(double average)
  {
    this.average = average;
  }
  
  public int getName()
  {
    return this.name;
  }
  
  public void setName(int name)
  {
    this.name = name;
  }
  
  public double[] getScore()
  {
    return this.score;
  }
  
  public void setScoreByIndex(Integer index, double ascore)
  {
    this.score[index.intValue()] = ascore;
  }
  
  public double getAverage()
  {
    return this.average;
  }
  
  public void setAverage()
  {
    double sum = 0.0D;
    for (int i = 0; i < this.score.length; i++) {
      sum += this.score[i];
    }
    this.average = (sum / this.score.length);
  }
}
