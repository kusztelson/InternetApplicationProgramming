import { Routes } from '@angular/router';
import { CarsComponent } from './cars/cars.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { HelloComponent } from './hello/hello.component';
import { CarEditComponent } from './car-edit/car-edit.component';
import { LoginComponent } from './login/login.component';
import { userGuard } from './core/user.guard';

export const routes: Routes = [
    {path: "", component: LoginComponent},
    {path: "hello", component: HelloComponent, canActivate: [userGuard]},
    {path: "cars", component: CarsComponent},
    {path: "reservations", component: ReservationsComponent},
    {path: "cars/edit/:carId", component: CarEditComponent}
];
