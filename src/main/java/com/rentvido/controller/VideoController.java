package com.rentvido.controller;

import com.rentvido.model.Video;
import com.rentvido.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllVideos());
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<Video>> getAvailableVideos() {
        return ResponseEntity.ok(videoService.getAvailableVideos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        return ResponseEntity.ok(videoService.getVideoById(id));
    }
} 