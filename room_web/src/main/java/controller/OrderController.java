package controller;

import bean.Order;
import bean.Result;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/add")
    public ModelAndView addOrder(int rid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addOrder");
        modelAndView.getModelMap().addAttribute("rid",rid);
        List<Order> orders = orderService.findOrderById(rid);
        modelAndView.getModelMap().addAttribute("orders",orders);
        return modelAndView;
    }
    @RequestMapping("/myOrder")
    public ModelAndView myOrder(Order order){
        order.setCode(String.valueOf(UUID.randomUUID()));
        Result result = orderService.commitOrder(order);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.getModelMap().addAttribute("result",result);
        modelAndView.getModelMap().addAttribute("order",order);
        return modelAndView;
    }
    @RequestMapping("/pay")
    public String pay(Order order){
        orderService.pay(order);
        return "forward:/order/allOrder";
    }
    @RequestMapping("/allOrder")
    public ModelAndView allOrder(){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderService.findAllOrders();
        modelAndView.getModelMap().addAttribute("orders",orders);
        modelAndView.setViewName("allOrder");
        return modelAndView;
    }
}
