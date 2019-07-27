package com.pcitc.base.stp.equipment;

import java.util.Date;

public class SrePlanImplement {
    private String id;

    private String researchinstitute;

    private String publicationTitle;

    private String publicationType;

    private String publisher;

    private String publicationText;

    private Date publicationMonth;

    private String publicationState;

    private String sonId;

    private String levelId;

    private Date creationTime;

    private String levelName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResearchinstitute() {
        return researchinstitute;
    }

    public void setResearchinstitute(String researchinstitute) {
        this.researchinstitute = researchinstitute;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationText() {
        return publicationText;
    }

    public void setPublicationText(String publicationText) {
        this.publicationText = publicationText;
    }

    public Date getPublicationMonth() {
        return publicationMonth;
    }

    public void setPublicationMonth(Date publicationMonth) {
        this.publicationMonth = publicationMonth;
    }

    public String getPublicationState() {
        return publicationState;
    }

    public void setPublicationState(String publicationState) {
        this.publicationState = publicationState;
    }

    public String getSonId() {
        return sonId;
    }

    public void setSonId(String sonId) {
        this.sonId = sonId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

	@Override
	public String toString() {
		return "SrePlanningManagement [id=" + id + ", researchinstitute=" + researchinstitute + ", publicationTitle="
				+ publicationTitle + ", publicationType=" + publicationType + ", publisher=" + publisher
				+ ", publicationText=" + publicationText + ", publicationMonth=" + publicationMonth
				+ ", publicationState=" + publicationState + ", sonId=" + sonId + ", levelId=" + levelId
				+ ", creationTime=" + creationTime + ", levelName=" + levelName + "]";
	}
    
    
}