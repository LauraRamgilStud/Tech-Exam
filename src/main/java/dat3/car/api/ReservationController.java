package dat3.car.api;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
  ReservationService service;

  public ReservationController(ReservationService service) {
    this.service = service;
  }

  @PostMapping("/reserve")
  ReservationResponse makeReservation(@RequestBody ReservationRequest res, Principal principal){
    res.setUserName(principal.getName());
    ReservationResponse r = service.reserveCar(res);
    return r;
  }

  @GetMapping
  public List<ReservationResponse> getReservations(){
    List<ReservationResponse> res = service.getReservations();
    return res;
  }

  @GetMapping("reservations-for-authenticated")
  public List<ReservationResponse> getReservationsForUser(Principal principal){
    List<ReservationResponse> res = service.getReservationsByUsername(principal.getName());
    return res;
  }
}
