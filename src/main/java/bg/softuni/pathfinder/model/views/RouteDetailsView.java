package bg.softuni.pathfinder.model.views;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.enums.Level;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class RouteDetailsView {

    private Long id;
    private String gpxCoordinates;
    private String level;
    private String name;
    private String description;
    private String authorName;
    private String videoUrl;
    private List<String> picturesUrl;

    public RouteDetailsView(Long id, String gpxCoordinates, String level, String name,
                            String description, String authorName,
                            String videoUrl, List<String> picturesUrl) {
        this.id = id;
        this.gpxCoordinates = gpxCoordinates;
        this.level = level;
        this.name = name;
        this.description = description;
        this.authorName = authorName;
        this.videoUrl = videoUrl;
        this.picturesUrl = picturesUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<String> getPicturesUrl() {
        return picturesUrl;
    }

    public void setPicturesUrl(List<String> picturesUrl) {
        this.picturesUrl = picturesUrl;
    }
}
