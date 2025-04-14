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

@Component({
  selector: 'app-car',
  imports: [CommonModule,
     MatInputModule,
     MatFormFieldModule,
     FormsModule,
     MatButtonModule,
     MatCardModule],
  templateUrl: './car.component.html',
  styleUrl: './car.component.scss'
})
export class CarComponent {
  @Input() carId!: number
  priceInput: string = ""
  newPrice: number = 0.0
  car$?: Observable<Car>

    constructor(private service: CarsService) {}
    
    ngOnInit(): void {
      this.car$ = this.service.getCarById(this.carId)
    }

    parseInputToNumber() {
      try
      {
        this.newPrice = parseFloat(this.priceInput)
      }
      catch {}
    }

    saveChanges(car: Car): void {
      this.service.saveCarChanges(car, this.newPrice).subscribe(
        (response) => {
          console.log(response)
          this.priceInput = ""
        }
      )
    }
}
