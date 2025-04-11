import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationComponent } from '../reservation/reservation.component';
import { Observable } from 'rxjs';
import Reservation from '../reservation/reservation';
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
}