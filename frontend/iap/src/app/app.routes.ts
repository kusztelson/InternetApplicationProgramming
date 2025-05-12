import { Routes } from '@angular/router';
import { CarsComponent } from './cars/cars.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { HelloComponent } from './hello/hello.component';
import { RentComponent } from './rent/rent.component';
import { CarEditComponent } from './car-edit/car-edit.component';
import { LoginComponent } from './login/login.component';
import { userGuard } from './core/user.guard';
import { adminGuard } from './core/admin.guard';
import { UserReservationsComponent } from './user-reservations/user-reservations.component';

export const routes: Routes = [
    {path: "", component: LoginComponent},
    {path: "hello", component: HelloComponent, canActivate: [userGuard]},
    {path: "cars", component: CarsComponent},
    {path: "reservations", component: ReservationsComponent, canActivate: [adminGuard]},
    {path: "cars/rent/:id", component: RentComponent, canActivate: [userGuard]},
    {path: "cars/edit/:carId", component: CarEditComponent, canActivate: [adminGuard]},
    {path: "reservations/user/:userId", component: UserReservationsComponent}
];
