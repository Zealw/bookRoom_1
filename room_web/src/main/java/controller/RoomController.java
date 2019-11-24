package controller;


import bean.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.RoomService;

import java.util.List;

@Controller
@RequestMapping("/room")
@SessionAttributes({"rooms"})
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/findAll")
    public ModelAndView findAllRoom(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allRoom");
        List<Room> rooms = roomService.findAllRoom();
        modelAndView.getModelMap().addAttribute("rooms",rooms);
        return modelAndView;
    }
}
