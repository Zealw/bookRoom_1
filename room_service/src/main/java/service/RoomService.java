package service;

import bean.Result;
import bean.Room;
import dao.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private JedisPool jedisPool;
    public List<Room> findAllRoom(){
        return roomDao.findAll();

    }
    public void clickRoom(Room room){
        Jedis jedis = jedisPool.getResource();
        jedis.setex(String.valueOf(room.getId()),15*60,room.isBook());
    }
    public Result updateRoomStatus(Room room){
        Result result = new Result();
        Jedis jedis = jedisPool.getResource();
        String status = jedis.get(String.valueOf(room.getId()));
        if(status.equals(room.isBook())){
            room.setDate(new Date());
            roomDao.updateRoomStatus(room);

            result.setResult(true);
            result.setMessage("预订成功");
        }else{
            result.setResult(false);
            result.setMessage("预订失败，已被预订");
        }
        return result;
    }
}
