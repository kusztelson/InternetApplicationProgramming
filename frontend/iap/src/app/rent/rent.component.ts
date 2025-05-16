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
import { ReservationsService } from '../reservations/reservations.service';
import { LoginService } from '../login/login.service';
import { HttpClient } from '@angular/common/http';
import { formatDate } from '@angular/common';
import { map } from 'rxjs/operators';
import {MatTableModule} from '@angular/material/table';
import { Router } from '@angular/router';
import { tap } from 'rxjs/operators'
import Reservation from '../reservations/reservation';
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
  displayedColumns: string[] = ['startDate', 'endDate']
  startDate: Date | null = null;
  endDate: Date | null = null; 
  userId!: undefined | number;

  constructor(private route: ActivatedRoute,private carsService: CarsService,private reservationsService: ReservationsService, private loginService: LoginService,private http: HttpClient,private router: Router) {}
  ngOnInit(): void {
    this.carId = Number(this.route.snapshot.paramMap.get('id'));
    this.car = this.carsService.getCarById(this.carId);
    this.reservations$ = this.reservationsService.getReservations().pipe(
      tap(reservations => console.log('Reservations data:', reservations)),
      map((reservations: Reservation[]) =>
        reservations.filter(r => r.carId.id === this.carId)
      )
    );
    this.userId = this.loginService.getUser()?.id;
  }

  makeReservation(reservations: Reservation[]) {
  if (!this.startDate || !this.endDate || !this.userId) {
    alert("Please select both dates and make sure you're logged in.");
    return;
  }

  const today = new Date();
  today.setHours(0, 0, 0, 0); // remove time portion for accurate comparison

  if (this.startDate < today || this.endDate < today) {
    alert("Reservation dates must be in the future.");
    return;
  }

  if (this.endDate < this.startDate) {
    alert("End date must be after start date.");
    return;
  }

  const isConflict = reservations.some(res => {
    const existingStart = new Date(res.startDate);
    const existingEnd = new Date(res.endDate);
    return (
      this.startDate! <= existingEnd &&
      this.endDate! >= existingStart
    );
  });

  if (isConflict) {
    alert("Selected dates overlap with an existing reservation.");
    return;
  }

  const request = {
    carId: this.carId,
    userId: this.userId,
    startDate: formatDate(this.startDate!, 'yyyy-MM-dd', 'en-US'),
    endDate: formatDate(this.endDate!, 'yyyy-MM-dd', 'en-US'),
  };

  this.http.post('http://localhost:8080/addReservation', request).subscribe({
    next: () => {
      alert("Reservation created successfully!");
      this.router.navigate(['reservations/user', this.userId]);
      // Optionally reset form or refresh reservations
    },
    error: err => {
      console.error(err);
      alert("Error creating reservation.");
      console.log(request);
    }
  });
}
onBookClick() {
  this.reservations$?.subscribe(res => this.makeReservation(res));
}

}

  

