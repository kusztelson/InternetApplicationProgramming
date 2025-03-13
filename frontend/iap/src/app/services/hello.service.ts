import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  constructor(private http: HttpClient) { }

  public getHello(): Observable<String> {
    return this.http.get<String>(environment.apiUrl + "hello")
  }
}
