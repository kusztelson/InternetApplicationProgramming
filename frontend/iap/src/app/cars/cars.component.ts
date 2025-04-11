import {Component,OnInit} from '@angular/core';
import { CarsService } from './cars.service';
import { Car } from './car.model';
import { CardCarComponent } from '../card-car/card-car.component';

@Component({
  selector: 'app-cars',
  imports: [CardCarComponent],
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.scss',
})
export class CarsComponent  implements OnInit {
  cars: Car[] = [];
  isLoading = true;
  errorMessage = '';
  
  constructor(private carsService: CarsService) { }

  ngOnInit(): void {
    this.loadCars();
  }

  loadCars(): void {
    this.carsService.getCars().subscribe({
      next: (data) => {
        this.cars = data;
        this.cars = data.sort((a, b) => a.pricePerDay - b.pricePerDay); // Sorting in ascending order
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error loading cars', err);
        this.errorMessage = 'Failed to load cars. Please try again later.';
        this.isLoading = false;
      }
    });
  }
}