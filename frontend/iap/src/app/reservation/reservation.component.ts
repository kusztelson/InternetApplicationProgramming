import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { Observable } from 'rxjs';
import Reservation from './reservation';
import { ReservationsService } from './reservation.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-reservation',
  imports: [CommonModule, MatToolbarModule, MatIconModule, MatCardModule, MatButtonModule],
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.scss',
  standalone: true
})

export class ReservationComponent {
  reservations$?: Observable<Reservation[]>
  
  constructor(private service: ReservationsService) {}
  
  ngOnInit(): void {
    this.reservations$ = this.service.getReservations()
  }
}