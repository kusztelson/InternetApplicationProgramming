import { Component, Input } from '@angular/core';
import { Car } from '../cars/car.model';
import { Observable } from 'rxjs';
import { CarsService } from '../cars/cars.service';
import { CommonModule } from '@angular/common';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { CardCarComponent } from '../card-car/card-car.component';
import { ActivatedRoute } from '@angular/router';
import {provideNativeDateAdapter} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import Reservation from '../reservations/reservation';
import { ReservationsService } from '../reservations/reservations.service';
import { map } from 'rxjs/operators';
import {MatTableModule} from '@angular/material/table';
import { tap } from 'rxjs/operators'
@Component({
  selector: 'app-rent',
  imports: [CommonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    MatButtonModule,
    MatCardModule,
    CardCarComponent,
    MatDatepickerModule,
    MatTableModule
    ],
  providers: [provideNativeDateAdapter()],
  templateUrl: './rent.component.html',
  styleUrl: './rent.component.scss'
})


export class RentComponent {
  carId!: number
  car!: Observable<Car>
  reservations$?: Observable<Reservation[]>
  displayedColumns: string[] = ['startDate', 'endDate']; 

  
  constructor(private route: ActivatedRoute,private carsService: CarsService,private reservationsService: ReservationsService) {}
  ngOnInit(): void {
    this.carId = Number(this.route.snapshot.paramMap.get('id'));
    this.car = this.carsService.getCarById(this.carId)
    this.reservations$ = this.reservationsService.getReservations().pipe(
      tap(reservations => console.log('Reservations data:', reservations))).pipe(
       map((reservations: Reservation[]) =>
         reservations.filter(r => r.carId.id === this.carId)
       ))
    
      
  }
  
  
}



  

