import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { ReservationComponent } from '../reservation/reservation.component';


@Component({
  selector: 'app-reservations',
  imports: [CommonModule, MatToolbarModule, MatIconModule, MatCardModule, MatButtonModule, ReservationComponent],
  templateUrl: './reservations.component.html',
  styleUrl: './reservations.component.scss'
})
export class ReservationsComponent {

}