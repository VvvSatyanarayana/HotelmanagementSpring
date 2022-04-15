
package com.capgemini.hmp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.hmp.model.Room;


@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

	List<Room> findAll();
}
