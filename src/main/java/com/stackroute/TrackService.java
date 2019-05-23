package com.stackroute;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackGlobalExceptionHandling;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.model.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public TrackRepository getTrackRepository() {
        return trackRepository;
    }

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Track addMusic(Track track) throws TrackAlreadyExistsException
    {
        return trackRepository.save(track);
    }

    public List<Track> getAllMusic() throws TrackNotFoundException
    {
        return trackRepository.findAll();
    }
    public void deleteMusic(int id) throws TrackGlobalExceptionHandling
    {
         trackRepository.deleteById(id);
    }

    public List<Track> getTrackByName(String trackName) throws Exception
    {
        return trackRepository.getTrackByName(trackName);
    }

}
