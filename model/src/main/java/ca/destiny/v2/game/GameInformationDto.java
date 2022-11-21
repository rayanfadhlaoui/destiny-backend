package ca.destiny.v2.game;

import ca.destiny.v2.person.common.DestinyDate;

public class GameInformationDto {
    private long id;
    private long idMainUser;
    private DestinyDate currentDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMainUser() {
        return idMainUser;
    }

    public void setIdMainUser(long idMainUser) {
        this.idMainUser = idMainUser;
    }

    public DestinyDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(DestinyDate currentDate) {
        this.currentDate = currentDate;
    }
}
