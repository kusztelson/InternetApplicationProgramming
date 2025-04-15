import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  constructor(private http: HttpClient, private loginService: LoginService) { }

  public getHello(): Observable<any> {
    return this.http.get(environment.apiUrl + "hello", {
      responseType: "text"
    })
  }
}
