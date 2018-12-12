package com.office.dao;

import com.office.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionDAO extends CrudRepository<Position, Long> {

}
