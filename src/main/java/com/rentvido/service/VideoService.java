package com.rentvido.service;

import com.rentvido.model.Video;
import com.rentvido.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    
    @Autowired
    private VideoRepository videoRepository;
    
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    
    public List<Video> getAvailableVideos() {
        return videoRepository.findByAvailable(true);
    }
    
    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }
    
    public Video updateVideo(Long id, Video videoDetails) {
        Video video = videoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Video not found"));
        
        video.setTitle(videoDetails.getTitle());
        video.setDirector(videoDetails.getDirector());
        video.setGenre(videoDetails.getGenre());
        video.setAvailable(videoDetails.isAvailable());
        
        return videoRepository.save(video);
    }
    
    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Video not found"));
        videoRepository.delete(video);
    }
    
    public Video getVideoById(Long id) {
        return videoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Video not found"));
    }
} 