import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from './car.model'; 


@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private apiUrl = 'http://localhost:8080'; // Your Spring backend URL

  constructor(private http: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/cars`);
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.apiUrl}/car/${id}`);
  }
}
