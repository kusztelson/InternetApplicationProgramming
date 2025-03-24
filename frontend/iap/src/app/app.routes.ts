import { Routes } from '@angular/router';
import { CarsComponent } from './cars/cars.component';
import { ReservationsComponent } from './reservations/reservations.component';

export const routes: Routes = [
    {path: "cars", component: CarsComponent},
    {path: "reservations", component: ReservationsComponent},
];
