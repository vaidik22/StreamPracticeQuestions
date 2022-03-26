package tasks.task4.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task4.code.VideoAnalytics;
import tasks.task4.code.YouTubeVideo;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class VideoAnalyticsTest {
    private VideoAnalytics videoAnalytics;

    @BeforeEach
    void setUp() {
        videoAnalytics = new VideoAnalytics();
    }

    @AfterEach
    void tearDown() {
    }

    private YouTubeVideo createFakeVideo() {
        Faker faker = new Faker(new Locale("en-IND"));
        return new YouTubeVideo(faker.number().randomNumber(),
                String.valueOf(faker.funnyName()),
                BigInteger.valueOf(faker.number().randomNumber()),
                faker.number().numberBetween(1, 120));
    }

    private List<YouTubeVideo> createFakeListOfVideo(int number) {
        List<YouTubeVideo> videoList = new ArrayList<>();

        for (int index = 0; index < number; index++) {
            videoList.add(createFakeVideo());
        }
        return videoList;
    }

    @Test
    void getTopTenViralVideos() {
        var fakeVideoList = createFakeListOfVideo(10);
        var expected = (HashSet<YouTubeVideo>) fakeVideoList.stream()
                .sorted(Comparator.comparing(YouTubeVideo::getNumberOfLikes)
                        .thenComparing(YouTubeVideo::getDurationOfVideoInMinutes)).limit(10).collect(Collectors.toSet());
        var actual = videoAnalytics.getTopTenViralVideos(fakeVideoList);
        Assertions.assertEquals(expected, actual, "Not viral videos");
    }

    private Set<YouTubeVideo> createFakeSetOfVideo(int number) {
        Set<YouTubeVideo> videoList = new HashSet<>();

        for (int index = 0; index < number; index++) {
            videoList.add(createFakeVideo());
        }
        return videoList;
    }

    @Test
    void showDetailsOfShortVideos() {
        var fakeVideoSet = createFakeSetOfVideo(10);
        var expected = fakeVideoSet.stream()
                .filter(youTubeVideo -> youTubeVideo.getDurationOfVideoInMinutes() <= 10)
                .map(video -> video.getVideoName().concat(" - ")
                        .concat(String.valueOf(video.getNumberOfLikes()))
                        .concat(String.valueOf(video.getDurationOfVideoInMinutes()))).toList();
        var actual = videoAnalytics.showDetailsOfShortVideos(fakeVideoSet);
        Assertions.assertEquals(expected, actual, "This is not short Videos set");
    }
}