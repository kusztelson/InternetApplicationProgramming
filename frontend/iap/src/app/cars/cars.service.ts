import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';
import { Car } from './car.model'; 


@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private apiUrl = 'http://localhost:8080'; // Your Spring backend URL
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/cars`);
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.apiUrl}/car/${id}`);
  }

  saveCarChanges(car: Car, priceInput: number): Observable<Car> {
    car.pricePerDay = priceInput
    console.log(car)
    return this.http.post<Car>(`${this.apiUrl}/cars/edit/${car.id}`, car, this.httpOptions);
  }
}
