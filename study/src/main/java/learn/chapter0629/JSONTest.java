package learn.chapter0629;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/6/29 16:14
 */
public class JSONTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1,"aa"));
        users.add(new User(2,"bb"));
        JSONObject json = new JSONObject();
        json.put("data",users);
        System.out.println(JSONObject.toJSONString(json));

        try(BufferedReader br = new BufferedReader(new FileReader(new File("D:/bb.txt")))){
            String str = br.readLine();
            JSONObject result = JSONObject.parseObject(str);
            String data = result.getString("data");
            data = data.replaceAll("}\"","}").replaceAll("\"\\{","{");
            System.out.println(data);
            JSONArray obj = JSON.parseArray(data);
            for(int i=0;i<obj.size();i++){
               JSONObject item = obj.getJSONObject(i);
                System.out.println(JSONObject.toJSONString(item));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
