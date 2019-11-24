package service;

import bean.Order;
import bean.Result;
import bean.Room;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDao;
import dao.RoomDao;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private RoomDao roomDao;
    //订单提交
    public Result commitOrder(Order order){
        Result result = new Result();
        long rBegin1 = order.getrBegin().getTime();
        long rEnd1 = order.getrEnd().getTime();
        List<Order> orders = findAllOrders();
        for(Order order1 :orders){
            if(order1.getRid() == order.getRid()){
                long rBegin = order1.getrBegin().getTime();
                long rEnd = order1.getrEnd().getTime();
                if((rBegin1 < rEnd && rBegin1 > rBegin) || (rEnd1 < rEnd && rEnd1 > rBegin)){
                   result.setResult(false);
                   result.setMessage("已被预订！");
                   return result;
                }
            }
        }
        order.setCreateTime(new Date());
        Jedis jedis = jedisPool.getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        String orderStr = null;
        try {
            orderStr = objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jedis.setex(order.getCode(),15*60,orderStr);
        result.setResult(true);
        result.setMessage("未预订");
        return result;
    }
    //付款
    public void pay(Order order){
        order.setPayYoN("Y");
        order.setPayTime(new Date());
        orderDao.addOrder(order);
        Jedis jedis = jedisPool.getResource();
        jedis.del(order.getCode());
    }
    //查看所有订单
    public List<Order> findAllOrders(){
        List<Order> orders = orderDao.findAllOrders();
        Jedis jedis = jedisPool.getResource();
        Set<String> set = jedis.keys("*");
        for(String s : set){
            String jackson = jedis.get(s);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Order order = objectMapper.readValue(jackson, Order.class);
                orders.add(order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }
    //根据房间号查看所有的预定时间
    public List<Order> findOrderById(int rid){
        List<Order> orders = findAllOrders();
        List<Order> rOrder = new ArrayList<>();
        for(Order order:orders){
            if(order.getRid() == rid){
                rOrder.add(order);
            }
        }
        return rOrder;
    }
}
