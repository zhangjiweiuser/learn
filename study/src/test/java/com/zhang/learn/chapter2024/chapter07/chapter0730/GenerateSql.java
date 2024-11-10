package com.zhang.learn.chapter2024.chapter07.chapter0730;

import java.io.IOException;

public class GenerateSql {
    private static final String SQL_TEMPLATE = "update %s f ,(\n" +
            "select order_id,period,sum(amount) a104105 from %s rpf \n" +
            "where order_id ='%s' and fee_type = 'SUPPOSE' and bill_code = 'USER' \n" +
            "and fee_no in ('104','105') group by order_id,period) t \n" +
            "set f.amount = t.a104105 where f.order_id =t.order_id and f.period =t.period and f.fee_no='105' and f.fee_type = 'SUPPOSE' and f.bill_code = 'USER';";
    private static final String SQL2 = "update %s set amount=0 where order_id ='%s' and fee_type = 'SUPPOSE' and bill_code = 'USER' and fee_no='104';";
    public static void main(String[] args) throws IOException {
        String res = getString();
        System.out.println(res);


//        String param = "-2";
//        String[] split = param.split("-");
//        System.out.println(split.length);
//        System.out.println(split[1]);

//        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\文档\\新网银行\\maiduan.txt")));
//        List<String> strings = FileUtils.readLines(new File("D:\\文档\\新网银行\\maiduan.txt"), Charset.defaultCharset());
//        for(String s : strings){
//            String[] split = s.split(",");
//            System.out.println(String.format(SQL_TEMPLATE,split[1],split[1],split[0]));
//        }
//        System.out.println("-----------------");
//        for(String s : strings){
//            String[] split = s.split(",");
//            System.out.println(String.format(SQL2,split[1],split[0]));
//        }
    }

    private static String getString(){
        try{
            double t = 1/0;
        }catch (Exception e){
            return "异常了";
        }finally {
            System.out.println("我走到finally");
        }
        return "最后结果";
    }
}
