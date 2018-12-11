package com.office.dao;

import com.office.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component

public interface PositionDAO extends CrudRepository<Position, Long> {

}
