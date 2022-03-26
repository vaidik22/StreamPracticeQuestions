package tasks.task4.code;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VideoAnalytics {
    //This method inputs a list of YouTubeVideo type and returns a hash set of YouTubeVideo type.
    //This method will iterate through the list of videos it has received, and it should find out the
    //top 10 videos with the most-number of likes, then store those videos in a HashSet and return it.
    //If two videos have the same number of likes, use duration.
    public HashSet<YouTubeVideo> getTopTenViralVideos(List<YouTubeVideo> videos) {
        return videos.stream().sorted(Comparator.comparing(YouTubeVideo::getNumberOfLikes)
                        .thenComparing(YouTubeVideo::getDurationOfVideoInMinutes)).limit(10)
                .collect(Collectors.toCollection(HashSet<YouTubeVideo>::new));
    }

    //This method inputs a set of YouTubeVideo type and returns a list of String type.
    //A short video is one whose duration is less than or equal to 10 minutes.
    //Find all such videos and store the name, number of likes and duration of the video
    //into a String, and store all such strings into a list and return it from the method.
    private String detailsOfVideo(YouTubeVideo youTubeVideo) {
        return youTubeVideo.getVideoName().concat(" - ")
                .concat(String.valueOf(youTubeVideo.getNumberOfLikes()))
                .concat(String.valueOf(youTubeVideo.getDurationOfVideoInMinutes()));
    }

    public List<String> showDetailsOfShortVideos(Set<YouTubeVideo> videos) {
        return videos.stream().filter(e -> e.getDurationOfVideoInMinutes() <= 10)
                .map(this::detailsOfVideo).toList();
    }
}

