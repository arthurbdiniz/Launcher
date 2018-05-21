package controller;

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

import listener.*;


public class RequestController {

  private HttpURLConnection httpUrlConnection;
  private URL url;

  public RequestController() {}

  public  void getRequest() throws IOException {
    initConnection();
    setConnectionTimeOut();
    setConnectionHeader();

    responseReader();
    disconnect();
  }

  private void initConnection() throws IOException {
    url =  new URL("http://ec2-54-233-228-194.sa-east-1.compute.amazonaws.com:3000/builds/Windows");
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

  private void responseReader() throws IOException {
    int status = httpUrlConnection.getResponseCode();
    BufferedReader in = new BufferedReader(
    new InputStreamReader(httpUrlConnection.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
        System.out.println(inputLine);
    }
    in.close();
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

}
