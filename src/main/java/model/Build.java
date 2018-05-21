package model;

public class Build {

  private String id;
  private String version;
  private File file;

  public Build() {

  }

  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getVersion() {
      return version;
  }

  public void setVersion(String version) {
      this.version = version;
  }

  public File getFile() {
      return file;
  }

  public void setFile(File file) {
      this.file = file;
  }

}
