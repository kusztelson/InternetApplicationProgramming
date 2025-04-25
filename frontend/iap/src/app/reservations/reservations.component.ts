import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationComponent } from '../reservation/reservation.component';
import { Observable } from 'rxjs';
import Reservation from './reservation';
// import { ReservationsService } from '../reservation/reservation.service';
import { ReservationsService } from './reservations.service';


@Component({
  selector: 'app-reservations',
  imports: [CommonModule, ReservationComponent],
  templateUrl: './reservations.component.html',
  styleUrl: './reservations.component.scss'
})
export class ReservationsComponent {
  reservations$?: Observable<Reservation[]>
    
  constructor(private service: ReservationsService) {}
  
  ngOnInit(): void {
    this.reservations$ = this.service.getReservations()
  }

  deleteReservation(id: number): void {
    this.service.deleteReservation(id).subscribe();
    // this.service.deleteReservation(id).subscribe({
    //   next: (response) => {
    //     console.log('Deleted successfully', response);
    //   },
    //   error: (err) => {
    //     console.error('Delete failed', err);
    //   }
    // });
  }

  deleteReservationInView(reservations: Reservation[], reservation: Reservation): void {
    let index = reservations.indexOf(reservation);
    reservations.splice(index, 1);
  }
}