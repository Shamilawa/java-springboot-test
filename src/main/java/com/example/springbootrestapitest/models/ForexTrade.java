package com.example.springbootrestapitest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ForexTrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;
    private String symbol;
    private String tradeType;
    private BigDecimal volume;
    private BigDecimal entryPrice;
    private LocalDateTime entryTime;
    private BigDecimal exitPrice;
    private LocalDateTime exitTime;
    private BigDecimal profitLoss;
    private String notes;
    private String entryScreenshotUrl;
    private String exitScreenshotUrl;

    public ForexTrade() {
        // Default constructor
    }

    // Constructor without tradeId for convenience
    public ForexTrade(Long tradeId, String symbol, String tradeType, BigDecimal volume, BigDecimal entryPrice,
            LocalDateTime entryTime, BigDecimal exitPrice, LocalDateTime exitTime, BigDecimal profitLoss,
            String notes) {
        this.tradeId = tradeId;
        this.symbol = symbol;
        this.tradeType = tradeType;
        this.volume = volume;
        this.entryPrice = entryPrice;
        this.entryTime = entryTime;
        this.exitPrice = exitPrice;
        this.exitTime = exitTime;
        this.profitLoss = profitLoss;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public BigDecimal getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(BigDecimal exitPrice) {
        this.exitPrice = exitPrice;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public BigDecimal getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(BigDecimal profitLoss) {
        this.profitLoss = profitLoss;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEntryScreenshotUrl() {
        return entryScreenshotUrl;
    }

    public void setEntryScreenshotUrl(String entryScreenshotUrl) {
        this.entryScreenshotUrl = entryScreenshotUrl;
    }

    public String getExitScreenshotUrl() {
        return exitScreenshotUrl;
    }

    public void setExitScreenshotUrl(String exitScreenshotUrl) {
        this.exitScreenshotUrl = exitScreenshotUrl;
    }
}
