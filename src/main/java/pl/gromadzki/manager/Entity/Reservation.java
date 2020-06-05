package pl.gromadzki.manager.Entity;

import pl.gromadzki.manager.Entity.POJO.RoomType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private Long id;
    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;
    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;
    @Column(name = "RESERVATION_TIME")
    private LocalDate reservationTime;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDate reservationTime) {
        this.reservationTime = reservationTime;
    }
}
