package dao;

import bean.Room;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomDao {
    @Select("select *from room")
    List<Room> findAll();
    @Update("update room set isBook = #{isBook}where id = ${id}")
    void updateRoomStatus(Room room);
    @Select("select *from room where id = #{id}")
    Room findRoomById(int id);
}
