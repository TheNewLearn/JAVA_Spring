package com.example.demo2.repositories;
import com.example.demo2.entities.Billboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillboardRepository extends JpaRepository<Billboard,Long> {

}
