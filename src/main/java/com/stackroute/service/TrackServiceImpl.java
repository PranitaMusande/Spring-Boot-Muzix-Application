//package com.stackroute.service;
//
//import com.stackroute.exceptions.TrackAlreadyExistsException;
//import com.stackroute.exceptions.TrackNotFoundException;
//import com.stackroute.model.Track;
//import com.stackroute.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TrackServiceImpl implements TrackService
//{
//    @Autowired
//    private TrackRepository trackRepository;
//    private TrackServiceImpl trackServiceDataBase;
//
//    public void setTrackRepository(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    public TrackServiceImpl(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
//        if (trackRepository.existsById(track.getTrackId()))
//        {
//            throw new TrackAlreadyExistsException("Track already exists");
//        }
//        Track trackOne = trackRepository.save(track);
//        if (trackOne==null)
//        {
//            throw new TrackAlreadyExistsException("Track already exists");
//        }
//        return trackOne;
//    }
//
//    @Override
//    public List<Track> showAllTracks() {
//        List <Track> trackOne = (List<Track>) trackRepository.findAll();
//        return trackOne;
//    }
//
//    @Override
//    public Track updateComment(Track track) throws TrackNotFoundException {
//        if (trackRepository.existsById(track.getTrackId()))
//        {
//            Track trackOne = trackRepository.findById(track.getTrackId()).get();
//            trackOne.setComments(track.getComments());
//            trackRepository.save(trackOne);
//            return trackOne;
//        }
//        else
//        {
//            throw new TrackNotFoundException("Track not found exception");
//            //return null;
//        }
//    }
//
//    @Override
//    public boolean deleteTrack(Track track) throws TrackNotFoundException{
//        //boolean answer = false;
//        if (trackRepository.existsById(track.getTrackId()))
//        {
//            trackRepository.deleteById(track.getTrackId());
//            return true;
//        }
//        else
//        {
//            throw new TrackNotFoundException("Track not found exception");
//        }
//        //return answer;
//    }
//
//    @Override
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException{
//
//        List<Track> listOfTracks = null;
//        listOfTracks = trackRepository.getTrackByName(trackName);
//        if (listOfTracks.equals(null))
//        {
//            throw new TrackNotFoundException("Track not found exception");
//        }
//        return listOfTracks;
//    }
//}
