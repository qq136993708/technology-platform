package om.pcitc.base.stp.equipment;

import java.util.Date;

public class SreInformationDelivery {
    private Integer id;

    private String researchinstitute;

    private String informationTitle;

    private String informationType;

    private String informationPublisher;

    private String informationText;

    private Date informationMonth;

    private String informationState;

    private String sonId;

    private String levelId;

    private Date creationTime;

    private String levelName;

    private String numberCompliments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResearchinstitute() {
        return researchinstitute;
    }

    public void setResearchinstitute(String researchinstitute) {
        this.researchinstitute = researchinstitute;
    }

    public String getInformationTitle() {
        return informationTitle;
    }

    public void setInformationTitle(String informationTitle) {
        this.informationTitle = informationTitle;
    }

    public String getInformationType() {
        return informationType;
    }

    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    public String getInformationPublisher() {
        return informationPublisher;
    }

    public void setInformationPublisher(String informationPublisher) {
        this.informationPublisher = informationPublisher;
    }

    public String getInformationText() {
        return informationText;
    }

    public void setInformationText(String informationText) {
        this.informationText = informationText;
    }

    public Date getInformationMonth() {
        return informationMonth;
    }

    public void setInformationMonth(Date informationMonth) {
        this.informationMonth = informationMonth;
    }

    public String getInformationState() {
        return informationState;
    }

    public void setInformationState(String informationState) {
        this.informationState = informationState;
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

    public String getNumberCompliments() {
        return numberCompliments;
    }

    public void setNumberCompliments(String numberCompliments) {
        this.numberCompliments = numberCompliments;
    }
}