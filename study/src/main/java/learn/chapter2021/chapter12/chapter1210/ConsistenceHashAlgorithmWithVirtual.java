package learn.chapter2021.chapter12.chapter1210;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/10 16:44
 */
public class ConsistenceHashAlgorithmWithVirtual {
    public static void main(String[] args) {
        // 2台服务器
        String[] serverIps = new String[]{"159.110.222.33", "159.101.222.34"};
        //存到TreeMap中，TreeMap自带排序
        TreeMap<Integer, String> serverMapping = new TreeMap<>();
        //定义每个真实服务器虚拟出3个节点
        int virtualNodeCount = 3;
        for (String serverIp : serverIps) {
            int index = Math.abs(serverIp.hashCode());
            //存储映射关系 <Hash值，服务器ip>
            serverMapping.put(index, serverIp);
            //建立虚拟节点的映射
            for (int i = 0; i < virtualNodeCount; i++) {
                String vServerIp = i + "#" + serverIp;
                int vIndex = Math.abs(vServerIp.hashCode());
                //存储映射关系 <Hash值，虚拟节点ip>，为了便于查看，在虚拟节点ip前加上“虚拟节点”标识
                serverMapping.put(vIndex, "虚拟节点" + vServerIp);
            }
        }

        //来20个客户端
        String[] clientIps = new String[]{
                "123.23.90.89", "124.34.78.67", "134.55.66.55", "156.56.124.60", "167.67.88.45",
                "123.44.90.11", "124.34.78.22", "12.45.166.33", "156.69.34.44", "58.67.188.55",
                "34.23.90.45", "124.255.78.67", "134.12.66.55", "99.56.124.60", "167.67.58.45",
                "123.44.90.11", "88.34.72.22", "43.45.65.49", "156.69.68.167", "126.67.44.55"
        };

        //根据客户端的Hash值在哈希环上找顺时针第一个可以处理请求的服务器
        for (String clientIp : clientIps) {
            //计算客户端的Hash值
            int clientHash = Math.abs(clientIp.hashCode());
            //获取比客户端Hash值大的映射表

            SortedMap<Integer, String> sortedMap = serverMapping.tailMap(clientHash);
            String handlerServerIp = null;
            //如果映射表为空，说明没有任何一个服务器ip的Hash值比当前客户端ip的Hash值大
            if (sortedMap.isEmpty()) {
                //因为哈希环，交予顺时针第一台服务器处理
                handlerServerIp = serverMapping.get(serverMapping.firstKey());
            } else {
                //否则，交予顺时针第一台服务器处理
                handlerServerIp = serverMapping.get(sortedMap.firstKey());
            }
            System.out.println("客户端 " + clientIp + " 的请求被服务器 " + handlerServerIp + " 处理");
        }
    }
}
