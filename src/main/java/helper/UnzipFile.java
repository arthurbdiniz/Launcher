package helper;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipInputStream;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipFile;



public class UnzipFile {
    public UnzipFile() {

    }

    public static final void unzip(File zip, File extractTo) throws IOException {
      ZipFile archive = new ZipFile(zip);
      Enumeration e = archive.entries();
      while (e.hasMoreElements()) {
          ZipEntry entry = (ZipEntry) e.nextElement();
          File file = new File(extractTo, entry.getName());
          if (entry.isDirectory() && !file.exists()) {
              file.mkdirs();
          } else {
              if (!file.getParentFile().exists()) {
                  file.getParentFile().mkdirs();
              }

              InputStream in = archive.getInputStream(entry);
              BufferedOutputStream out = new BufferedOutputStream(
                      new FileOutputStream(file));

              byte[] buffer = new byte[8192];
              int read;

              while (-1 != (read = in.read(buffer))) {
                  out.write(buffer, 0, read);
              }
              in.close();
              out.close();
        }
      }
    }

}
