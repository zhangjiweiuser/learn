package learn;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/10 10:56
 */
public class JSONTest {

    public static void main(String[] args) throws Exception {
//        JSONObject json = new JSONObject();
//        json.put("a",1);
//        json.put("b",1);
//        json.put("c",1);
//        System.out.println(Joiner.on(",").join(json.values()));
//        NumberFormat nf = NumberFormat.getInstance();
//        System.out.println(nf.format(0.50));
//        System.out.println(nf.format(3.300));
//        System.out.println(nf.format(300));
//        System.out.println(UUID.randomUUID().toString());
//        System.out.println(URLEncoder.encode("aa", "UTF-8"));
//        System.out.println(URLEncoder.encode("张三", "UTF-8"));
//        System.out.println(DigestUtils.md5DigestAsHex("张三".getBytes()));
//        System.out.println(DigestUtils.md5DigestAsHex(URLEncoder.encode("张三", "UTF-8").getBytes()));
//        System.out.println("aa".concat("bb"));
//        System.out.println(UUID.randomUUID().toString());
//        int[] arr = {2561, 4652, 18, 4819, 2896};
//
//        for (int i = 0; i < 10; i++) {
//            Set<Integer> result = Sets.newHashSet();
//            int num = ThreadLocalRandom.current().nextInt(0, 6);
//            while (result.size() < num) {
//                result.add(arr[ThreadLocalRandom.current().nextInt(0, 5)]);
//            }
//            System.out.println(num);
//            System.out.println(result);
//        }
        double t1 = 1.2;
        for(int i=0;i<10;i++){
            t1 = t1*1.2;
        }
        System.out.println(t1);
    }
}
