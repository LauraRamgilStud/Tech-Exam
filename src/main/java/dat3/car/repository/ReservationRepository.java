package dat3.car.repository;

import dat3.car.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    boolean existsByCarIdAndRentalDate(int carId, LocalDate date);

    List<Reservation> findAllByMemberUsername(String username);
}
