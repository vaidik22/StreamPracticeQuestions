package tasks.task4.code;

//a private field to store the video id of the video, as a primitive long type value. This should be immutable!
//a private field to store the name of the video, as a reference String type value. This should be immutable!
//a private field to store the number of likes, as a reference BigInteger type value.
//a private field to store the duration of video in minutes, as a primitive int type value.
//the necessary getter/setter methods for the private fields, at least two constructors for this class, the equals(), toString() and the hashCode() methods.

import java.math.BigInteger;
import java.util.Objects;

public class YouTubeVideo {
    private final long videoId;
    private final String videoName;
    private BigInteger numberOfLikes;
    private int durationOfVideoInMinutes;

    public YouTubeVideo() {
        this.videoId = 123456789L;
        this.videoName = "Earn Money";
        this.durationOfVideoInMinutes = 5;
        this.numberOfLikes = BigInteger.valueOf(5000);
    }

    public YouTubeVideo(long videoId, String videoName, BigInteger numberOfLikes, int durationOfVideoInMinutes) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.numberOfLikes = numberOfLikes;
        this.durationOfVideoInMinutes = durationOfVideoInMinutes;
    }

    public long getVideoId() {
        return videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public BigInteger getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(BigInteger numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getDurationOfVideoInMinutes() {
        return durationOfVideoInMinutes;
    }

    public void setDurationOfVideoInMinutes(int durationOfVideoInMinutes) {
        this.durationOfVideoInMinutes = durationOfVideoInMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YouTubeVideo that = (YouTubeVideo) o;
        return videoId == that.videoId && durationOfVideoInMinutes == that.durationOfVideoInMinutes && Objects.equals(videoName, that.videoName) && Objects.equals(numberOfLikes, that.numberOfLikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, videoName, numberOfLikes, durationOfVideoInMinutes);
    }

    @Override
    public String toString() {
        return "YouTubeVideo{" +
                "videoId=" + videoId +
                ", videoName='" + videoName + '\'' +
                ", numberOfLikes=" + numberOfLikes +
                ", durationOfVideoInMinutes=" + durationOfVideoInMinutes +
                '}';
    }
}
