import { Component, Input,OnInit } from '@angular/core';
import { Car } from '../cars/car.model';
import { Router } from '@angular/router';

import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
@Component({
  selector: 'app-card-car',
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './card-car.component.html',
  styleUrl: './card-car.component.scss'
})
export class CardCarComponent {
  @Input() car!: Car;
  @Input() showRentButton: boolean = true;
  constructor(private router: Router) {}

  onRentClick(carId: number) {
    this.router.navigate(['/cars/rent', carId]);
  }
}
