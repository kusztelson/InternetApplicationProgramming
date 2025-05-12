import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import Login from './login';
import User, { IRole } from '../core/user';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _authorization?: string;
  private _user?: User;

  constructor(private http: HttpClient, private router: Router) { }

  public login(login: Login) {
    this._authorization = "Basic " + btoa(login.username + ":" + login.password);
    this.getRoleAndRedirect(login.username);
  }

  public getAuthHeader(): string | null {
    if(this._authorization) {
      return this._authorization;
    }
    else {
      return null;
    }
  }

  public getUserRole(): IRole | null {
    if(this._user?.role) {
      return this._user.role;
    }
    else {
      return null;
    }
  }

  public isAdmin(): boolean {
    return this.getUserRole() == "ROLE_ADMIN"
  }

  public isUser(): boolean {
    return this.getUserRole() == "ROLE_USER"
  }

  public getUser(): User | null {
    if(this._user) {
      return this._user;
    }
    else {
      return null;
    }
  }

  private getRoleAndRedirect(username: string) {
    this.http.get<User>(environment.apiUrl + `rentUser/login/${username}`)
      .pipe(catchError((error) => {
        alert("Login failed")
        return throwError(() => error)
      }))
      .subscribe(user => {
        this._user = {...user}
        if(this.isAdmin()) {
          this.router.navigate(["/reservations"])
        }
        if(this.isUser()) {
          this.router.navigate(["/cars"])
        }
      });
  }
}
