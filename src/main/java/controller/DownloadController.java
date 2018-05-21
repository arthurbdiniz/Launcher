// package controller;
//
// import java.io.IOException;
// import java.io.*;
//
// public class DownloadController {
//
//   public DownloadController() {
//
//   }
//
//   public void downloadTask() {
//
//         URL url = new URL("");
//         final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//         conn.setRequestMethod("HEAD");
//         File fi = new File("res/" + str);
//         if (!fi.getParentFile().exists()){
//             fi.getParentFile().mkdirs();
//         }
//         System.out.println((fi.length() != conn.getContentLength()) + " " + fi.length() + " || " +  conn.getContentLength());
//
//         if (!fi.exists() || fi.length() != conn.getContentLength()){
//
//           Thread t = new Thread() {
//               @Override public void run() {
//                   download("http://www.endcraft.net/webstart/res/" + str, "res/" + str, conn.getContentLength());
//               }
//           };
//           t.start();
//           threads.add(t);
//         }
//
//
//       }
//
//   private void download(String source, String destination, int size) {
//
//       // ten percent of the total download size
//       File ofile = new File(System.getProperty("user.dir") + "", destination);
//       try {
//           if (ofile.exists()) ofile.delete();
//           if (!ofile.createNewFile()) {
//               throw new IOException("Can't create " + ofile.getAbsolutePath());
//           }
//
//           int inChar = 0;
//           URL url = new URL(source);
//           InputStream input = url.openStream();
//           FileOutputStream fos = new FileOutputStream(ofile);
//           for (int i = 0; i < size && inChar != -1; i++) {
//               if (System.nanoTime() > lastTime + 2000000000){
//                   lastTime = System.nanoTime();
//               int percentage = (int) ((i * 100.0f) / size);
//
//               progressBar.setValue(((int) ((percentage * 100.0f) / 100)));
//               fr.setTitle(ofile.getName() + ": " + progressBar.getValue() + "%" + " Total: " + oprogressBar.getValue() + "%");
//               }
//               inChar = input.read();
//               fos.write(inChar);
//           }
//
//           //oprogressBar.setValue((int) ((i * 100.0f) / threads.size()));
//           input.close();
//           fos.close();
//           System.out.println("Downloaded " + ofile.getAbsolutePath());
//       } catch (EOFException e) {
//           e.printStackTrace();
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
//   }
//
// }
