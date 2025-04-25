import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import Login from './login';
import User, { IRole } from '../core/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _authorization?: string;
  private _user?: User;

  constructor(private http: HttpClient) { }

  public login(login: Login) {
    this._authorization = "Basic " + btoa(login.username + ":" + login.password);
    this.getRole(login.username);
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

  public getUser(): User | null {
    if(this._user) {
      return this._user;
    }
    else {
      return null;
    }
  }

  private getRole(username: string) {
    this.http.get<User>(environment.apiUrl + `rentUser/login/${username}`)
      .subscribe(user => this._user = {...user});
  }
}
