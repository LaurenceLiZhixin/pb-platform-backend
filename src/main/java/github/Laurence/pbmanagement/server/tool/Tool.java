package github.Laurence.pbmanagement.server.tool;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Tool {
    public static String ReadFromBody(BufferedReader bufferedReader) throws IOException {
        String inputLine;
        StringBuilder bodyStr = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null ){
            bodyStr.append(inputLine);
        }
        return bodyStr.toString();
    }

    public static String ReadFromFile(File f) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
        // 建立一个对象
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while (line != null) {
            // 一次读入一行数据
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = br.readLine();
        }
        br.close();
        reader.close();
        return stringBuilder.toString();
    }

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
