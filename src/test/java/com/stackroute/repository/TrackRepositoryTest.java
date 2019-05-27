package com.stackroute.repository;


import com.stackroute.model.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest
{
    @Autowired
    private TrackRepository userRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackName("Tu hi re");
        track.setComments("Good");
    }

    @After
    public void tearDown(){

        userRepository.deleteAll();
    }

    @Test
    public void testSaveTrack(){
        userRepository.save(track);
        Track fetchUser = userRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(1,fetchUser.getTrackId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testUser = new Track(1,"Tu hi re", "Good");
        userRepository.save(track);
        Track fetchUser = userRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testUser,track);
    }

    @Test
    public void testGetAllTrack() {
        Track u = new Track(2, "O piya re", "Nice");
        Track u1 = new Track(3, "Radha ", "Good");
        userRepository.save(u);
        userRepository.save(u1);

        List<Track> list = userRepository.findAll();
        Assert.assertEquals("Johny", list.get(0).getTrackName());

    }
    }
