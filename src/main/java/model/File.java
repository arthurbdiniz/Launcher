package model;

public class File {

  private String id;
  private String fileName;
  private String fileSize;
  private String url;

  public File() {

  }

  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getFileName() {
      return fileName;
  }

  public void setFileName(String fileName) {
      this.fileName = fileName;
  }

  public String getFileSize() {
      return fileSize;
  }

  public void setFileSize(String fileSize) {
      this.fileSize = fileSize;
  }

}
