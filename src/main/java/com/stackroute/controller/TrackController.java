package com.stackroute.controller;

import com.stackroute.TrackService;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackGlobalExceptionHandling;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    @Autowired
    private TrackService trackService;

    public TrackService getTrackService() {
        return trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/music")
    public ResponseEntity<Track> addMusic(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<>(trackService.addMusic(track), HttpStatus.OK);
        }
        catch (TrackAlreadyExistsException ex)
        {
            responseEntity = new ResponseEntity <String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return  responseEntity;
    }

    @PutMapping("/music/{id}")
    public ResponseEntity<Track> updateMusic(@RequestBody Track track,@PathVariable int id)
    {
        ResponseEntity responseEntity;
        try{
        track.setTrackId(id);
        return new ResponseEntity<>(trackService.addMusic(track), HttpStatus.OK);
         }
        catch (TrackAlreadyExistsException ex)
        {
            responseEntity = new ResponseEntity <String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/music")
    public ResponseEntity<List<Track>> getAddMusic()
    {
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<>(trackService.getAllMusic(), HttpStatus.OK);
        }
        catch (TrackNotFoundException ex)
        {
            responseEntity = new ResponseEntity <String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @Value("${delete.message}")
    private String deleteMessage;
    @DeleteMapping("/music/{id}")
    public ResponseEntity<String> deleteMusic(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteMusic(id);
            return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
            //return new ResponseEntity<Track>(trackService.deleteMusic(id), HttpStatus.OK);
        } catch (TrackGlobalExceptionHandling ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/track/{trackName}")
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String track)
        {
            ResponseEntity responseEntity;
            try {
                List<Track> trackList = trackService.getTrackByName(track);
                return new ResponseEntity<List<Track>>(trackList, HttpStatus.OK);
            }
            catch (Exception ex)
            {
                responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
                ex.printStackTrace();
            }
            return responseEntity;
        }


}
