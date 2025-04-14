import { Component, Input, Output, EventEmitter } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { Observable } from 'rxjs';
// import Reservation from './reservation';
// import { ReservationsService } from './reservation.service';
import { ReservationsService } from '../reservations/reservations.service';
import { CommonModule } from '@angular/common';
import { Car } from '../cars/car.model';


@Component({
  selector: 'app-reservation',
  imports: [CommonModule, MatToolbarModule, MatIconModule, MatCardModule, MatButtonModule],
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.scss',
  standalone: true
})

export class ReservationComponent {
  @Input() car!: Car
  @Input() reservationId!: number;
  @Input() reservationStartDate!: string;
  @Input() reservationEndDate!: string;

  @Output() cancelButtonClicked = new EventEmitter<number>();

  deleteThisReservation(value: number) {
    this.cancelButtonClicked.emit(value);
  }
  
}