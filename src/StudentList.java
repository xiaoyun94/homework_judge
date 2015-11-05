import java.util.ArrayList;

public class StudentList
{
  static ArrayList<Student> students = new ArrayList();
  public static final int STUDENT_EXISTED = -1;
  public static final int STUDENT_ADD_OK = 1;
  
  /* Error */
  public static void loadFile(String filePath)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: new 32  java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 34 java/io/File:<init> (Ljava/lang/String;)V
    //   14: astore_1
    //   15: new 36 java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 38 java/io/FileInputStream:<init>  (Ljava/io/File;)V
    //   23: astore_2
    //   24: new 41 java/io/ObjectInputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 43 java/io/ObjectInputStream:<init>  (Ljava/io/InputStream;)V
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 46 java/io/ObjectInputStream:readObject  ()Ljava/lang/Object;
    //   37: checkcast 18 java/util/ArrayList
    //   40: putstatic 23 StudentList:students  Ljava/util/ArrayList;
    //   43: goto +54 -> 97
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 50 java/lang/Exception:printStackTrace ()V
    //   53: aload_3
    //   54: invokevirtual 55 java/io/ObjectInputStream:close ()V
    //   57: aload_2
    //   58: invokevirtual 58 java/io/FileInputStream:close ()V
    //   61: goto +54 -> 115
    //   64: astore 6
    //   66: aload 6
    //   68: invokevirtual 50 java/lang/Exception:printStackTrace ()V
    //   71: goto +44 -> 115
    //   74: astore 5
    //   76: aload_3
    //   77: invokevirtual 55 java/io/ObjectInputStream:close ()V
    //   80: aload_2
    //   81: invokevirtual 58 java/io/FileInputStream:close ()V
    //   84: goto +10 -> 94
    //   87: astore 6
    //   89: aload 6
    //   91: invokevirtual 50 java/lang/Exception:printStackTrace ()V
    //   94: aload 5
    //   96: athrow
    //   97: aload_3
    //   98: invokevirtual 55 java/io/ObjectInputStream:close ()V
    //   101: aload_2
    //   102: invokevirtual 58  java/io/FileInputStream:close ()V
    //   105: goto +10 -> 115
    //   108: astore 6
    //   110: aload 6
    //   112: invokevirtual 50  java/lang/Exception:printStackTrace ()V
    //   115: return
    // Line number table:
    //   Java source line #17 -> byte code offset #0
    //   Java source line #18 -> byte code offset #2
    //   Java source line #19 -> byte code offset #4
    //   Java source line #22 -> byte code offset #6
    //   Java source line #23 -> byte code offset #15
    //   Java source line #24 -> byte code offset #24
    //   Java source line #26 -> byte code offset #33
    //   Java source line #28 -> byte code offset #43
    //   Java source line #29 -> byte code offset #46
    //   Java source line #30 -> byte code offset #48
    //   Java source line #34 -> byte code offset #53
    //   Java source line #35 -> byte code offset #57
    //   Java source line #36 -> byte code offset #61
    //   Java source line #37 -> byte code offset #64
    //   Java source line #38 -> byte code offset #66
    //   Java source line #32 -> byte code offset #74
    //   Java source line #34 -> byte code offset #76
    //   Java source line #35 -> byte code offset #80
    //   Java source line #36 -> byte code offset #84
    //   Java source line #37 -> byte code offset #87
    //   Java source line #38 -> byte code offset #89
    //   Java source line #41 -> byte code offset #94
    //   Java source line #34 -> byte code offset #97
    //   Java source line #35 -> byte code offset #101
    //   Java source line #36 -> byte code offset #105
    //   Java source line #37 -> byte code offset #108
    //   Java source line #38 -> byte code offset #110
    //   Java source line #43 -> byte code offset #115
    // Local variable table:
    //   start  length  slot  name  signature
    //   0  116 0 filePath  String
    //   1  19  1 file  java.io.File
    //   3  99  2 fileInputStream java.io.FileInputStream
    //   5  93  3 objectInputStream java.io.ObjectInputStream
    //   46 3 4 exception Exception
    //   74 21  5 localObject Object
    //   64 3 6 exception2  Exception
    //   87 3 6 exception2  Exception
    //   108  3 6 exception2  Exception
    // Exception table:
    //   from to  target  type
    //   6  43  46  java/lang/Exception
    //   53 61  64  java/lang/Exception
    //   6  53  74  finally
    //   76 84  87  java/lang/Exception
    //   97 105 108 java/lang/Exception
  }
  
  /* Error */
  public static void storeFile(String filePath)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: new 32  java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 34 java/io/File:<init> (Ljava/lang/String;)V
    //   14: astore_1
    //   15: new 76 java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 78 java/io/FileOutputStream:<init> (Ljava/io/File;)V
    //   23: astore_2
    //   24: new 79 java/io/ObjectOutputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 81 java/io/ObjectOutputStream:<init> (Ljava/io/OutputStream;)V
    //   32: astore_3
    //   33: aload_3
    //   34: getstatic 23 StudentList:students  Ljava/util/ArrayList;
    //   37: invokevirtual 84 java/io/ObjectOutputStream:writeObject  (Ljava/lang/Object;)V
    //   40: goto +54 -> 94
    //   43: astore 4
    //   45: aload 4
    //   47: invokevirtual 50 java/lang/Exception:printStackTrace ()V
    //   50: aload_3
    //   51: invokevirtual 88 java/io/ObjectOutputStream:close  ()V
    //   54: aload_2
    //   55: invokevirtual 89 java/io/FileOutputStream:close  ()V
    //   58: goto +54 -> 112
    //   61: astore 6
    //   63: aload 6
    //   65: invokevirtual 50 java/lang/Exception:printStackTrace ()V
    //   68: goto +44 -> 112
    //   71: astore 5
    //   73: aload_3
    //   74: invokevirtual 88 java/io/ObjectOutputStream:close  ()V
    //   77: aload_2
    //   78: invokevirtual 89 java/io/FileOutputStream:close  ()V
    //   81: goto +10 -> 91
    //   84: astore 6
    //   86: aload 6
    //   88: invokevirtual 50 java/lang/Exception:printStackTrace ()V
    //   91: aload 5
    //   93: athrow
    //   94: aload_3
    //   95: invokevirtual 88 java/io/ObjectOutputStream:close  ()V
    //   98: aload_2
    //   99: invokevirtual 89 java/io/FileOutputStream:close  ()V
    //   102: goto +10 -> 112
    //   105: astore 6
    //   107: aload 6
    //   109: invokevirtual 50  java/lang/Exception:printStackTrace ()V
    //   112: return
    // Line number table:
    //   Java source line #45 -> byte code offset #0
    //   Java source line #46 -> byte code offset #2
    //   Java source line #47 -> byte code offset #4
    //   Java source line #49 -> byte code offset #6
    //   Java source line #50 -> byte code offset #15
    //   Java source line #51 -> byte code offset #24
    //   Java source line #53 -> byte code offset #33
    //   Java source line #54 -> byte code offset #40
    //   Java source line #55 -> byte code offset #43
    //   Java source line #56 -> byte code offset #45
    //   Java source line #60 -> byte code offset #50
    //   Java source line #61 -> byte code offset #54
    //   Java source line #62 -> byte code offset #58
    //   Java source line #63 -> byte code offset #61
    //   Java source line #64 -> byte code offset #63
    //   Java source line #58 -> byte code offset #71
    //   Java source line #60 -> byte code offset #73
    //   Java source line #61 -> byte code offset #77
    //   Java source line #62 -> byte code offset #81
    //   Java source line #63 -> byte code offset #84
    //   Java source line #64 -> byte code offset #86
    //   Java source line #66 -> byte code offset #91
    //   Java source line #60 -> byte code offset #94
    //   Java source line #61 -> byte code offset #98
    //   Java source line #62 -> byte code offset #102
    //   Java source line #63 -> byte code offset #105
    //   Java source line #64 -> byte code offset #107
    //   Java source line #67 -> byte code offset #112
    // Local variable table:
    //   start  length  slot  name  signature
    //   0  113 0 filePath  String
    //   1  19  1 file  java.io.File
    //   3  96  2 fileOutputStream  java.io.FileOutputStream
    //   5  90  3 objectOutputStream  java.io.ObjectOutputStream
    //   43 3 4 exception Exception
    //   71 21  5 localObject Object
    //   61 3 6 exception2  Exception
    //   84 3 6 exception2  Exception
    //   105  3 6 exception2  Exception
    // Exception table:
    //   from to  target  type
    //   6  40  43  java/lang/Exception
    //   50 58  61  java/lang/Exception
    //   6  50  71  finally
    //   73 81  84  java/lang/Exception
    //   94 102 105 java/lang/Exception
  }
  
  public static int addStudent(Student student)
  {
    int min = 0;
    int max = students.size() - 1;
    int mid = 0;
    while (max >= min)
    {
      mid = (min + max) / 2;
      if (((Student)students.get(mid)).getId() < student.getId())
      {
        min = mid + 1;
        mid++;
      }
      else
      {
        if (((Student)students.get(mid)).getId() == student.getId()) {
          return -1;
        }
        max = mid - 1;
      }
    }
    students.add(mid, student);
    
    return 1;
  }
  
  public static Student getStudent(int id)
  {
    int min = 0;
    int max = students.size() - 1;
    int mid = 0;
    while (max >= min)
    {
      mid = (min + max) / 2;
      if (((Student)students.get(mid)).getId() < id)
      {
        min = mid + 1;
      }
      else
      {
        if (((Student)students.get(mid)).getId() == id) {
          return (Student)students.get(mid);
        }
        max = mid - 1;
      }
    }
    return null;
  }
  
  public static void addRequireTimes(int number)
  {
    for (int i = 0; i < students.size(); i++) {
      ((Student)students.get(i)).setRequiredNumber(number);
    }
  }
}
