import {ChangeDetectionStrategy, Component,OnInit} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { CarsService } from './cars.service';
import { Car } from './car.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cars',
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './cars.component.html',
  styleUrl: './cars.component.scss',
})
export class CarsComponent  implements OnInit {
  cars: Car[] = [];
  isLoading = true;
  errorMessage = '';
  
  constructor(private carsService: CarsService,
    private router: Router) { }

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

  editCar(car: Car): void {
    this.router.navigate(['cars/edit/', car.id])
  }
}