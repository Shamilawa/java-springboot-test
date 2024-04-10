package com.example.springbootrestapitest.repository;

import com.example.springbootrestapitest.models.ForexTrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForexTradeRepository extends JpaRepository<ForexTrade, Long> {
}
