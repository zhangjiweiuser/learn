package learn.chapter11.chapter1116;

import java.io.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/19 18:12
 */
public class FilterTest {
    public static void main(String[] args) {
        String sql = "insert into whole_rent_price(home_city_id,car_type_name,price_id,total_price,month_price,created_stime,modified_stime)" +
                "values (%d,'%s',%d,%d,%d,%s,%s);";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("d:/price.txt")));
            String line;
            while((line = br.readLine()) != null){
                String[] arr = line.split("\t");
                String citys = arr[6];
                String[] city = citys.split(",");
                for(String ci : city){

                System.out.println(String.format(sql,getCityCode(ci),arr[0],getPriceType(arr[1]),Integer.valueOf(arr[2])*100,monthPrice(arr[1],arr[2]),"now()","now()"));
                }
//                System.out.println(arr[0]+"--"+arr[1]+"--"+arr[2]+"--"+arr[6]);
//                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int monthPrice(String name,String totalPrice){
        switch (name){
            case "月租":
                return Integer.valueOf(totalPrice)*100;
            case "季租":
                return Integer.valueOf(totalPrice)/3*100;
            case "租三送一":
                return Integer.valueOf(totalPrice)/4*100;
            case "租五送二":
                return Integer.valueOf(totalPrice)/7*100;
            case "年租":
                return Integer.valueOf(totalPrice)/12*100;
            default:return 0;
        }
    }

    private static int getPriceType(String name){
        switch (name){
            case "月租":
                return 1;
            case "季租":
                return 2;
            case "租三送一":
                return 3;
            case "租五送二":
                return 4;
            case "年租":
                return 5;
                default:return 0;
        }
    }

    private static int getCityCode(String name){
        switch (name){
            case "宁波":
                return 330200;
            case "杭州":
                return 330100;
            case "青岛":
                return 370200;
            case "天津":
                return 120100;
            case "武汉":
                return 420100;
            default:return 0;
        }
    }
}
