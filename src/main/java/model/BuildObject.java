package model;

public class BuildObject {

  private String id;
  private String version;
  private String plataform;
  private FileObject file;

  public BuildObject() {
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

  public FileObject getFile() {
      return file;
  }

  public void setFile(FileObject file) {
      this.file = file;
  }

  public String getPlataform() {
      return plataform;
  }

  public void setPlataform(String plataform) {
      this.plataform = plataform;
  }

}
