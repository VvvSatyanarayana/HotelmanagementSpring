package com.capgemini.hmp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hmp.model.Room;
import com.capgemini.hmp.service.RoomService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class RController {
	
	@GetMapping("/msg")
	public String getMessage(){
		return "hello world";
	}
	
	@Autowired
	private RoomService eservice;
	
	@PostMapping("/saveroom")
	public ResponseEntity<Room> saveRoom(@RequestBody Room room){
	System.out.println(room);
	return new ResponseEntity<Room>(eservice.saveRoom(room), HttpStatus.OK);
	}
	
	@GetMapping("/getallroom")
    public List<Room> getAllEmployee() {

        return eservice.getAllRoom();
    }

    @GetMapping("/getroom/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {

        Room emp = eservice.getRoomById(id);
        if (emp == null) {
            return new ResponseEntity<Object>("NO DATA FOUND!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(emp, HttpStatus.OK);
        }
    }
    
     @PutMapping("/updateroom")
    public Room updateRoom(@RequestBody Room room) {
        return eservice.updateRoom(room);
        
    }
    
    @DeleteMapping("/deleteroom/{id}")
    public String deleteRoom(@PathVariable("id") int id) {
        return eservice.deleteRoom(id);
        
        
    }

}