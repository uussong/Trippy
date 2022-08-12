package com.ssafy.trippy.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class DetailLocation extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name="DETAIL_LOCATION_ID")
    private Long id;

//    @Column(nullable = false)
//    @NotBlank(message="상세지역명을 입력하세요")
    private String detailLocationName;

//    @Column(nullable = false)
//    @NotBlank(message="별점을 입력하세요")
    private float rating;

//    @Column(nullable = false)
//    @NotBlank(message="상세지역글을 입력하세요")
    private String detailLocationContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="POST_ID")
    private Post post;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOCATION_ID")
    private Location location;

    public void setPost(Post post){
        this.post = post;
        post.getDetailLocations().add(this);
    }

    @Builder
    public DetailLocation(Long id, String detailLocationName, float rating, String detailLocationContent,Post post, Location location) {
        this.id=id;
        this.detailLocationContent = detailLocationContent;
        this.detailLocationName = detailLocationName;
        this.rating = rating;
        this.post = post;
        this.location = location;
    }


    public void update(String detailLocationContent, String detailLocationName, float rating){
        this.detailLocationContent = detailLocationContent;
        this.detailLocationName = detailLocationName;
        this.rating = rating;
    }

}
