import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';
import { Car } from './car.model'; 
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${environment.apiUrl}cars`);
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${environment.apiUrl}car/${id}`);
  }

  saveCarChanges(car: Car, priceInput: number): Observable<Car> {
    car.pricePerDay = priceInput
    return this.http.put<Car>(`${environment.apiUrl}cars/edit/${car.id}`, car, this.httpOptions);
  }
}
