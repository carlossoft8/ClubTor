package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.EventModel;

@Repository
public interface IEventRepository extends JpaRepository<EventModel, Long>  {

}
