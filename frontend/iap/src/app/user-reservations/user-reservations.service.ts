import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import Reservation from './user-reservation';

@Injectable({
  providedIn: 'root'
})
export class UserReservationsService {

  constructor(private http: HttpClient) { }
  
    public getUserReservations(userId: number): Observable<Reservation[]> {
      return this.http.get<any[]>(environment.apiUrl + `reservations/user/${userId}`)
    }

    public deleteReservation(id: number) {
      return this.http.delete<Reservation>(environment.apiUrl + `reservations/delete/${id}`)
    }
}
