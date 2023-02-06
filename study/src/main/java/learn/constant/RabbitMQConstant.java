package learn.constant;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/17 13:44
 */
public class RabbitMQConstant {

    // 直连方式，生产者直接到消费者
    public static final String EXCHANGE_NAME = "exchange_demo";
    public static final String ROUTING_KEY = "routingkey_demo";
    public static final String QUEUE_NAME = "queue_demo";

    // 延迟队列方式
    //队列名称
    public final static String QUEUE_5_S = "queue5s";

    //交换机名称
    public final static String EXCHANGE_5_S = "exchange5s";

    // routingKey
    public final static String ROUNTING_KEY_5_S = "rountingkey5s";

    //死信消息队列名称
    public final static String deal_queue = "deal_queue_demo5";

    //死信交换机名称
    public final static String deal_exchangeName = "deal_deom5Exchange";

    //死信 routingKey
    public final static String dead_RoutingKey = "dead_routing_key";

    //死信队列 交换机标识符
    public static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";

    //死信队列交换机绑定键标识符
    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";
}
