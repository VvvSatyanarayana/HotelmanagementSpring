package com.capgemini.hmp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hmp.model.Room;
import com.capgemini.hmp.repository.RoomRepository;


@Service
public class RoomService {
	
	@Autowired
	RoomRepository erepo;
	
	public Room saveRoom(Room emp) {
		return erepo.save(emp);
	}
	
	public List<Room> getAllRoom() {
     return erepo.findAll();     
    }

    public Room getRoomById(int id) {
       Optional<Room> op=erepo.findById(id);
        if(op.isPresent()) {
            return op.get();
        }else {
            return null;
        }
        
    }

    public Room updateRoom(Room room) {
       
        return erepo.save(room);
        
    }

    public String deleteRoom(int id) {
     
        erepo.deleteById(id);
        return "SUCCESSFULLY DELETED";
    }
}
