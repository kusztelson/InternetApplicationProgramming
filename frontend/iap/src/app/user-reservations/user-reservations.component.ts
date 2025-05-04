import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationComponent } from '../reservation/reservation.component';
import { Observable } from 'rxjs';
import Reservation from './user-reservation';
// import { ReservationsService } from '../reservation/reservation.service';
import { UserReservationsService } from './user-reservations.service';


@Component({
  selector: 'app-reservations',
  imports: [CommonModule, ReservationComponent],
  templateUrl: './user-reservations.component.html',
  styleUrl: './user-reservations.component.scss'
})
export class UserReservationsComponent {
  reservations$?: Observable<Reservation[]>
    
  constructor(private service: UserReservationsService) {}
  
  ngOnInit(): void {
    this.reservations$ = this.service.getUserReservations(1)
  }

  deleteReservation(id: number): void {
    this.service.deleteReservation(id).subscribe();
  }

  deleteReservationInView(reservations: Reservation[], reservation: Reservation): void {
    let index = reservations.indexOf(reservation);
    reservations.splice(index, 1);
  }
}