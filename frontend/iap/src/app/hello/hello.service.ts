import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  constructor(private http: HttpClient) { }

  public getHello(): Observable<any> {
    return this.http.get(environment.apiUrl + "hello", {
      responseType: "text",
      headers: {
        "Authorization": "Basic dXNlcjpwYXNzd29yZA=="
      } })
  }
}
