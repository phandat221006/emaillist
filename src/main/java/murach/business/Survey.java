package murach.business;

import java.io.Serializable;

public class Survey implements Serializable {

    private String source;               // heardFrom
    private boolean receiveAnnouncements;
    private boolean receiveOffers;
    private String contactMethod;        // contactBy

    public Survey() {
        source = "";
        receiveAnnouncements = false;
        receiveOffers = false;
        contactMethod = "";
    }

    public Survey(String source, boolean receiveAnnouncements,
                  boolean receiveOffers, String contactMethod) {
        this.source = source;
        this.receiveAnnouncements = receiveAnnouncements;
        this.receiveOffers = receiveOffers;
        this.contactMethod = contactMethod;
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public boolean isReceiveAnnouncements() { return receiveAnnouncements; }
    public void setReceiveAnnouncements(boolean receiveAnnouncements) {
        this.receiveAnnouncements = receiveAnnouncements;
    }

    public boolean isReceiveOffers() { return receiveOffers; }
    public void setReceiveOffers(boolean receiveOffers) {
        this.receiveOffers = receiveOffers;
    }

    public String getContactMethod() { return contactMethod; }
    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }
}