package helper;

import java.io.File;

public class FilePermission {

    private File file;


    public FilePermission(String path) {
      file = new File(path);
    }

    public void setExecute(boolean allow) {
      file.setExecutable(allow);
    }

    public void setWrite(boolean allow) {
      file.setWritable(allow);
    }

    public void setRead(boolean allow) {
      file.setReadable(allow);
    }

    public void setAll(boolean allow) {
      file.setExecutable(allow);
      file.setWritable(allow);
      file.setReadable(allow);
      getAllStatus();
    }

    public void getExecuteStatus() {
      System.out.println("Is Execute allow : " + file.canExecute());
    }

    public void getWriteStatus() {
      System.out.println("Is Write allow : " + file.canWrite());
    }

    public void getReadStatus() {
      System.out.println("Is Read allow : " + file.canRead());
    }

    public void getAllStatus() {
      System.out.println("Is Execute allow : " + file.canExecute());
      System.out.println("Is Write allow : " + file.canWrite());
      System.out.println("Is Read allow : " + file.canRead());
    }
}
