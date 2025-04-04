import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { Observable } from 'rxjs';
import Reservation from './reservation';
import { ReservationsService } from './reservations.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-reservations',
  imports: [CommonModule, MatToolbarModule, MatIconModule, MatCardModule, MatButtonModule],
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