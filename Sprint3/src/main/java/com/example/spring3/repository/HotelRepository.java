package com.example.spring3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring3.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
