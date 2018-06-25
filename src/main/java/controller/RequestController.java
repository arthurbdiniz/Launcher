package controller;

import model.*;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import listener.*;


public class RequestController {

  private HttpURLConnection httpUrlConnection;
  private URL url;
  private URL baseUrl;
  private String path;


  public RequestController() {}

  public BuildObject getVersionRequest(String path) throws IOException, ParseException {
    this.path = path;
    initConnection();
    setConnectionTimeOut();
    setConnectionHeader();

    String response = responseReader();
    // System.out.println(response);
    disconnect();

    return responseToObject(response);
  }

  private void initConnection() throws IOException {
    url =  new URL("http://ec2-18-231-174-28.sa-east-1.compute.amazonaws.com:3000" + path);
    httpUrlConnection = (HttpURLConnection) url.openConnection();
    httpUrlConnection.setRequestMethod("GET");
  }

  private void setConnectionTimeOut() throws IOException {
    httpUrlConnection.setConnectTimeout(5000);
    httpUrlConnection.setReadTimeout(5000);
  }

  private void setConnectionHeader() {
    httpUrlConnection.setRequestProperty("Content-Type", "application/json");
  }

  private void disconnect() {
    httpUrlConnection.disconnect();
  }

  private void addRequestParameters() throws IOException {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("param1", "val");

    httpUrlConnection.setDoOutput(true);
    DataOutputStream dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());
    dataOutputStream.writeBytes(getParamsString(parameters));
    dataOutputStream.flush();
    dataOutputStream.close();
  }

  private String responseReader() throws IOException {
    int status = httpUrlConnection.getResponseCode();
    BufferedReader in = new BufferedReader(
    new InputStreamReader(httpUrlConnection.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
    }
    in.close();
    return content.toString();
  }

  private static String getParamsString(Map<String, String> params)
      throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
          result.append("=");
          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
          result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
          ? resultString.substring(0, resultString.length() - 1)
          : resultString;
  }

  private BuildObject responseToObject(String response) throws ParseException{
    JSONParser parser = new JSONParser();

    JSONArray json = (JSONArray) parser.parse(response);
    JSONObject jsonComplete = (JSONObject) json.get(0);

    JSONObject jsonBuild = (JSONObject) jsonComplete.get("build");
    JSONObject jsonFile = (JSONObject) jsonComplete.get("file");

    // Create File
    FileObject file = new FileObject();
    file.setId(jsonFile.get("id").toString());
    file.setFileName(jsonFile.get("file_name").toString());
    file.setFileSize(jsonFile.get("file_size").toString());
    file.setUrl(jsonFile.get("url").toString());

    // Create Build
    BuildObject build = new BuildObject();
    build.setId(jsonBuild.get("id").toString());
    build.setVersion(jsonBuild.get("version").toString());
    build.setPlataform(jsonBuild.get("plataform").toString());
    build.setFile(file);

    return build;

  }

}
