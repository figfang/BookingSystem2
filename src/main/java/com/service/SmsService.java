package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    
    private static final Logger log = LoggerFactory.getLogger(SmsService.class);
    
    // 新增訂位通知
    public void notifyBookingCreated(String phone, String bookingId) {
        String message = "您已成功預訂座位，訂位編號：" + bookingId;
        log.info("發送簡訊至: " + phone);
        log.info("簡訊內容: " + message);
    }
    
    // 修改訂位通知
    public void notifyBookingUpdated(String phone, String bookingId) {
        String message = "您的訂位已更新，訂位編號：" + bookingId;
        log.info("發送簡訊至: " + phone);
        log.info("簡訊內容: " + message);
    }
    
    // 取消訂位通知
    public void notifyBookingCancelled(String phone, String bookingId) {
        String message = "您的訂位已取消，訂位編號：" + bookingId;
        log.info("發送簡訊至: " + phone);
        log.info("簡訊內容: " + message);
    }
}