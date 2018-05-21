// package controller;
//
// public class FileController {
//     public FileController() {}
//
//
//     public readVersionFromFile() {
//       File f = new File(System.getProperty("user.dir") + "/ver.txt");
//       try {
//           List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath()), StandardCharsets.UTF_8);
//           for (String str : lines){
//               version = str;
//               System.out.println("Version: " + str);
//           }
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
//     }
//
//     public writeVersionToFile() {
//
//       File f = new File(System.getProperty("user.dir") + "/ver.txt");
//       if (f.exists()) f.delete();
//       f.createNewFile();
//       PrintWriter writer = new PrintWriter(f.getAbsoluteFile(), "UTF-8");
//       writer.println(inputLine);
//       System.out.println("Updated to version " + inputLine + " from version " + version);
//       writer.close();
//
//     }
//
//
//   public static ArrayList<String> readTextFile(String fileName) {
//
//         ArrayList<String> values = new ArrayList<String>();
//         FileReader file = null;
//
//         try {
//
//           file = new FileReader(fileName);
//           BufferedReader reader = new BufferedReader(file);
//           String line = "";
//           while ((line = reader.readLine()) != null) {
//             values.add(line);
//           }
//         } catch (Exception e) {
//             e.printStackTrace();
//             throw new RuntimeException(e);
//         } finally {
//           if (file != null) {
//             try {
//               file.close();
//             } catch (IOException e) {
//
//             }
//           }
//         }
//
//         return values;
//     }
//
//
// }
