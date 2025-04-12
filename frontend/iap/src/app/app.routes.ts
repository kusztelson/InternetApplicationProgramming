import { Routes } from '@angular/router';
import { CarsComponent } from './cars/cars.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { HelloComponent } from './hello/hello.component';
import { RentComponent } from './rent/rent.component';

export const routes: Routes = [
    {path: "", redirectTo: "/hello", pathMatch: "full"},
    {path: "hello", component: HelloComponent},
    {path: "cars", component: CarsComponent},
    {path: "reservations", component: ReservationsComponent},
    {path: "cars/rent/:id", component: RentComponent}
];
